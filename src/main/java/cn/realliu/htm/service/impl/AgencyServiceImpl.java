package cn.realliu.htm.service.impl;

import cn.realliu.htm.common.bean.Agency;
import cn.realliu.htm.common.exception.CommonException;
import cn.realliu.htm.dao.AgencyDao;
import cn.realliu.htm.service.interfaces.AgencyService;
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
 * @Date: 2019/1/22
 * @Time: 15:53
 * @Description：中介逻辑实现
 */
@Service
@Transactional(isolation= Isolation.DEFAULT,propagation= Propagation.REQUIRED,readOnly=true)
public class AgencyServiceImpl implements AgencyService {

    @Autowired
    private AgencyDao agencyDao;

    /**
     * 通过用户id查找中介信息
     * @param userId 用户id
     * @return Agency 中介实体
     * @throws CommonException
     */
    @Override
    public Agency selectByUserId(Integer userId) throws CommonException {

        if (userId == 0){
            throw CommonException.getException(401);
        }

        Agency agency = agencyDao.selectByUserId(userId);

        if (agency == null){
            throw  CommonException.getException(404);
        }

        return agency;
    }

    /**
     * 通过用户id修改房东信息
     * @param agency 中介实体
     * @throws CommonException
     */
    @Override
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
    public void update(Agency agency) throws CommonException {

        if (StringUtils.isBlank(agency.getAgencyName()) || StringUtils.isBlank(agency.getAgencyLegal()) ||
            StringUtils.isBlank(agency.getAgencyAddr()) || StringUtils.isBlank(agency.getAgencyTel()) ||
            StringUtils.isBlank(agency.getAgencyMail()) || StringUtils.isBlank(agency.getEstablished()) ||
            StringUtils.isBlank(agency.getAgencyFunds())
        ){
            throw CommonException.getException(401);
        }

        agencyDao.update(agency);

    }
}
