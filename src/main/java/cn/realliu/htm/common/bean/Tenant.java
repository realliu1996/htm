package cn.realliu.htm.common.bean;

import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/1/16
 * @Time: 16:58
 * @Description：租客实体
 */
@Component
public class Tenant {

    private static final long serialVersionUID = 1L;

    //租客id
    private Integer tenantId;

    //用户id
    private Integer userId;

    //租客昵称
    private String tenantNick;

    //角色
    private String role;

    //租客名称
    private String tenantName;

    //性别
    private String tenantSex;

    //出生年月
    private String tenantBirth;

    //联系地址
    private String tenantAddr;

    //联系电话
    private String tenantTel;

    //联系邮箱
    private String tenantMail;

    //工作
    private String tenantWork;

    //收入水平
    private String tenantIncome;

    //状态
    private String status;

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTenantNick() {
        return tenantNick;
    }

    public void setTenantNick(String tenantNick) {
        this.tenantNick = tenantNick;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getTenantSex() {
        return tenantSex;
    }

    public void setTenantSex(String tenantSex) {
        this.tenantSex = tenantSex;
    }

    public String getTenantBirth() {
        return tenantBirth;
    }

    public void setTenantBirth(String tenantBirth) {
        this.tenantBirth = tenantBirth;
    }

    public String getTenantAddr() {
        return tenantAddr;
    }

    public void setTenantAddr(String tenantAddr) {
        this.tenantAddr = tenantAddr;
    }

    public String getTenantTel() {
        return tenantTel;
    }

    public void setTenantTel(String tenantTel) {
        this.tenantTel = tenantTel;
    }

    public String getTenantMail() {
        return tenantMail;
    }

    public void setTenantMail(String tenantMail) {
        this.tenantMail = tenantMail;
    }

    public String getTenantWork() {
        return tenantWork;
    }

    public void setTenantWork(String tenantWork) {
        this.tenantWork = tenantWork;
    }

    public String getTenantIncome() {
        return tenantIncome;
    }

    public void setTenantIncome(String tenantIncome) {
        this.tenantIncome = tenantIncome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
