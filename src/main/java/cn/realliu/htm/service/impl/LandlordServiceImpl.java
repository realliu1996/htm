package cn.realliu.htm.service.impl;

import cn.realliu.htm.common.bean.Landlord;
import cn.realliu.htm.common.exception.CommonException;
import cn.realliu.htm.dao.LandlordDao;
import cn.realliu.htm.service.interfaces.LandlordService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/1/21
 * @Time: 17:06
 * @Description：房东逻辑实现
 */
@Service
@Transactional(isolation= Isolation.DEFAULT,propagation= Propagation.REQUIRED,readOnly=true)
public class LandlordServiceImpl implements LandlordService {

    @Autowired
    private LandlordDao landlordDao;

    /**
     * 通过用户id查找房东信息
     * @param userId 用户id
     * @return Landlord 房东实体
     * @throws CommonException
     */
    @Override
    public Landlord selectByUserId(Integer userId) throws CommonException {

        if (userId == 0){
            throw CommonException.getException(401);
        }

        Landlord landlord = landlordDao.selectByUserId(userId);

        if (landlord == null){
            throw  CommonException.getException(404);
        }

        return landlord;
    }

    /**
     * 通过用户id修改房东信息
     * @param landlord 房东实体
     * @throws CommonException
     */
    @Override
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
    public void update(Landlord landlord) throws CommonException {
        if (StringUtils.isBlank(landlord.getLandlordName()) || StringUtils.isBlank(landlord.getLandlordSex()) ||
            StringUtils.isBlank(landlord.getLandlordBirth()) || StringUtils.isBlank(landlord.getLandlordAddr()) ||
            StringUtils.isBlank(landlord.getLandlordTel()) || StringUtils.isBlank(landlord.getLandlordMail()) ||
            StringUtils.isBlank(landlord.getLandlordWork())
        ){
            throw CommonException.getException(401);
        }

        landlordDao.update(landlord);
    }
}
