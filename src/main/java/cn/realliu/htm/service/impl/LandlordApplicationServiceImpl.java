package cn.realliu.htm.service.impl;

import cn.realliu.htm.common.bean.Agency;
import cn.realliu.htm.common.bean.House;
import cn.realliu.htm.common.bean.Landlord;
import cn.realliu.htm.common.bean.LandlordApplication;
import cn.realliu.htm.common.exception.CommonException;
import cn.realliu.htm.dao.AgencyDao;
import cn.realliu.htm.dao.HouseDao;
import cn.realliu.htm.dao.LandlordApplicationDao;
import cn.realliu.htm.dao.LandlordDao;
import cn.realliu.htm.service.interfaces.LandlordApplicationService;
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
 * @Date: 2019/4/18
 * @Time: 22:25
 * @Description：房屋录入申请单逻辑实现
 */
@Service
@Transactional(isolation= Isolation.DEFAULT,propagation= Propagation.REQUIRED,readOnly=true)
public class LandlordApplicationServiceImpl implements LandlordApplicationService {

    @Autowired
    private LandlordApplicationDao landlordApplicationDao;
    @Autowired
    private HouseDao houseDao;
    @Autowired
    private LandlordDao landlordDao;
    @Autowired
    private AgencyDao agencyDao;

    /**
     * 新增租房申请单
     * @param landlordApplication 房屋录入申请单信息
     * @throws CommonException
     */
    @Override
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
    public void insertLandlordApplication(LandlordApplication landlordApplication) throws CommonException {

        if (StringUtils.isBlank(landlordApplication.getApplyType()) || landlordApplication.getHouseId() == 0 ||
            landlordApplication.getLandlordId() == 0 || landlordApplication.getAgencyId() == 0 ||
                StringUtils.isBlank(landlordApplication.getStatus())){
            throw CommonException.getException(401);
        }

        House house = houseDao.selectById(landlordApplication.getHouseId());
        landlordApplication.setCommunity(house.getCommunity());

        Landlord landlord = landlordDao.selectByLandlordId(landlordApplication.getLandlordId());
        landlordApplication.setLandlordName(landlord.getLandlordName());

        Agency agency = agencyDao.selectByAgencyId(landlordApplication.getAgencyId());
        landlordApplication.setAgencyName(agency.getAgencyName());

        landlordApplicationDao.insert(landlordApplication);
    }

    /**
     * 按条件查询申请单
     * @param landlordId 房东id
     * @param status 房屋录入申请单信息
     * @param agencyId 中介id
     * @throws CommonException
     */
    @Override
    public List<LandlordApplication> selectByCond(Integer landlordId,String status,Integer agencyId) throws CommonException{

        List<LandlordApplication> landlordApplications = landlordApplicationDao.selectByCond(landlordId,status,agencyId);

        for (LandlordApplication application: landlordApplications
             ) {
            if ("L".equals(application.getApplyType())) {
                application.setApplyType("房屋录入申请单");
            }
            if ("SR".equals(application.getStatus())){
                application.setStatus("提交申请");
            }
            if ("U".equals(application.getStatus())){
                application.setStatus("审核通过");
            }
            if ("E".equals(application.getStatus())){
                application.setStatus("审核不通过");
            }

        }

        return landlordApplications;
    }

    /**
     * 申请单处理
     * @param applyId 申请单id
     * @param houseId 房屋id
     * @param view 处理结果
     * @return String 审核结果
     * @throws CommonException
     */
    @Override
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
    public String reviewForLandlord(Integer applyId,Integer houseId,String view) throws CommonException{

        landlordApplicationDao.update(applyId,view);

        if ("E".equals(view)){
            return "true";
        }
        houseDao.updateStatus(houseId,"U");

        return "true";
    }
}
