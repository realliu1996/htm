package cn.realliu.htm.dao;

import cn.realliu.htm.common.bean.TenantApplication;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/3/22
 * @Time: 11:35
 * @Description：租房申请单与数据库交互接口
 */
public interface TenantApplicationDao {

    //新增租房申请单
    void insert(TenantApplication tenantApplication);

}
