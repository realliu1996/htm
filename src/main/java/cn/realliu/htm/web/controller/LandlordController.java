package cn.realliu.htm.web.controller;

import cn.realliu.htm.common.bean.Landlord;
import cn.realliu.htm.common.exception.CommonException;
import cn.realliu.htm.service.interfaces.LandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/1/21
 * @Time: 17:32
 * @Description：房东业务
 */
@Controller
@RequestMapping("/landlord")
public class LandlordController {

    @Autowired
    private LandlordService landlordService;

    //完善房东信息
    @RequestMapping(value = "/updateLandlord",method = RequestMethod.POST)
    public String updateLandlord(Landlord landlord, HttpSession session) {

        try {
            landlordService.update(landlord);
            session.setAttribute("landlord",landlord);
            return "redirect:/showlandlordinfo";
        } catch (CommonException e) {
            session.setAttribute("msg",e.getMessage());
            return "redirect:/showaddlandlord";
        }

    }
}
