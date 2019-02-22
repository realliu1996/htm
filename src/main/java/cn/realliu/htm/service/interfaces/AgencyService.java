package cn.realliu.htm.service.interfaces;

import cn.realliu.htm.common.bean.Agency;
import cn.realliu.htm.common.exception.CommonException;

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
}
