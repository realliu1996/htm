package cn.realliu.htm.service.interfaces;

import cn.realliu.htm.common.bean.TenantApplication;
import cn.realliu.htm.common.exception.CommonException;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/3/22
 * @Time: 12:04
 * @Description：租房申请单逻辑接口
 */
public interface TenantApplicationService {

    /**
     * 新增租房申请单
     * @param tenantApplication 租房申请单信息
     * @throws CommonException
     */
    void insertTenantApplication(TenantApplication tenantApplication) throws CommonException;


    /**
     * 按条件查询申请单
     * @param landlordName 房东名称
     * @param tenantName 租客名称
     * @param agencyId 中介id
     * @param status 申请单状态
     * @throws CommonException
     */
    List<TenantApplication> selectByCond(String landlordName,String tenantName,Integer agencyId,String status) throws CommonException;

    /**
     * 申请单处理
     * @param applyId 申请单id
     * @param houseId 房屋id
     * @param view 处理结果
     * @return String 审核结果
     * @throws CommonException
     */
    String reviewForTenant(Integer applyId,Integer houseId,String view) throws CommonException;

    /**
     * 按条件查询申请单
     * @param landlordName 房东名称
     * @param tenantName 租客名称
     * @param landlordId 房东id
     * @param status 申请单状态
     * @throws CommonException
     */
    List<TenantApplication> selectForLandlord(String landlordName,String tenantName,Integer landlordId,String status) throws CommonException;

    /**
     * 申请单房东审核处理
     * @param applyId 申请单id
     * @param houseId 房屋id
     * @param view 处理结果
     * @return String 审核结果
     * @throws CommonException
     */
    String reviewByLandlord(Integer applyId,Integer houseId,String view) throws CommonException;

    /**
     * 按条件查询申请单
     * @param landlordName 房东名称
     * @param tenantName 租客名称
     * @param tenantId 租客id
     * @param status 申请单状态
     * @throws CommonException
     */
    List<TenantApplication> selectForTenant(String landlordName,String tenantName,Integer tenantId,String status) throws CommonException;

    /**
     * 通过房屋id查找申请单信息
     * @param houseId 房屋id
     * @return TenantApplication 申请单实体
     * @throws CommonException
     */
    TenantApplication selectByHouseId(Integer houseId) throws CommonException;

    /**
     * 支付成功修改申请单
     * @param applyId 申请单id
     * @param status 状态
     * @throws CommonException
     */
    void reviewForPay(Integer applyId,String status) throws CommonException;

    /**
     * 统计报表查询租房申请单（房东）
     * @param tenantName 租客名称
     * @param landlordId 房东id
     * @param status 申请单状态
     * @throws CommonException
     */
    List<TenantApplication> selectCountForLandlord(String tenantName,Integer landlordId,String status) throws CommonException;

    /**
     * 统计报表查询租房申请单（中介）
     * @param landlordName 房东名称
     * @param tenantName 租客名称
     * @param agencyId 中介id
     * @param status 申请单状态
     * @throws CommonException
     */
    List<TenantApplication> selectCountForAgency(String landlordName,String tenantName,Integer agencyId,String status) throws CommonException;

}
