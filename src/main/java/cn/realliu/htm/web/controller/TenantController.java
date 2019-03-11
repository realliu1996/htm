package cn.realliu.htm.web.controller;

import cn.realliu.htm.common.bean.Tenant;
import cn.realliu.htm.common.exception.CommonException;
import cn.realliu.htm.service.interfaces.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/1/17
 * @Time: 16:21
 * @Description：租客业务
 */
@Controller
@RequestMapping("/tenant")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    //完善租客信息
    @RequestMapping(value = "/updateTenant",method = RequestMethod.POST)
    public String updateTenant(Tenant tenant, HttpSession session){

        try {
            tenantService.update(tenant);
            session.setAttribute("tenant",tenant);
            return "redirect:/showIndex";
        } catch (CommonException e) {
            session.setAttribute("msg",e.getMessage());
            return "redirect:/showaddtenant";
        }

    }
}
