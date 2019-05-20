package cn.realliu.htm.common.bean;

import org.springframework.stereotype.Component;

import java.sql.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/3/22
 * @Time: 11:23
 * @Description：租房申请单实体
 */
@Component
public class TenantApplication {

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

    //租客id
    private Integer tenantId;

    //租客名称
    private String tenantName;

    //中介id
    private Integer agencyId;

    //中介名称
    private String agencyName;

    //租房单价
    private Integer rentalPrice;

    //租房时间
    private Integer rentalTime;

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

    public Integer getTenantId() {
        return this.tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return this.tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
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

    public Integer getRentalPrice() {
        return this.rentalPrice;
    }

    public void setRentalPrice(Integer rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public Integer getRentalTime() {
        return this.rentalTime;
    }

    public void setRentalTime(Integer rentalTime) {
        this.rentalTime = rentalTime;
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
