package cn.realliu.htm.web.controller;

import cn.realliu.htm.common.bean.Agency;
import cn.realliu.htm.common.bean.Landlord;
import cn.realliu.htm.common.bean.Tenant;
import cn.realliu.htm.common.bean.User;
import cn.realliu.htm.common.exception.CommonException;
import cn.realliu.htm.service.interfaces.AgencyService;
import cn.realliu.htm.service.interfaces.LandlordService;
import cn.realliu.htm.service.interfaces.TenantService;
import cn.realliu.htm.service.interfaces.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/1/15
 * @Time: 15:17
 * @Description：用户业务
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private TenantService tenantService;
    @Autowired
    private LandlordService landlordService;
    @Autowired
    private AgencyService agencyService;

    //用户注册
    @RequestMapping(value = "/userRegister",method = RequestMethod.POST)
    public String userRegister(User user, HttpSession session){

        try {
            userService.insertUser(user);
            session.setAttribute("msg","注册成功！请登录");
            return "redirect:/showlogin";
        } catch (CommonException e) {
            session.setAttribute("msg",e.getMessage());
            return "redirect:/showregister";
        }

    }

    //用户名注册验证
    @ResponseBody
    @RequestMapping(value = "/userNameCheck",method = RequestMethod.POST)
    public String userNameCheck(String userName, HttpSession session){

        try {
            User user = userService.selectByUserName(userName);

            if (user != null){
                return "false";
            }else {
                return "true";
            }

        } catch (CommonException e) {
            session.setAttribute("msg",e.getMessage());
            return "error";
        }

    }

    //用户登录
    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    public String userLogin(String userName, String userPassword, HttpSession session){

        try {
            User user = userService.selectByNamePassword(userName, userPassword);
            Calendar calendar = Calendar.getInstance();
            String date = calendar.get(Calendar.YEAR) + "年" + (calendar.get(Calendar.MONTH) + 1) + "月" + calendar.get(Calendar.DAY_OF_MONTH) + "日";
            session.setAttribute("user", user);
            session.setAttribute("date", date);

            if ("租客".equals(user.getUserRole())) {
                Tenant tenant = tenantService.selectByUserId(user.getUserId());
                if ("E".equals(tenant.getStatus())) {
                    session.setAttribute("tenant", tenant);
                    return "redirect:/showaddtenant";
                } else if ("U".equals(tenant.getStatus())) {
                    session.setAttribute("tenant", tenant);
                    return "redirect:/showIndex";
                } else {
                    return "redirect:/showlogin";
                }
            }else if ("房东".equals(user.getUserRole())) {
                Landlord landlord = landlordService.selectByUserId(user.getUserId());
                if ("E".equals(landlord.getStatus())){
                    session.setAttribute("landlord",landlord);
                    return "redirect:/showaddlandlord";
                } else if ("U".equals(landlord.getStatus())) {
                    List<Agency> agencies = agencyService.selectAll("U");
                    session.setAttribute("allAgency",agencies);
                    session.setAttribute("landlord",landlord);
                    return "redirect:/showlandlordinfo";
                } else {
                    return "redirect:/showlogin";
                }
            }else if ("中介".equals(user.getUserRole())) {
                Agency agency = agencyService.selectByUserId(user.getUserId());
                if ("E".equals(agency.getStatus())){
                    session.setAttribute("agency",agency);
                    return "redirect:/showaddagency";
                } else if ("U".equals(agency.getStatus())){
                    session.setAttribute("agency",agency);
                    return "redirect:/showagencyinfo";
                } else {
                    return "redirect:/showlogin";
                }
            }else {
                return "redirect:/showlogin";
            }

        } catch (CommonException e) {
            session.setAttribute("msg",e.getMessage());
            return "redirect:/showlogin";
        }

    }

}
