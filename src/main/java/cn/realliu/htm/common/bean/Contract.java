package cn.realliu.htm.common.bean;

import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/4/18
 * @Time: 14:46
 * @Description：合同实体
 */
@Component
public class Contract {

    private static final long serialVersionUID = 1L;

    //合同id
    private Integer contractId;

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

    //合同开始时间
    private String startTime;

    //合同结束时间
    private String endTime;

    //房东确认
    private String landlordConfirm;

    //租客确认
    private String tenantConfirm;

    //是否付款
    private String payment;

    //合同状态
    private String status;

    public Integer getContractId() {
        return this.contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
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

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLandlordConfirm() {
        return this.landlordConfirm;
    }

    public void setLandlordConfirm(String landlordConfirm) {
        this.landlordConfirm = landlordConfirm;
    }

    public String getTenantConfirm() {
        return this.tenantConfirm;
    }

    public void setTenantConfirm(String tenantConfirm) {
        this.tenantConfirm = tenantConfirm;
    }

    public String getPayment() {
        return this.payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
