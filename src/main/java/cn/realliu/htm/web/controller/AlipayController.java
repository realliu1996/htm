package cn.realliu.htm.web.controller;

import cn.realliu.htm.common.bean.Contract;
import cn.realliu.htm.common.bean.House;
import cn.realliu.htm.common.bean.Order;
import cn.realliu.htm.common.bean.TenantApplication;
import cn.realliu.htm.common.util.alipay.AlipayConfig;
import cn.realliu.htm.service.interfaces.ContractService;
import cn.realliu.htm.service.interfaces.HouseService;
import cn.realliu.htm.service.interfaces.OrderService;
import cn.realliu.htm.service.interfaces.TenantApplicationService;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/4/18
 * @Time: 10:42
 * @Description：支付宝扫码付款业务
 */
@Controller
@RequestMapping("/alipay")
public class AlipayController {

    @Autowired
    private ContractService contractService;
    @Autowired
    private HouseService houseService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private Order order;
    @Autowired
    private TenantApplicationService tenantApplicationService;

    //生成二维码支付页面
    @RequestMapping(value = "/goAlipay",method = {RequestMethod.GET,RequestMethod.POST})
    public void goAlipay(HttpServletRequest request, HttpServletResponse response) throws Exception {


        Integer contractId = Integer.parseInt(request.getParameter("contractId"));
        Integer houseId = Integer.parseInt(request.getParameter("houseId"));

        //获得初始化的AlipayClient
        AlipayClient alipayClient =
                new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
                                        AlipayConfig.merchant_private_key, "json", AlipayConfig.charset,
                                        AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = df.format(new Date());
        String out_trade_no = UUID.randomUUID().toString()+date;

        //付款金额，必填
        Contract contract = contractService.selectByContractId(contractId);
        //String total_amount = contract.getRentalPrice().toString()+contract.getRentalTime().toString();
        //String total_amount = contract.getRentalPrice().toString();
        String total_amount = "10";

        //订单名称，必填
        House house = houseService.selectById(houseId);
        String subject = house.getBuildNum()+house.getLayerNum()+"层"+house.getRoomNum()+"号"+"房租付款";

        //商品描述，可空
        String body = "用户订购商品个数：1";

        // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天。
        String timeout_express = "1c";

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"timeout_express\":\""+ timeout_express +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();

        //生成订单信息并入库
        order.setContractId(contractId);
        order.setHouseId(houseId);
        order.setTradeNo(out_trade_no);
        order.setAmount(total_amount);
        order.setSubject(subject);
        order.setBody(body);
        order.setStatus("E");//E-未付款 U-已付款

        orderService.insertUser(order);

        response.setContentType("text/html;charset=" + AlipayConfig.charset);
        PrintWriter out = response.getWriter();
        out.println(result);
    }

    //支付完成同步通知
    @RequestMapping(value = "/alipayReturnNotice",method = {RequestMethod.GET,RequestMethod.POST})
    public String alipayReturnNotice(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

        Map<String,String> params = getPayInfo(request);

        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

        if(signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //修改订单状态
            Order order = orderService.selectByTradeNo(out_trade_no);
            orderService.update(out_trade_no,"U");
            //修改合同状态
            contractService.contractAliPay(order.getContractId(),"U","F");

            session.setAttribute("msg","付款成功");
            return "redirect:../contract/selectByTenantId";
        }else {
            session.setAttribute("msg","付款失败");
            return "redirect:../contract/selectByTenantId";
        }

    }

    //支付完成异步操作
    @RequestMapping(value = "/alipayNotifyNotice",method = {RequestMethod.GET,RequestMethod.POST})
    public void alipayNotifyNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Map<String,String> params = getPayInfo(request);

        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

        if(signVerified) {//验证成功
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //交易状态
            String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

            if(trade_status.equals("TRADE_SUCCESS")){
            }else{
            }

        }else {
            //验证失败，不进行表操作
        }
    }

    public Map<String,String> getPayInfo(HttpServletRequest request){
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        return params;
    }

}
