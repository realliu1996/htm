package cn.realliu.htm.dao;

import cn.realliu.htm.common.bean.Tenant;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/1/17
 * @Time: 14:31
 * @Description：租客与数据库交互接口
 */
public interface TenantDao {

    //新增租客
    void insert(Tenant tenant);

    //通过用户id查找租客信息
    Tenant selectByUserId(Integer userId);

    //通过用户id修改租客信息
    void update(Tenant tenant);

}
