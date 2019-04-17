package cn.realliu.htm.service.interfaces;

import cn.realliu.htm.common.bean.Agency;
import cn.realliu.htm.common.exception.CommonException;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/1/22
 * @Time: 15:49
 * @Description：中介逻辑接口
 */
public interface AgencyService {

    /**
     * 通过用户id查找中介信息
     * @param userId 用户id
     * @return Agency 中介实体
     * @throws CommonException
     */
    Agency selectByUserId(Integer userId) throws CommonException;

    /**
     * 通过用户id修改房东信息
     * @param agency 中介实体
     * @throws CommonException
     */
    void update(Agency agency) throws CommonException;

    /**
     * 查找所有中介信息
     * @param status 中介状态
     * @return Agency 中介实体集合
     * @throws CommonException
     */
    List<Agency> selectAll(String status)throws CommonException;

    /**
     * 根据中介id查找中介信息
     * @param agencyId 中介id
     * @return Agency 中介实体
     * @throws CommonException
     */
    Agency selectByAgencyId(Integer agencyId) throws CommonException;
}
