package cn.realliu.htm.web.controller;

import cn.realliu.htm.common.bean.Agency;
import cn.realliu.htm.common.exception.CommonException;
import cn.realliu.htm.service.interfaces.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    //完善中介信息
    @RequestMapping(value = "/updateAgency",method = RequestMethod.POST)
    public String updateAgency(Agency agency, HttpSession session){

        try {
            agencyService.update(agency);
            session.setAttribute("agency",agency);
            return "redirect:/showagencyinfo";
        } catch (CommonException e) {
            session.setAttribute("msg",e.getMessage());
            return "redirect:/showaddagency";
        }
    }

}
