package cn.realliu.htm.dao;

import cn.realliu.htm.common.bean.Agency;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/1/22
 * @Time: 15:33
 * @Description：中介与数据库交互接口
 */
public interface AgencyDao {

    //新增中介
    void insert(Agency agency);

    //通过用户id查找中介信息
    Agency selectByUserId(Integer userId);

    //通过用户id修改中介信息
    void update(Agency agency);

    //查找所有中介信息
    List<Agency> selectAll(String status);

}
