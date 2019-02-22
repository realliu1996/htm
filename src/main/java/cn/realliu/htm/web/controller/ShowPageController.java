package cn.realliu.htm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/1/1
 * @Time: 14:40
 * @Description：页面展示
 */
@Controller
public class ShowPageController {

    @RequestMapping(value = "/showlogin",method = RequestMethod.GET)
    public String showLogin() {
        return "login";
    }

    @RequestMapping(value = "/showregister",method = RequestMethod.GET)
    public String showRegister() {
        return "register";
    }

    @RequestMapping(value = "/showaddtenant",method = RequestMethod.GET)
    public String showAddTenant() {
        return "tenant/basicdata/addTenant";
    }

    @RequestMapping(value = "/showtenantinfo",method = RequestMethod.GET)
    public String showTenantInfo() {
        return "tenant/basicdata/tenantInfo";
    }

    @RequestMapping(value = "/showtenantsystem",method = RequestMethod.GET)
    public String showTenantSystem(HttpSession session) {

        String system = getSystem();
        session.setAttribute("system",system);
        return "tenant/basicdata/systemInfo";
    }

    @RequestMapping(value = "/showaddlandlord",method = RequestMethod.GET)
    public String showAddLandlord() {
        return "landlord/basicdata/addLandlord";
    }

    @RequestMapping(value = "/showlandlordinfo",method = RequestMethod.GET)
    public String showLandlordInfo() {
        return "landlord/basicdata/landlordInfo";
    }

    @RequestMapping(value = "/showlandlordsystem",method = RequestMethod.GET)
    public String showLandlordSystem(HttpSession session) {

        String system = getSystem();
        session.setAttribute("system",system);
        return "landlord/basicdata/systemInfo";
    }

    @RequestMapping(value = "/showaddagency",method = RequestMethod.GET)
    public String showAddAgency() {
        return "agency/basicdata/addAgency";
    }

    @RequestMapping(value = "/showagencyinfo",method = RequestMethod.GET)
    public String showAgencyInfo() {
        return "agency/basicdata/agencyInfo";
    }

    @RequestMapping(value = "/showagencysystem",method = RequestMethod.GET)
    public String showAgencySystem(HttpSession session) {

        String system = getSystem();
        session.setAttribute("system",system);
        return "agency/basicdata/systemInfo";
    }

    @RequestMapping(value = "/exitpage",method = RequestMethod.GET)
    public String exitPage(HttpSession session) {
        session.removeAttribute("user");
        session.removeAttribute("date");
        if (session.getAttribute("tenant")!=null){
            session.removeAttribute("tenant");
        } else if (session.getAttribute("landlord")!=null){
            session.removeAttribute("landlord");
        } else if (session.getAttribute("agency")!=null){
            session.removeAttribute("agency");
        }

        session.setAttribute("msg","当前用户已退出");
        return "redirect:/showlogin";
    }

    @RequestMapping(value = "/showhouseentry",method = RequestMethod.GET)
    public String showHouseEntry() {
        return "landlord/tenancy/houseEntry";
    }

    public String getSystem(){
        Properties props = System.getProperties();

        String osName = props.getProperty("os.name"); //操作系统名称
        String osArch = props.getProperty("os.arch"); //操作系统构架
        String osVersion = props.getProperty("os.version"); //操作系统版本
        String system = osName+"-"+osArch+"-"+osVersion;

        return system;
    }

}
