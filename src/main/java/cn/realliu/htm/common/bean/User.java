package cn.realliu.htm.common.bean;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/1/15
 * @Time: 11:28
 * @Description：用户实体
 */
public class User {

    private static final long serialVersionUID = 1L;

    //用户编号
    private Integer userId;
    //用户名称
    private String userName;
    //用户密码
    private String userPassword;
    //用户角色
    private String userRole;

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRole() {
        return this.userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
