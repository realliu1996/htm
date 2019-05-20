package cn.realliu.htm.web.controller;

import cn.realliu.htm.common.bean.*;
import cn.realliu.htm.common.exception.CommonException;
import cn.realliu.htm.service.interfaces.HouseService;
import cn.realliu.htm.service.interfaces.LandlordService;
import cn.realliu.htm.service.interfaces.TenantApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
            if ("U".equals(house.getStatus()) && tenant != null) {
                Landlord landlord = landlordService.selectByUserId(house.getUserId());
                tenantApplication.setApplyType("T");//租客租房申请单类型
                tenantApplication.setLandlordId(landlord.getLandlordId());//房东id
                tenantApplication.setTenantId(tenant.getTenantId());//租客id
                tenantApplication.setAgencyId(house.getAgencyId());//中介id
                tenantApplication.setRentalPrice(house.getPrice());//租房单价
                tenantApplication.setStatus("SR");//申请单状态(开始审核SR 中介审核AR 房东审核LR)
                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                tenantApplication.setDate(sqlDate);
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

    //根据条件查询租房申请单（中介）
    @RequestMapping(value = "/selectByCond",method = {RequestMethod.POST,RequestMethod.GET})
    public String selectByCond(HttpSession session){

        String landlordName = (String) session.getAttribute("landlordName");
        String tenantName = (String) session.getAttribute("tenantName");
        Agency agecny = (Agency) session.getAttribute("agency");

        try {
            List<TenantApplication> tenantApplications = tenantApplicationService.selectByCond(landlordName, tenantName, agecny.getAgencyId(), "SR");
            session.setAttribute("tenantApplications",tenantApplications);
            return "redirect:/showTenantApplicationReview";
        }catch (CommonException e){
            e.printStackTrace();
            return "redirect:/showTenantApplicationReview";

        }

    }

    //根据条件查询租房申请单（房东）
    @RequestMapping(value = "/selectByCondForLandlord",method = {RequestMethod.POST,RequestMethod.GET})
    public String selectByCondForLandlord(HttpSession session){

        String landlordName = (String) session.getAttribute("landlordName");
        String tenantName = (String) session.getAttribute("tenantName");
        Landlord landlord = (Landlord) session.getAttribute("landlord");

        try {
            List<TenantApplication> tenantApplications = tenantApplicationService.selectForLandlord(landlordName, tenantName, landlord.getLandlordId(), "LR");
            session.setAttribute("tenantApplications",tenantApplications);
            return "redirect:/showReview";
        }catch (CommonException e){
            e.printStackTrace();
            return "redirect:/showReview";

        }

    }

    //根据条件查询租房申请单（租客）
    @RequestMapping(value = "/selectByCondForTenant",method = {RequestMethod.POST,RequestMethod.GET})
    public String selectByCondForTenant(HttpSession session){

        String landlordName = (String) session.getAttribute("landlordName");
        String tenantName = (String) session.getAttribute("tenantName");
        Tenant tenant = (Tenant) session.getAttribute("tenant");

        try {
            List<TenantApplication> tenantApplications = tenantApplicationService.selectForTenant(landlordName, tenantName, tenant.getTenantId(), null);
            session.setAttribute("tenantApplications",tenantApplications);
            return "redirect:/showtApplication";
        }catch (CommonException e){
            e.printStackTrace();
            return "redirect:/showtApplication";

        }

    }

    //统计报表查询租房申请单（房东）
    @RequestMapping(value = "/selectCountForLandlord",method = {RequestMethod.POST,RequestMethod.GET})
    public String selectCountForLandlord(String tenantName,String status,HttpSession session){

        Landlord landlord = (Landlord) session.getAttribute("landlord");

        try {
            List<TenantApplication> tenantApplications = tenantApplicationService.selectCountForLandlord(tenantName, landlord.getLandlordId(), status);
            session.setAttribute("tenantApplications",tenantApplications);
            return "redirect:/showTenantCount";
        }catch (CommonException e){
            e.printStackTrace();
            return "redirect:/showTenantCount";

        }

    }

    //中介审核租房申请单
    @ResponseBody
    @RequestMapping(value = "/reviewForTenant",method = RequestMethod.POST)
    public String reviewForTenant(String applyId,String houseId,String view,HttpSession session){

        Integer a = Integer.parseInt(applyId);
        Integer h = Integer.parseInt(houseId);

        try{
            tenantApplicationService.reviewForTenant(a,h,view);
            return "true";
        }catch (CommonException e){
            e.printStackTrace();
            return "false";
        }
    }

    //房东审核租房申请单
    @ResponseBody
    @RequestMapping(value = "/reviewByLandlord",method = RequestMethod.POST)
    public String reviewByLandlord(String applyId,String houseId,String view,HttpSession session){

        Integer a = Integer.parseInt(applyId);
        Integer h = Integer.parseInt(houseId);

        try{
            tenantApplicationService.reviewByLandlord(a,h,view);
            return "true";
        }catch (CommonException e){
            e.printStackTrace();
            return "false";
        }
    }


    //统计报表查询租房申请单（中介）
    @RequestMapping(value = "/selectCountForAgency",method = {RequestMethod.POST,RequestMethod.GET})
    public String selectCountForAgency(String landlordName,String tenantName,String status,HttpSession session){

        Agency agency = (Agency) session.getAttribute("agency");

        try {
            List<TenantApplication> tenantApplications = tenantApplicationService.selectCountForAgency(landlordName,tenantName, agency.getAgencyId(), status);
            session.setAttribute("tenantApplications",tenantApplications);
            return "redirect:/showTenantCountForAgency";
        }catch (CommonException e){
            e.printStackTrace();
            return "redirect:/showTenantCountForAgency";

        }

    }

}
