package cn.realliu.htm.dao;

import cn.realliu.htm.common.bean.TenantApplication;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    //按条件查询申请单
    List<TenantApplication> selectByCond(@Param("landlordName") String landlordName,@Param("tenantName") String tenantName,@Param("agencyId") Integer agencyId,@Param("status") String status);

    //通过申请单id修改申请单
    void update(@Param("applyId")Integer applyId,@Param("status")String status);

    //按条件查询申请单(房东)
    List<TenantApplication> selectForLandlord(@Param("landlordName") String landlordName,@Param("tenantName") String tenantName,@Param("landlordId") Integer landlordId,@Param("status") String status);

    //按申请单id查询申请单
    TenantApplication selectByApplyId(Integer applyId);

    //按条件查询申请单(租客)
    List<TenantApplication> selectForTenant(@Param("landlordName") String landlordName,@Param("tenantName") String tenantName,@Param("tenantId") Integer tenantId,@Param("status") String status);

    //通过房屋id查询申请单
    TenantApplication selectByHouseId(Integer houseId);

    //统计报表查询租房申请单（房东）
    List<TenantApplication> selectCountForLandlord(@Param("tenantName")String tenantName,@Param("landlordId")Integer landlordId,@Param("status")String status);

    //统计报表查询租房申请单（中介）
    List<TenantApplication> selectCountForAgency(@Param("landlordName") String landlordName,@Param("tenantName") String tenantName,@Param("agencyId")Integer agencyId,@Param("status") String status);
}
