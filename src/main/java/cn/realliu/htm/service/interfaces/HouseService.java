package cn.realliu.htm.service.interfaces;

import cn.realliu.htm.common.bean.House;
import cn.realliu.htm.common.exception.CommonException;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/1/23
 * @Time: 10:23
 * @Description：房屋逻辑接口
 */
public interface HouseService {

    /**
     * 新增房屋
     * @param house 房屋信息
     * @throws CommonException
     */
    void insertHouse(House house) throws CommonException;


    /**
     * 查找所有房屋信息
     * @param status 房屋状态
     * @return House 房屋实体集合
     * @throws CommonException
     */
    List<House> selectAll(String status) throws CommonException;


}
