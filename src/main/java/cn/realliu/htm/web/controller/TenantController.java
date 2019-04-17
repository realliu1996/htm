package cn.realliu.htm.web.controller;

import cn.realliu.htm.common.bean.Agency;
import cn.realliu.htm.common.bean.Tenant;
import cn.realliu.htm.common.exception.CommonException;
import cn.realliu.htm.service.interfaces.AgencyService;
import cn.realliu.htm.service.interfaces.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    @Autowired
    private AgencyService agencyService;

    //完善租客信息
    @RequestMapping(value = "/updateTenant",method = RequestMethod.POST)
    public String updateTenant(Tenant tenant, HttpSession session){

        try {
            tenantService.update(tenant);
            session.setAttribute("tenant",tenant);
            return "redirect:/showIndex";
        } catch (CommonException e) {
            e.printStackTrace();
            session.setAttribute("msg",e.getMessage());
            return "redirect:/showaddtenant";
        }

    }

    //查询所有中介
    @RequestMapping(value = "/selectAllAgency",method = RequestMethod.GET)
    public String selectAllAgency(HttpSession session){

        try{
            List<Agency> agencyList = agencyService.selectAll("U");
            session.setAttribute("agencyList",agencyList);
            return "redirect:/showAgency";
        }catch (CommonException e){
            e.printStackTrace();
            session.setAttribute("msg",e.getMessage());
            return "redirect:/showAgency";
        }

    }
}
