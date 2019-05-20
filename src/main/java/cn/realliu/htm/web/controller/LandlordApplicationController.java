package cn.realliu.htm.web.controller;

import cn.realliu.htm.common.bean.Agency;
import cn.realliu.htm.common.bean.Landlord;
import cn.realliu.htm.common.bean.LandlordApplication;
import cn.realliu.htm.common.exception.CommonException;
import cn.realliu.htm.service.interfaces.LandlordApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/4/14
 * @Time: 23:24
 * @Description：房屋录入申请单业务
 */
@Controller
@RequestMapping("/landlordApplication")
public class LandlordApplicationController {

    @Autowired
    private LandlordApplicationService landlordApplicationService;

    //根据条件查询房屋录入申请单
    @RequestMapping(value = "/selectByCond",method = {RequestMethod.POST,RequestMethod.GET})
    public String selectByCond(String status, HttpSession session){

        try {
            Landlord landlord = (Landlord) session.getAttribute("landlord");
            List<LandlordApplication> landlordApplications = landlordApplicationService.selectByCond(landlord.getLandlordId(),status,null);
            session.setAttribute("landlordApplications",landlordApplications);
            return "redirect:/showLandlordApplication";
        } catch (CommonException e) {
            e.printStackTrace();
            return "redirect:/showLandlordApplication";
        }
    }

    //统计报表根据条件查询房屋录入申请单
    @RequestMapping(value = "/selectByCondCount",method = {RequestMethod.POST,RequestMethod.GET})
    public String selectByCondCount(String status, HttpSession session){

        try {
            Landlord landlord = (Landlord) session.getAttribute("landlord");
            List<LandlordApplication> landlordApplications = landlordApplicationService.selectByCond(landlord.getLandlordId(),status,null);
            session.setAttribute("landlordApplications",landlordApplications);
            return "redirect:/showLandlordCount";
        } catch (CommonException e) {
            e.printStackTrace();
            return "redirect:/showLandlordCount";
        }
    }

    //根据条件查询中介审核房屋录入申请单
    @RequestMapping(value = "/selectByAgencyId",method = {RequestMethod.POST,RequestMethod.GET})
    public String selectByAgencyId(HttpSession session){

        try{
            Agency agency = (Agency) session.getAttribute("agency");
            List<LandlordApplication> landlordApplications = landlordApplicationService.selectByCond(null, "SR", agency.getAgencyId());
            session.setAttribute("landlordApplications",landlordApplications);
            return "redirect:/showLandlordApplicationReview";
        }catch (CommonException e){
            e.printStackTrace();
            return "redirect:/showLandlordApplicationReview";
        }

    }

    //中介审核房屋录入申请单
    @ResponseBody
    @RequestMapping(value = "/reviewForLandlord",method = RequestMethod.POST)
    public String reviewForLandlord(String applyId,String houseId,String view,HttpSession session){

        Integer a = Integer.parseInt(applyId);
        Integer h = Integer.parseInt(houseId);

        try {
            landlordApplicationService.reviewForLandlord(a, h, view);
            return "true";
        } catch (CommonException e) {
            e.printStackTrace();
            return "false";
        }

    }

    //根据条件查询房屋录入申请单
    @RequestMapping(value = "/selectForAgency",method = {RequestMethod.POST,RequestMethod.GET})
    public String selectForAgency(String status, HttpSession session){

        try {
            Agency agency = (Agency) session.getAttribute("agency");
            List<LandlordApplication> landlordApplications = landlordApplicationService.selectByCond(null,status,agency.getAgencyId());
            session.setAttribute("landlordApplications",landlordApplications);
            return "redirect:/showCForAgency";
        } catch (CommonException e) {
            e.printStackTrace();
            return "redirect:/showCForAgency";
        }
    }

}
