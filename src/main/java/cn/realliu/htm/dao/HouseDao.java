package cn.realliu.htm.dao;

import cn.realliu.htm.common.bean.House;
import org.apache.ibatis.annotations.Param;

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

    //按时间查询所有房屋信息
    List<House> selectOrder(String status);

    //按房屋id查询房屋信息
    House selectById(Integer houseId);

    //按房屋id修改房屋状态
    void updateStatus(@Param("houseId") Integer houseId,@Param("status")String status);

    //按条件查询房屋信息
    List<House> selectByCond(@Param("userId")Integer userId,@Param("community")String community, @Param("layerNum")Integer layerNum,
                             @Param("houseType")String houseType,@Param("houseArea")Double houseArea, @Param("price")Integer price);
}
