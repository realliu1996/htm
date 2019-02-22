package cn.realliu.htm.dao;

import cn.realliu.htm.common.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/1/15
 * @Time: 11:37
 * @Description：用户与数据库交互接口
 */
public interface UserDao {

    //新增用户
    void insert(User user);

    //通过用户账号，密码查找用户
    User selectByNamePassword(@Param("userName") String userName, @Param("userPassWord") String userPassWord);

    //通过用户名查找用户
    User selectByUserName(String userName);
}
