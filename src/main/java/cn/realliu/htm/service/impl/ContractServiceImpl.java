package cn.realliu.htm.service.impl;

import cn.realliu.htm.common.bean.Contract;
import cn.realliu.htm.common.exception.CommonException;
import cn.realliu.htm.dao.ContractDao;
import cn.realliu.htm.dao.HouseDao;
import cn.realliu.htm.service.interfaces.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/4/17
 * @Time: 15:16
 * @Description：合同逻辑实现
 */
@Service
@Transactional(isolation= Isolation.DEFAULT,propagation= Propagation.REQUIRED,readOnly=true)
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractDao contractDao;
    @Autowired
    private HouseDao houseDao;

    /**
     * 新增合同
     * @param contract 合同信息
     * @throws CommonException
     */
    @Override
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
    public void insertContract(Contract contract) throws CommonException{

        contractDao.insert(contract);

    }

    /**
     * 通过房东id和合同状态查找合同信息
     * @param landlordId 房东id
     * @param status 合同状态
     * @return Contract 合同实体
     * @throws CommonException
     */
    @Override
    public List<Contract> selectByLandlordId(Integer landlordId, String status) throws CommonException{

        List<Contract> contracts = contractDao.selectByLandlordId(landlordId, status);

        for (Contract contract:contracts
             ) {
            if ("LR".equals(contract.getStatus())){
                contract.setStatus("房东确认");
            }
        }

        return contracts;
    }

    /**
     * 通过合同id查找合同信息
     * @param contractId 合同id
     * @return Contract 合同实体
     * @throws CommonException
     */
    @Override
    public Contract selectByContractId(Integer contractId) throws CommonException{

        Contract contract = contractDao.selectByContractId(contractId);

        return contract;
    }

    /**
     * 房东合同处理
     * @param contractId 合同id
     * @param view 处理结果
     * @throws CommonException
     */
    @Override
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
    public void contractProcess(Integer contractId,String view) throws CommonException{
        if ("agree".equals(view)){

            contractDao.update(contractId,"U","E","TR");

        }else if ("refuse".equals(view)){
            contractDao.update(contractId,"E","E","F");
            Contract contract = contractDao.selectByContractId(contractId);
            houseDao.updateStatus(contract.getHouseId(),"U");
        }
    }

    /**
     * 付款成功修改合同状态
     * @param contractId 合同id
     * @param status 合同状态
     * @throws CommonException
     */
    @Override
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
    public void contractAliPay(Integer contractId,String payment,String status) throws CommonException{

        contractDao.updateForPay(contractId,"U","U",payment,status);
    }

    /**
     * 通过租客id和合同状态查找合同信息
     * @param tenantId 租客id
     * @param status 合同状态
     * @return Contract 合同实体
     * @throws CommonException
     */
    @Override
    public List<Contract> selectByTenantId(Integer tenantId,String status) throws CommonException{

        List<Contract> contracts = contractDao.selectByTenantId(tenantId, status);

        for (Contract contract:contracts
        ) {
            if ("E".equals(contract.getPayment())){
                contract.setPayment("未付款");
            }
            if ("LR".equals(contract.getStatus())){
                contract.setStatus("房东确认");
            }
            if ("TR".equals(contract.getStatus())){
                contract.setStatus("租客确认");
            }
            if ("F".equals(contract.getStatus())){
                contract.setStatus("合同已完成");
            }
            if ("U".equals(contract.getPayment())){
                contract.setPayment("已付款");
            }
        }

        return contracts;

    }

    /**
     * 租客合同拒绝处理
     * @param contractId 合同id
     * @throws CommonException
     */
    @Override
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
    public void contractTenant(Integer contractId) throws CommonException{

            contractDao.update(contractId,"U","E","F");
            Contract contract = contractDao.selectByContractId(contractId);
            houseDao.updateStatus(contract.getHouseId(),"U");
    }


    /**
     * 通过房东租客查询合同信息
     * @param landlordName 房东名称
     * @param tenantName 租客名称
     * @param agencyId 中介id
     * @return Contract 合同实体
     * @throws CommonException
     */
    @Override
    public List<Contract> selectForAgency(String landlordName,String tenantName,Integer agencyId) throws CommonException{

        List<Contract> contracts = contractDao.selectForAgency(landlordName, tenantName, agencyId);

        for (Contract contract:contracts
        ) {
            if ("LR".equals(contract.getStatus())){
                contract.setStatus("房东确认");
            }
            if ("TR".equals(contract.getStatus())){
                contract.setStatus("租客确认");
            }
            if ("F".equals(contract.getStatus())){
                contract.setStatus("合同已完成");
            }

            if ("E".equals(contract.getPayment())){
                contract.setPayment("未付款");
            }
            if ("U".equals(contract.getPayment())){
                contract.setPayment("已付款");
            }

        }


        return contracts;

    }


}
