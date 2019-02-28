package cn.realliu.htm.web.controller;

import cn.realliu.htm.common.bean.House;
import cn.realliu.htm.common.exception.CommonException;
import cn.realliu.htm.service.interfaces.HouseService;
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
 * @Date: 2019/2/28
 * @Time: 11:28
 * @Description：房屋业务
 */
@Controller
@RequestMapping("/house")
public class HouseController {

    @Autowired
    HouseService houseService;

    //新增房屋信息
    @RequestMapping(value = "/addHouse",method = RequestMethod.POST)
    public String addHouse(House house, HttpSession session){
        try {
            houseService.insertHouse(house);
            session.setAttribute("msg","房屋录入成功！");
            return "redirect:/showhouseentry";

        } catch (CommonException e) {
            e.printStackTrace();
            session.setAttribute("msg","房屋录入失败！");
            return "redirect:/showhouseentry";
        }
    }

    //查询所有房屋信息
    @RequestMapping(value = "/selectAll",method = RequestMethod.GET)
    public String selectAll(HttpSession session){
        try {
            List<House> houses = houseService.selectAll("U");
            session.setAttribute("houses",houses);
            return "redirect:/showHousing";
        } catch (CommonException e) {
            e.printStackTrace();
            session.setAttribute("msg","无房源信息");
            return "redirect:/showHousing";
        }
    }

}
