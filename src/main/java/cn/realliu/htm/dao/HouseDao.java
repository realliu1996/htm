package cn.realliu.htm.dao;

import cn.realliu.htm.common.bean.House;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/1/23
 * @Time: 9:56
 * @Description：房屋与数据库交互接口
 */
public interface HouseDao {

    //新增房屋
    void insert(House house);

    //查询所有房屋信息
    List<House> selectAll(String status);
}
