package cn.realliu.htm.common.bean;

import org.springframework.stereotype.Component;

import java.sql.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/4/10
 * @Time: 22:11
 * @Description：房屋录入申请单实体
 */
@Component
public class LandlordApplication {

    private static final long serialVersionUID = 1L;

    //申请单id
    private Integer applyId;

    //申请单类型
    private String applyType;

    //房屋id
    private Integer houseId;

    //房屋小区
    private String community;

    //房东id
    private Integer landlordId;

    //房东名称
    private String landlordName;

    //中介id
    private Integer agencyId;

    //中介名称
    private String agencyName;

    //申请单状态
    private String status;

    //创建时间
    private Date date;

    public Integer getApplyId() {
        return this.applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public String getApplyType() {
        return this.applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public Integer getHouseId() {
        return this.houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getCommunity() {
        return this.community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public Integer getLandlordId() {
        return this.landlordId;
    }

    public void setLandlordId(Integer landlordId) {
        this.landlordId = landlordId;
    }

    public String getLandlordName() {
        return this.landlordName;
    }

    public void setLandlordName(String landlordName) {
        this.landlordName = landlordName;
    }

    public Integer getAgencyId() {
        return this.agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

    public String getAgencyName() {
        return this.agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
