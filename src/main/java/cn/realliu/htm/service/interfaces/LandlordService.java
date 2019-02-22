package cn.realliu.htm.service.interfaces;

import cn.realliu.htm.common.bean.Landlord;
import cn.realliu.htm.common.exception.CommonException;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/1/21
 * @Time: 17:04
 * @Description：房东逻辑接口
 */
public interface LandlordService {

    /**
     * 通过用户id查找房东信息
     * @param userId 用户id
     * @return Landlord 房东实体
     * @throws CommonException
     */
    Landlord selectByUserId(Integer userId) throws CommonException;

    /**
     * 通过用户id修改房东信息
     * @param landlord 房东实体
     * @throws CommonException
     */
    void update(Landlord landlord) throws CommonException;
}
