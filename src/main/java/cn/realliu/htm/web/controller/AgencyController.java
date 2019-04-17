package cn.realliu.htm.web.controller;

import cn.realliu.htm.common.bean.Agency;
import cn.realliu.htm.common.exception.CommonException;
import cn.realliu.htm.service.interfaces.AgencyService;
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
 * @Date: 2019/1/22
 * @Time: 16:01
 * @Description：中介业务
 */
@Controller
@RequestMapping("/agency")
public class AgencyController {

    @Autowired
    private AgencyService agencyService;
    @Autowired
    private Agency agency;

    //完善中介信息
    @RequestMapping(value = "/updateAgency",method = RequestMethod.POST)
    public String updateAgency(Agency agency, HttpSession session){

        try {
            agencyService.update(agency);
            session.setAttribute("agency",agency);
            return "redirect:/showagencyinfo";
        } catch (CommonException e) {
            e.printStackTrace();
            session.setAttribute("msg",e.getMessage());
            return "redirect:/showaddagency";
        }
    }

    //查询中介信息
    @ResponseBody
    @RequestMapping(value = "/selectById",method = RequestMethod.POST)
    public Agency selectById(@RequestParam("agencyId")Integer agencyId,HttpSession session){

        try{
            agency = agencyService.selectByAgencyId(agencyId);
            return agency;
        }catch (CommonException e){
            e.printStackTrace();
            agency.setAgencyId(0);
            return agency;
        }
    }

}
