package cn.realliu.htm.web.controller;

import cn.realliu.htm.common.bean.House;
import cn.realliu.htm.common.bean.Landlord;
import cn.realliu.htm.common.bean.LandlordApplication;
import cn.realliu.htm.common.exception.CommonException;
import cn.realliu.htm.service.interfaces.HouseService;
import cn.realliu.htm.service.interfaces.LandlordApplicationService;
import cn.realliu.htm.service.interfaces.LandlordService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    private HouseService houseService;
    @Autowired
    private House newHouse;
    @Autowired
    private LandlordService landlordService;

    //新增房屋信息
    @RequestMapping(value = "/addHouse",method = RequestMethod.POST)
    public String addHouse(House house, HttpSession session){
        try {

            Landlord landlord = (Landlord) session.getAttribute("landlord");
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

    //查询推荐房屋信息
    @RequestMapping(value = "/selectOrder",method = RequestMethod.GET)
    public String selectOrder(HttpSession session){

        try {
            List<House> houseList = houseService.selectOrder("U");
            if (houseList.size() < 5){
                session.setAttribute("msg","无房源信息");
                return "redirect:/showlogin";
            }
            session.setAttribute("houseList",houseList);
            return "redirect:/showIndex";
        } catch (CommonException e) {
            e.printStackTrace();
            session.setAttribute("msg","无房源信息");
            return "redirect:/showlogin";
        }

    }

    //查询出租房屋信息
    @ResponseBody
    @RequestMapping(value = "/selectById",method = RequestMethod.POST)
    public House selectById(@RequestParam("houseId") Integer houseId, HttpSession session){

        try {
            newHouse = houseService.selectById(houseId);
            Landlord landlord = landlordService.selectByUserId(newHouse.getUserId());
            newHouse.setImage(landlord.getLandlordNick());
            return newHouse;
        }catch (CommonException e){
            e.printStackTrace();
            newHouse.setHouseId(0);
            return newHouse;
        }

    }

    //根据条件查询房屋信息
    @RequestMapping(value = "/selectByCond",method = {RequestMethod.POST,RequestMethod.GET})
    public String selectByCond(String community, Integer layerNum,String houseType,String houseArea,
                               Integer price,HttpSession session){

        try {
            Double area = null;
            if (!StringUtils.isBlank(houseArea)) {
                area = Double.parseDouble(houseArea);
            }
            Landlord landlord = (Landlord) session.getAttribute("landlord");
            List<House> condHouses = houseService.selectByCond(landlord.getUserId(), community, layerNum, houseType, area, price);
            session.setAttribute("condHouses",condHouses);
            return "redirect:/showLandlordHome";
        }catch (CommonException e){
            e.printStackTrace();
            return "redirect:/showLandlordHome";
        }


    }

}
