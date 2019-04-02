package cn.realliu.htm.web.controller;

import cn.realliu.htm.common.bean.House;
import cn.realliu.htm.common.bean.Landlord;
import cn.realliu.htm.common.bean.Tenant;
import cn.realliu.htm.common.bean.TenantApplication;
import cn.realliu.htm.common.exception.CommonException;
import cn.realliu.htm.service.interfaces.HouseService;
import cn.realliu.htm.service.interfaces.LandlordService;
import cn.realliu.htm.service.interfaces.TenantApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/3/27
 * @Time: 10:10
 * @Description：租房申请单业务
 */
@Controller
@RequestMapping("/tenantApplication")
public class TenantApplicationController {

    @Autowired
    private TenantApplicationService tenantApplicationService;
    @Autowired
    private HouseService houseService;
    @Autowired
    private LandlordService landlordService;

    //新增租房申请单
    @ResponseBody
    @RequestMapping(value = "/addTenantApplication",method = RequestMethod.POST)
    public String addTenantApplication(TenantApplication tenantApplication, HttpSession session){

        Tenant tenant = (Tenant) session.getAttribute("tenant");
        Integer houseId = tenantApplication.getHouseId();
        Integer rentalTime = tenantApplication.getRentalTime();

        try {
            House house = houseService.selectById(houseId);
            if ("U".equals(house.getStatus())) {
                Landlord landlord = landlordService.selectByUserId(house.getUserId());
                tenantApplication.setApplyType("T");//租客租房申请单类型
                tenantApplication.setLandlordId(landlord.getLandlordId());//房东id
                tenantApplication.setTenantId(tenant.getTenantId());//租客id
                tenantApplication.setAgencyId(house.getAgencyId());//中介id
                tenantApplication.setRentalPrice(house.getPrice());//租房单价
                tenantApplication.setStatus("SR");//申请单状态(开始审核SR 中介审核AR 房东审核LR)
                tenantApplicationService.insertTenantApplication(tenantApplication);
                return "true";
            }else {
                return "false";
            }
        }catch (CommonException e){
            e.printStackTrace();
            return "false";
        }
    }

}
