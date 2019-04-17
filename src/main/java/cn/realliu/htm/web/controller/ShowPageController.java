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

    /*后台页面*/

    @RequestMapping(value = "/showlogin",method = RequestMethod.GET)
    public String showLogin() {
        return "rearPage/login";
    }

    @RequestMapping(value = "/showregister",method = RequestMethod.GET)
    public String showRegister() {
        return "rearPage/register";
    }

    @RequestMapping(value = "/showaddtenant",method = RequestMethod.GET)
    public String showAddTenant() {
        return "rearPage/tenant/basicdata/addTenant";
    }

    @RequestMapping(value = "/showtenantinfo",method = RequestMethod.GET)
    public String showTenantInfo() {
        return "rearPage/tenant/basicdata/tenantInfo";
    }

    @RequestMapping(value = "/showtenantsystem",method = RequestMethod.GET)
    public String showTenantSystem(HttpSession session) {

        String system = getSystem();
        session.setAttribute("system",system);
        return "rearPage/tenant/basicdata/systemInfo";
    }

    @RequestMapping(value = "/showLandlordHome",method = RequestMethod.GET)
    public String showLandlordHome() {
        return "rearPage/landlord/home";
    }

    @RequestMapping(value = "/showaddlandlord",method = RequestMethod.GET)
    public String showAddLandlord() {
        return "rearPage/landlord/basicdata/addLandlord";
    }

    @RequestMapping(value = "/showlandlordinfo",method = RequestMethod.GET)
    public String showLandlordInfo() {
        return "rearPage/landlord/basicdata/landlordInfo";
    }

    @RequestMapping(value = "/showlandlordsystem",method = RequestMethod.GET)
    public String showLandlordSystem(HttpSession session) {

        String system = getSystem();
        session.setAttribute("system",system);
        return "rearPage/landlord/basicdata/systemInfo";
    }

    @RequestMapping(value = "/showaddagency",method = RequestMethod.GET)
    public String showAddAgency() {
        return "rearPage/agency/basicdata/addAgency";
    }

    @RequestMapping(value = "/showagencyinfo",method = RequestMethod.GET)
    public String showAgencyInfo() {
        return "rearPage/agency/basicdata/agencyInfo";
    }

    @RequestMapping(value = "/showagencysystem",method = RequestMethod.GET)
    public String showAgencySystem(HttpSession session) {

        String system = getSystem();
        session.setAttribute("system",system);
        return "rearPage/agency/basicdata/systemInfo";
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

    @RequestMapping(value = "/exitIndex",method = RequestMethod.GET)
    public String exitIndex(HttpSession session) {
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
        return "redirect:/showIndex";
    }

    @RequestMapping(value = "/showhouseentry",method = RequestMethod.GET)
    public String showHouseEntry() {
        return "rearPage/landlord/tenancy/houseEntry";
    }

    public String getSystem(){
        Properties props = System.getProperties();

        String osName = props.getProperty("os.name"); //操作系统名称
        String osArch = props.getProperty("os.arch"); //操作系统构架
        String osVersion = props.getProperty("os.version"); //操作系统版本
        String system = osName+"-"+osArch+"-"+osVersion;

        return system;
    }


    /*前台页面*/

    @RequestMapping(value = "/showIndex",method = RequestMethod.GET)
    public String showIndex() {
        return "frontPage/index";
    }

    @RequestMapping(value = "/showHousing",method = RequestMethod.GET)
    public String showHousing() {
        return "frontPage/housing";
    }

    @RequestMapping(value = "/showAgency",method = RequestMethod.GET)
    public String showAgency() {
        return "frontPage/agency";
    }

}
