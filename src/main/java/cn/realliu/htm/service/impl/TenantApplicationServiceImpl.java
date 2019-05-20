package cn.realliu.htm.service.impl;

import cn.realliu.htm.common.bean.*;
import cn.realliu.htm.common.exception.CommonException;
import cn.realliu.htm.dao.*;
import cn.realliu.htm.service.interfaces.HouseService;
import cn.realliu.htm.service.interfaces.TenantApplicationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/3/22
 * @Time: 12:08
 * @Description：租房申请单逻辑实现
 */
@Service
@Transactional(isolation= Isolation.DEFAULT,propagation= Propagation.REQUIRED,readOnly=true)
public class TenantApplicationServiceImpl implements TenantApplicationService {

    @Autowired
    private TenantApplicationDao tenantApplicationDao;
    @Autowired
    private HouseService houseService;
    @Autowired
    private LandlordDao landlordDao;
    @Autowired
    private TenantDao tenantDao;
    @Autowired
    private AgencyDao agencyDao;
    @Autowired
    private HouseDao houseDao;
    @Autowired
    private ContractDao contractDao;
    @Autowired
    private Contract contract;

    /**
     * 新增租房申请单
     * @param tenantApplication 租房申请单信息
     * @throws CommonException
     */
    @Override
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
    public void insertTenantApplication(TenantApplication tenantApplication) throws CommonException {

        if (tenantApplication.getAgencyId() == 0 || StringUtils.isBlank(tenantApplication.getApplyType()) ||
            tenantApplication.getHouseId() == 0 || tenantApplication.getLandlordId() == 0 || tenantApplication.getRentalPrice() == 0 ||
            tenantApplication.getRentalTime() == 0 || StringUtils.isBlank(tenantApplication.getStatus()) ) {
                throw CommonException.getException(401);
        }

        House house = houseService.selectById(tenantApplication.getHouseId());
        tenantApplication.setCommunity(house.getCommunity());

        Landlord landlord = landlordDao.selectByLandlordId(tenantApplication.getLandlordId());
        tenantApplication.setLandlordName(landlord.getLandlordName());

        Tenant tenant = tenantDao.selectByTenantId(tenantApplication.getTenantId());
        tenantApplication.setTenantName(tenant.getTenantName());

        Agency agency = agencyDao.selectByAgencyId(tenantApplication.getAgencyId());
        tenantApplication.setAgencyName(agency.getAgencyName());

        tenantApplicationDao.insert(tenantApplication);

        houseService.updateStatus(tenantApplication.getHouseId(),"E");

    }

    /**
     * 按条件查询申请单
     * @param landlordName 房东名称
     * @param tenantName 租客名称
     * @param agencyId 中介id
     * @param status 申请单状态
     * @throws CommonException
     */
    @Override
    public List<TenantApplication> selectByCond(String landlordName, String tenantName, Integer agencyId,String status) throws CommonException{

        List<TenantApplication> tenantApplications = tenantApplicationDao.selectByCond(landlordName, tenantName, agencyId,status);

        for (TenantApplication tenantApplication:tenantApplications
             ) {

            if ("T".equals(tenantApplication.getApplyType())){
                tenantApplication.setApplyType("租房申请单");
            }
            if ("SR".equals(tenantApplication.getStatus())){
                tenantApplication.setStatus("提交申请");
            }
        }

        return tenantApplications;
    }


    /**
     * 申请单处理
     * @param applyId 申请单id
     * @param houseId 房屋id
     * @param view 处理结果
     * @return String 审核结果
     * @throws CommonException
     */
    @Override
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
    public String reviewForTenant(Integer applyId,Integer houseId,String view) throws CommonException{

        tenantApplicationDao.update(applyId,view);
        if ("E".equals(view)){

            houseDao.updateStatus(houseId,"U");

            return "true";
        }

        return "true";

    }

    /**
     * 按条件查询申请单
     * @param landlordName 房东名称
     * @param tenantName 租客名称
     * @param landlordId 房东id
     * @param status 申请单状态
     * @throws CommonException
     */
    @Override
    public List<TenantApplication> selectForLandlord(String landlordName,String tenantName,Integer landlordId,String status) throws CommonException{

        List<TenantApplication> tenantApplications = tenantApplicationDao.selectForLandlord(landlordName, tenantName, landlordId, status);

        for (TenantApplication tenantApplication:tenantApplications
        ) {

            if ("T".equals(tenantApplication.getApplyType())){
                tenantApplication.setApplyType("租房申请单");
            }
            if ("LR".equals(tenantApplication.getStatus())){
                tenantApplication.setStatus("房东审核");
            }
        }

        return tenantApplications;
    }

    /**
     * 申请单房东审核处理
     * @param applyId 申请单id
     * @param houseId 房屋id
     * @param view 处理结果
     * @return String 审核结果
     * @throws CommonException
     */
    @Override
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
    public String reviewByLandlord(Integer applyId,Integer houseId,String view) throws CommonException{
        tenantApplicationDao.update(applyId,view);
        if ("E".equals(view)){
            houseDao.updateStatus(houseId,"U");
            return "true";
        }

        TenantApplication tenantApplication = tenantApplicationDao.selectByApplyId(applyId);

        contract.setHouseId(houseId);
        contract.setCommunity(tenantApplication.getCommunity());
        contract.setLandlordId(tenantApplication.getLandlordId());
        contract.setLandlordName(tenantApplication.getLandlordName());
        contract.setTenantId(tenantApplication.getTenantId());
        contract.setTenantName(tenantApplication.getTenantName());
        contract.setAgencyId(tenantApplication.getAgencyId());
        contract.setAgencyName(tenantApplication.getAgencyName());
        contract.setRentalPrice(tenantApplication.getRentalPrice());
        contract.setRentalTime(tenantApplication.getRentalTime());

        Calendar calendar = Calendar.getInstance();
        String stime = calendar.get(Calendar.YEAR) +"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.DATE);
        calendar.add(Calendar.MONTH,tenantApplication.getRentalTime());
        String etime =  calendar.get(Calendar.YEAR) +"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.DATE);

        contract.setStartTime(stime);
        contract.setEndTime(etime);
        contract.setLandlordConfirm("E");
        contract.setTenantConfirm("E");
        contract.setPayment("E");
        contract.setStatus("LR");

        contractDao.insert(contract);

        return "true";
    }

    /**
     * 按条件查询申请单
     * @param landlordName 房东名称
     * @param tenantName 租客名称
     * @param tenantId 租客id
     * @param status 申请单状态
     * @throws CommonException
     */
    @Override
    public List<TenantApplication> selectForTenant(String landlordName,String tenantName,Integer tenantId,String status) throws CommonException{

        List<TenantApplication> tenantApplications = tenantApplicationDao.selectForTenant(landlordName, tenantName, tenantId, status);

        for (TenantApplication tenantApplication:tenantApplications
             ) {

            if ("T".equals(tenantApplication.getApplyType())){
                tenantApplication.setApplyType("租房申请单");
            }
            if ("SR".equals(tenantApplication.getStatus())){
                tenantApplication.setStatus("中介审核");
            }
            if ("LR".equals(tenantApplication.getStatus())){
                tenantApplication.setStatus("房东审核");
            }
            if ("U".equals(tenantApplication.getStatus())){
                tenantApplication.setStatus("审核通过");
            }
            if ("E".equals(tenantApplication.getStatus())){
                tenantApplication.setStatus("审核不通过");
            }

        }

        return tenantApplications;
    }

    /**
     * 通过房屋id查找申请单信息
     * @param houseId 房屋id
     * @return TenantApplication 申请单实体
     * @throws CommonException
     */
    @Override
    public TenantApplication selectByHouseId(Integer houseId) throws CommonException{

        TenantApplication tenantApplication = tenantApplicationDao.selectByHouseId(houseId);

        if (tenantApplication == null){
            throw  CommonException.getException(404);
        }
        return tenantApplication;
    }

    /**
     * 支付成功修改申请单
     * @param applyId 申请单id
     * @param status 状态
     * @throws CommonException
     */
    @Override
    public void reviewForPay(Integer applyId,String status) throws CommonException{

        tenantApplicationDao.update(applyId,status);

    }

    /**
     * 统计报表查询租房申请单（房东）
     * @param tenantName 租客名称
     * @param landlordId 房东id
     * @param status 申请单状态
     * @throws CommonException
     */
    @Override
    public List<TenantApplication> selectCountForLandlord(String tenantName,Integer landlordId,String status) throws CommonException{

        List<TenantApplication> tenantApplications = tenantApplicationDao.selectCountForLandlord(tenantName, landlordId, status);

        for (TenantApplication tenantApplication:tenantApplications
        ) {

            if ("T".equals(tenantApplication.getApplyType())){
                tenantApplication.setApplyType("租房申请单");
            }
            if ("SR".equals(tenantApplication.getStatus())){
                tenantApplication.setStatus("中介审核");
            }
            if ("LR".equals(tenantApplication.getStatus())){
                tenantApplication.setStatus("房东审核");
            }
            if ("U".equals(tenantApplication.getStatus())){
                tenantApplication.setStatus("审核通过");
            }
            if ("E".equals(tenantApplication.getStatus())){
                tenantApplication.setStatus("审核不通过");
            }
        }

        return tenantApplications;

    }

    /**
     * 统计报表查询租房申请单（中介）
     * @param landlordName 房东名称
     * @param tenantName 租客名称
     * @param agencyId 中介id
     * @param status 申请单状态
     * @throws CommonException
     */
    @Override
    public List<TenantApplication> selectCountForAgency(String landlordName,String tenantName,Integer agencyId,String status) throws CommonException{

        List<TenantApplication> tenantApplications = tenantApplicationDao.selectCountForAgency(landlordName, tenantName, agencyId, status);

        for (TenantApplication tenantApplication:tenantApplications
        ) {

            if ("T".equals(tenantApplication.getApplyType())){
                tenantApplication.setApplyType("租房申请单");
            }
            if ("SR".equals(tenantApplication.getStatus())){
                tenantApplication.setStatus("中介审核");
            }
            if ("LR".equals(tenantApplication.getStatus())){
                tenantApplication.setStatus("房东审核");
            }
            if ("U".equals(tenantApplication.getStatus())){
                tenantApplication.setStatus("审核通过");
            }
            if ("E".equals(tenantApplication.getStatus())){
                tenantApplication.setStatus("审核不通过");
            }
        }

        return tenantApplications;

    }


}
