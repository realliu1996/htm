package cn.realliu.htm.service.interfaces;

import cn.realliu.htm.common.bean.Tenant;
import cn.realliu.htm.common.exception.CommonException;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/1/17
 * @Time: 15:14
 * @Description：租客逻辑接口
 */
public interface TenantService {

    /**
     * 通过用户id查找租客信息
     * @param userId 用户id
     * @return Tenant 租客实体
     * @throws CommonException
     */
    Tenant selectByUserId(Integer userId) throws CommonException;

    /**
     * 通过用户id修改租客信息
     * @param tenant 租客实体
     * @throws CommonException
     */
    void update(Tenant tenant) throws CommonException;

}
