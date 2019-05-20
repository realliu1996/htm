package cn.realliu.htm.service.impl;

import cn.realliu.htm.common.bean.*;
import cn.realliu.htm.common.exception.CommonException;
import cn.realliu.htm.dao.AgencyDao;
import cn.realliu.htm.dao.HouseDao;
import cn.realliu.htm.dao.LandlordDao;
import cn.realliu.htm.service.interfaces.HouseService;
import cn.realliu.htm.service.interfaces.LandlordApplicationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/1/23
 * @Time: 10:53
 * @Description：房屋逻辑实现
 */
@Service
@Transactional(isolation= Isolation.DEFAULT,propagation= Propagation.REQUIRED,readOnly=true)
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseDao houseDao;
    @Autowired
    private AgencyDao agencyDao;
    @Autowired
    private LandlordDao landlordDao;
    @Autowired
    LandlordApplicationService landlordApplicationService;
    @Autowired
    private LandlordApplication landlordApplication;
    @Autowired
    private Proportion proportion;

    /**
     * 新增房屋
     * @param house 房屋信息
     * @throws CommonException
     */
    @Override
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
    public void insertHouse(House house) throws CommonException {

        if (StringUtils.isBlank(house.getCommunity()) || StringUtils.isBlank(house.getBuildNum()) ||
            house.getLayerNum() == 0 || house.getRoomNum() ==0 || house.getHouseArea() == 0.0 ||
            StringUtils.isBlank(house.getHouseType()) || StringUtils.isBlank(house.getLocated()) ||
            StringUtils.isBlank(house.getPosition())  || house.getPrice() == 0 || house.getAgencyId() == 0
        ){
            throw CommonException.getException(401);
        }

        Agency agency = agencyDao.selectByAgencyId(house.getAgencyId());

        if (agency == null){
            throw CommonException.getException(404);
        }

        house.setAgencyName(agency.getAgencyName());
        house.setStatus("E");

        houseDao.insert(house);

        Landlord landlord = landlordDao.selectByUserId(house.getUserId());
        landlordApplication.setApplyType("L");
        landlordApplication.setHouseId(house.getHouseId());
        landlordApplication.setLandlordId(landlord.getLandlordId());
        landlordApplication.setAgencyId(house.getAgencyId());
        landlordApplication.setStatus("SR");//申请单状态(开始审核SR 审核通过U 审核不通过E)
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        landlordApplication.setDate(sqlDate);
        landlordApplicationService.insertLandlordApplication(landlordApplication);

    }


    /**
     * 查找所有房屋信息
     * @param status 房屋状态
     * @return House 房屋实体集合
     * @throws CommonException
     */
    @Override
    public List<House> selectAll(String status) throws CommonException {
        if (StringUtils.isBlank(status)){
            throw CommonException.getException(401);
        }

        List<House> houses = houseDao.selectAll(status);

        if (houses == null && houses.isEmpty()){
            throw  CommonException.getException(404);
        }

        return houses;
    }


    /**
     * 按时间查找所有房屋信息
     * @param status 房屋状态
     * @return House 房屋实体集合
     * @throws CommonException
     */
    @Override
    public List<House> selectOrder(String status) throws CommonException {

        if (StringUtils.isBlank(status)){
            throw CommonException.getException(401);
        }

        List<House> houses = houseDao.selectOrder(status);

        if (houses == null && houses.isEmpty()){
            throw  CommonException.getException(404);
        }

        return houses;
    }

    /**
     * 按房屋id查找房屋信息
     * @param houseId 房屋id
     * @return House 房屋实体集合
     * @throws CommonException
     */
    @Override
    public House selectById(Integer houseId) throws CommonException{

        if (houseId == 0){
            throw CommonException.getException(401);
        }

        House house = houseDao.selectById(houseId);

        if (house == null){
            throw CommonException.getException(404);
        }

        return house;

    }

    /**
     * 按房屋id修改房屋状态
     * @param houseId 房屋id
     * @param status 房屋状态
     * @throws CommonException
     */
    @Override
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
    public void updateStatus(Integer houseId,String status) throws CommonException{
        if (houseId == 0 || StringUtils.isBlank(status)){
            throw CommonException.getException(401);
        }
        houseDao.updateStatus(houseId,status);
    }

    /**
     * 按条件查找房屋信息
     * @param userId 用户id
     * @param community 小区
     * @param layerNum 楼层
     * @param houseType 类型
     * @param houseArea 面积
     * @param price 价格
     * @return House 房屋实体集合
     * @throws CommonException
     */
    @Override
    public List<House> selectByCond(Integer userId,String community, Integer layerNum,
                                    String houseType,Double houseArea, Integer price) throws CommonException{
        List<House> houses = houseDao.selectByCond(userId, community, layerNum, houseType, houseArea, price);

        return houses;
    }

    /**
     * 中介仪表盘
     * @return Proportion 占比
     * @throws CommonException
     */
    @Override
    public Proportion dashBoard() throws CommonException{

        Integer houseCount = houseDao.count();

        Integer one = houseDao.countByHouseType("一室一厅一卫");
        Integer two = houseDao.countByHouseType("两室一厅一卫");
        Integer third = houseDao.countByHouseType("三室一厅一卫");
        Integer four = houseDao.countByHouseType("三室两厅一卫");

        DecimalFormat df = new DecimalFormat("0.00");//格式化小数
        String o = df.format(((float)one/houseCount)*100);//返回的是String类型
        String t = df.format(((float)two/houseCount)*100);
        String th = df.format(((float)third/houseCount)*100);
        String f = df.format(((float)four/houseCount)*100);

        Integer a = houseDao.countByLocated("城中区");
        Integer b = houseDao.countByLocated("郊区");
        Integer c = houseDao.countByLocated("城乡结合部");

        String aa = df.format(((float)a/houseCount)*100);
        String bb = df.format(((float)b/houseCount)*100);
        String cc = df.format(((float)c/houseCount)*100);

        proportion.setOneRoomOnelive(o);
        proportion.setTwoRoomOnelive(t);
        proportion.setThirdRoomOnelive(th);
        proportion.setThirdRoomTwolive(f);

        proportion.setInCity(aa);
        proportion.setOutCity(bb);
        proportion.setOnCity(cc);

        return proportion;
    }

}
