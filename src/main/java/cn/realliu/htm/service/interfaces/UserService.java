package cn.realliu.htm.service.interfaces;

import cn.realliu.htm.common.bean.User;
import cn.realliu.htm.common.exception.CommonException;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/1/15
 * @Time: 15:08
 * @Description：用户逻辑接口
 */
public interface UserService {

    /**
     * 新增用户
     * @param user 用户信息
     * @throws CommonException
     */
    void insertUser(User user) throws CommonException;

    /**
     * 通过用户账号，密码查询用户
     * @param userName 用户名
     * @param userPassword 用户密码
     * @return User 用户实体
     * @throws CommonException
     */
    User selectByNamePassword(String userName,String userPassword) throws CommonException;

    /**
     * 通过用户账号查询用户
     * @param userName 用户名
     * @return User 用户实体
     * @throws CommonException
     */
    User selectByUserName(String userName) throws CommonException;

}
