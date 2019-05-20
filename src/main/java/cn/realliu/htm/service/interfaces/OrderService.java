package cn.realliu.htm.service.interfaces;

import cn.realliu.htm.common.bean.Order;
import cn.realliu.htm.common.exception.CommonException;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/4/17
 * @Time: 13:59
 * @Description：订单逻辑接口
 */
public interface OrderService {

    /**
     * 新增订单
     * @param order 订单信息
     * @throws CommonException
     */
    void insertUser(Order order) throws CommonException;

    /**
     * 通过商户订单号查找订单
     * @param tradeNo 商户订单号
     * @return Order 订单实体
     * @throws CommonException
     */
    Order selectByTradeNo(String tradeNo) throws CommonException;


    /**
     * 通过商户订单号修改订单状态
     * @param tradeNo 商户订单号
     * @param status 订单状态
     * @throws CommonException
     */
    void update(String tradeNo,String status) throws CommonException;

}
