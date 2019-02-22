package cn.realliu.htm.dao;

import cn.realliu.htm.common.bean.Landlord;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/1/21
 * @Time: 16:45
 * @Description：房东与数据库交互接口
 */
public interface LandlordDao {

    //新增房东
    void insert(Landlord landlord);

    //通过用户id查找房东信息
    Landlord selectByUserId(Integer userId);

    //通过用户id修改房东信息
    void update(Landlord landlord);
}
