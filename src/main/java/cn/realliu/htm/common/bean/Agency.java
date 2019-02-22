package cn.realliu.htm.common.bean;

import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/1/22
 * @Time: 15:25
 * @Description：中介实体
 */
@Component
public class Agency {

    private static final long serialVersionUID = 1L;

    //中介id
    private Integer agencyId;

    //用户id
    private Integer userId;

    //中介昵称
    private String agencyNick;

    //角色
    private String role;

    //中介名称
    private String agencyName;

    //中介法人
    private String agencyLegal;

    //联系地址
    private String agencyAddr;

    //联系电话
    private String agencyTel;

    //联系邮箱
    private String agencyMail;

    //成立时间
    private String established;

    //注册资金
    private String agencyFunds;

    //状态
    private String status;

    public Integer getAgencyId() {
        return this.agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAgencyNick() {
        return this.agencyNick;
    }

    public void setAgencyNick(String agencyNick) {
        this.agencyNick = agencyNick;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAgencyName() {
        return this.agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyLegal() {
        return this.agencyLegal;
    }

    public void setAgencyLegal(String agencyLegal) {
        this.agencyLegal = agencyLegal;
    }

    public String getAgencyAddr() {
        return this.agencyAddr;
    }

    public void setAgencyAddr(String agencyAddr) {
        this.agencyAddr = agencyAddr;
    }

    public String getAgencyTel() {
        return this.agencyTel;
    }

    public void setAgencyTel(String agencyTel) {
        this.agencyTel = agencyTel;
    }

    public String getAgencyMail() {
        return this.agencyMail;
    }

    public void setAgencyMail(String agencyMail) {
        this.agencyMail = agencyMail;
    }

    public String getEstablished() {
        return this.established;
    }

    public void setEstablished(String established) {
        this.established = established;
    }

    public String getAgencyFunds() {
        return this.agencyFunds;
    }

    public void setAgencyFunds(String agencyFunds) {
        this.agencyFunds = agencyFunds;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
