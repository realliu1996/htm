package cn.realliu.htm.service.impl;

import cn.realliu.htm.common.bean.Agency;
import cn.realliu.htm.common.bean.House;
import cn.realliu.htm.common.exception.CommonException;
import cn.realliu.htm.dao.AgencyDao;
import cn.realliu.htm.dao.HouseDao;
import cn.realliu.htm.service.interfaces.HouseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
        house.setStatus("U");

        houseDao.insert(house);

    }


    /**
     * 查找所有房屋信息
     * @param status 房屋状态
     * @return House 房屋实体集合
     * @throws CommonException
     */
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

}
