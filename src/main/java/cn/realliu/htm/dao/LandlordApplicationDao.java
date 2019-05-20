package cn.realliu.htm.dao;

import cn.realliu.htm.common.bean.LandlordApplication;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/4/11
 * @Time: 22:17
 * @Description：房屋录入申请单与数据库交互接口
 */
public interface LandlordApplicationDao {

    //新增房屋录入申请单
    void insert(LandlordApplication landlordApplication);

    //按条件查询申请单
    List<LandlordApplication> selectByCond(@Param("landlordId") Integer landlordId,@Param("status") String status,@Param("agencyId") Integer agencyId);

    //通过申请单id修改申请单
    void update(@Param("applyId")Integer applyId,@Param("status")String status);
}
