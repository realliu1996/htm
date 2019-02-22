package cn.realliu.htm.service.impl;

import cn.realliu.htm.common.bean.Tenant;
import cn.realliu.htm.common.exception.CommonException;
import cn.realliu.htm.dao.TenantDao;
import cn.realliu.htm.service.interfaces.TenantService;
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
 * @Date: 2019/1/17
 * @Time: 15:17
 * @Description：租客逻辑实现
 */
@Service
@Transactional(isolation= Isolation.DEFAULT,propagation= Propagation.REQUIRED,readOnly=true)
public class TenantServiceImpl implements TenantService {

    @Autowired
    private TenantDao tenantDao;

    /**
     * 通过用户id查找租客信息
     * @param userId 用户id
     * @return Tenant 租客实体
     * @throws CommonException
     */
    @Override
    public Tenant selectByUserId(Integer userId) throws CommonException {
        if (userId == 0){
            throw CommonException.getException(401);
        }

        Tenant tenant = tenantDao.selectByUserId(userId);

        if (tenant == null){
            throw  CommonException.getException(404);
        }

        return tenant;

    }

    /**
     * 通过用户id修改租客信息
     * @param tenant 租客实体
     * @throws CommonException
     */
    @Override
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
    public void update(Tenant tenant) throws CommonException {
        if (StringUtils.isBlank(tenant.getTenantName()) || StringUtils.isBlank(tenant.getTenantSex()) ||
            StringUtils.isBlank(tenant.getTenantBirth()) || StringUtils.isBlank(tenant.getTenantAddr()) ||
            StringUtils.isBlank(tenant.getTenantTel()) || StringUtils.isBlank(tenant.getTenantMail()) ||
            StringUtils.isBlank(tenant.getTenantWork()) || StringUtils.isBlank(tenant.getTenantIncome())
        ){
            throw CommonException.getException(401);
        }

        tenantDao.update(tenant);

    }
}
