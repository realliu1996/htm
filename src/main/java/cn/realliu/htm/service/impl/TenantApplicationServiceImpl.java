package cn.realliu.htm.service.impl;

import cn.realliu.htm.common.bean.TenantApplication;
import cn.realliu.htm.common.exception.CommonException;
import cn.realliu.htm.dao.TenantApplicationDao;
import cn.realliu.htm.service.interfaces.HouseService;
import cn.realliu.htm.service.interfaces.TenantApplicationService;
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
 * @Date: 2019/3/22
 * @Time: 12:08
 * @Description：租房申请单逻辑实现
 */
@Service
@Transactional(isolation= Isolation.DEFAULT,propagation= Propagation.REQUIRED,readOnly=true)
public class TenantApplicationServiceImpl implements TenantApplicationService {

    @Autowired
    private TenantApplicationDao tenantApplicationDao;
    @Autowired
    private HouseService houseService;

    /**
     * 新增租房申请单
     * @param tenantApplication 租房申请单信息
     * @throws CommonException
     */
    @Override
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
    public void insertTenantApplication(TenantApplication tenantApplication) throws CommonException {

        if (tenantApplication.getAgencyId() == 0 || StringUtils.isBlank(tenantApplication.getApplyType()) ||
            tenantApplication.getHouseId() == 0 || tenantApplication.getLandlordId() == 0 || tenantApplication.getRentalPrice() == 0 ||
            tenantApplication.getRentalTime() == 0 || StringUtils.isBlank(tenantApplication.getStatus()) ) {
                throw CommonException.getException(401);
        }

        tenantApplicationDao.insert(tenantApplication);

        houseService.updateStatus(tenantApplication.getHouseId(),"E");

    }
}
