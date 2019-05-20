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

    @RequestMapping(value = "/showLandlordApplication",method = RequestMethod.GET)
    public String showLandlordApplication() {
        return "rearPage/landlord/tenancy/landlordApplication";
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

    @RequestMapping(value = "/showLandlordApplicationReview",method = RequestMethod.GET)
    public String showLandlordApplicationReview() {
        return "rearPage/agency/tenancy/landlordApplication";
    }

    @RequestMapping(value = "/showTenantApplicationReview",method = RequestMethod.GET)
    public String showTenantApplicationReview() {
        return "rearPage/agency/tenancy/tenantApplication";
    }

    @RequestMapping(value = "/showReview",method = RequestMethod.GET)
    public String showReview() {
        return "rearPage/landlord/tenancy/tenantApplication";
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

    @RequestMapping(value = "/showContractForLandlord",method = RequestMethod.GET)
    public String showContractForLandlord() {
        return "rearPage/landlord/contract/contractList";
    }

    @RequestMapping(value = "/showleaseContract",method = RequestMethod.GET)
    public String showleaseContract() {
        return "rearPage/landlord/contract/leaseContract";
    }

    @RequestMapping(value = "/applicationCount",method = RequestMethod.GET)
    public String applicationCount() {
        return "rearPage/landlord/report/applicationCount";
    }

    @RequestMapping(value = "/showLandlordCount",method = RequestMethod.GET)
    public String showLandlordCount() {
        return "rearPage/landlord/report/landlordCount";
    }

    @RequestMapping(value = "/showTenantCount",method = RequestMethod.GET)
    public String showTenantCount() {
        return "rearPage/landlord/report/tenantCount";
    }

    @RequestMapping(value = "/showContractForAgency",method = RequestMethod.GET)
    public String showContractForAgency() {
        return "rearPage/agency/contract/contractList";
    }

    @RequestMapping(value = "/showCForAgency",method = RequestMethod.GET)
    public String showCForAgency() {
        return "rearPage/agency/report/landlordCount";
    }

    @RequestMapping(value = "/showTenantCountForAgency",method = RequestMethod.GET)
    public String showTenantCountForAgency() {
        return "rearPage/agency/report/tenantCount";
    }

    @RequestMapping(value = "/showDashBoard",method = RequestMethod.GET)
    public String showDashBoard() {
        return "rearPage/agency/dashBoard";
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

    @RequestMapping(value = "/showtApplication",method = RequestMethod.GET)
    public String showtApplication() {
        return "frontPage/tenancy/tenantApplication";
    }

    @RequestMapping(value = "/showContractForTenant",method = RequestMethod.GET)
    public String showContractForTenant() {
        return "frontPage/contract/contractList";
    }

    @RequestMapping(value = "/showlContract",method = RequestMethod.GET)
    public String showlContract() {
        return "frontPage/contract/leaseContract";
    }

    @RequestMapping(value = "/showPrecreate",method = {RequestMethod.GET,RequestMethod.POST})
    public String showPrecreate() {
        return "frontPage/contract/trade_precreate";
    }

    @RequestMapping(value = "/showCountForTenant",method = RequestMethod.GET)
    public String showCountForTenant() {
        return "frontPage/report/contractCount";
    }

    @RequestMapping(value = "/showFTenantInfo",method = RequestMethod.GET)
    public String showFTenantInfo() {
        return "frontPage/basicdata/tenantInfo";
    }

    @RequestMapping(value = "/showFTenantSystem",method = RequestMethod.GET)
    public String showFTenantSystem(HttpSession session) {

        String system = getSystem();
        session.setAttribute("system",system);
        return "frontPage/basicdata/systemInfo";
    }

}
