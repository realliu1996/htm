package cn.realliu.htm.service.interfaces;

import cn.realliu.htm.common.bean.LandlordApplication;
import cn.realliu.htm.common.exception.CommonException;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/4/12
 * @Time: 22:22
 * @Description：房屋录入申请单逻辑接口
 */
public interface LandlordApplicationService {

    /**
     * 新增房屋录入申请单
     * @param landlordApplication 房屋录入申请单信息
     * @throws CommonException
     */
    void insertLandlordApplication(LandlordApplication landlordApplication) throws CommonException;

    /**
     * 按条件查询申请单
     * @param landlordId 房东id
     * @param status 房屋录入申请单信息
     * @param agencyId 中介id
     * @throws CommonException
     */
    List<LandlordApplication> selectByCond(Integer landlordId,String status,Integer agencyId) throws CommonException;

    /**
     * 申请单处理
     * @param applyId 申请单id
     * @param houseId 房屋id
     * @param view 处理结果
     * @return String 审核结果
     * @throws CommonException
     */
    String reviewForLandlord(Integer applyId,Integer houseId,String view) throws CommonException;
}
