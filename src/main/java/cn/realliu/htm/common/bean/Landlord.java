package cn.realliu.htm.common.bean;

import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/1/21
 * @Time: 16:34
 * @Description：房东实体
 */
@Component
public class Landlord {

    private static final long serialVersionUID = 1L;

    //房东id
    private Integer landlordId;

    //用户id
    private Integer userId;

    //房东昵称
    private String landlordNick;

    //角色
    private String role;

    //房东名称
    private String landlordName;

    //性别
    private String landlordSex;

    //出生年月
    private String landlordBirth;

    //联系地址
    private String landlordAddr;

    //联系电话
    private String landlordTel;

    //联系邮箱
    private String landlordMail;

    //工作
    private String landlordWork;

    //状态
    private String status;

    public Integer getLandlordId() {
        return this.landlordId;
    }

    public void setLandlordId(Integer landlordId) {
        this.landlordId = landlordId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLandlordNick() {
        return this.landlordNick;
    }

    public void setLandlordNick(String landlordNick) {
        this.landlordNick = landlordNick;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLandlordName() {
        return this.landlordName;
    }

    public void setLandlordName(String landlordName) {
        this.landlordName = landlordName;
    }

    public String getLandlordSex() {
        return this.landlordSex;
    }

    public void setLandlordSex(String landlordSex) {
        this.landlordSex = landlordSex;
    }

    public String getLandlordBirth() {
        return this.landlordBirth;
    }

    public void setLandlordBirth(String landlordBirth) {
        this.landlordBirth = landlordBirth;
    }

    public String getLandlordAddr() {
        return this.landlordAddr;
    }

    public void setLandlordAddr(String landlordAddr) {
        this.landlordAddr = landlordAddr;
    }

    public String getLandlordTel() {
        return this.landlordTel;
    }

    public void setLandlordTel(String landlordTel) {
        this.landlordTel = landlordTel;
    }

    public String getLandlordMail() {
        return this.landlordMail;
    }

    public void setLandlordMail(String landlordMail) {
        this.landlordMail = landlordMail;
    }

    public String getLandlordWork() {
        return this.landlordWork;
    }

    public void setLandlordWork(String landlordWork) {
        this.landlordWork = landlordWork;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
