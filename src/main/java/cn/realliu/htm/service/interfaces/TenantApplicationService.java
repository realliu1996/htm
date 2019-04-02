package cn.realliu.htm.service.interfaces;

import cn.realliu.htm.common.bean.TenantApplication;
import cn.realliu.htm.common.exception.CommonException;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/3/22
 * @Time: 12:04
 * @Description：租房申请单逻辑接口
 */
public interface TenantApplicationService {

    /**
     * 新增租房申请单
     * @param tenantApplication 租房申请单信息
     * @throws CommonException
     */
    void insertTenantApplication(TenantApplication tenantApplication) throws CommonException;



}
