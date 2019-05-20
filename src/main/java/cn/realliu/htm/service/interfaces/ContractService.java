package cn.realliu.htm.service.interfaces;

import cn.realliu.htm.common.bean.Contract;
import cn.realliu.htm.common.exception.CommonException;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/4/17
 * @Time: 15:16
 * @Description：合同逻辑接口
 */
public interface ContractService {

    /**
     * 新增合同
     * @param contract 合同信息
     * @throws CommonException
     */
    void insertContract(Contract contract) throws CommonException;

    /**
     * 通过房东id和合同状态查找合同信息
     * @param landlordId 房东id
     * @param status 合同状态
     * @return Contract 合同实体
     * @throws CommonException
     */
    List<Contract> selectByLandlordId(Integer landlordId,String status) throws CommonException;

    /**
     * 通过合同id查找合同信息
     * @param contractId 合同id
     * @return Contract 合同实体
     * @throws CommonException
     */
    Contract selectByContractId(Integer contractId) throws CommonException;

    /**
     * 房东合同处理
     * @param contractId 合同id
     * @param view 处理结果
     * @throws CommonException
     */
    void contractProcess(Integer contractId,String view) throws CommonException;

    /**
     * 付款成功修改合同状态
     * @param contractId 合同id
     * @param status 合同状态
     * @throws CommonException
     */
    void contractAliPay(Integer contractId,String payment,String status) throws CommonException;

    /**
     * 通过租客id和合同状态查找合同信息
     * @param tenantId 租客id
     * @param status 合同状态
     * @return Contract 合同实体
     * @throws CommonException
     */
    List<Contract> selectByTenantId(Integer tenantId,String status) throws CommonException;

    /**
     * 租客合同拒绝处理
     * @param contractId 合同id
     * @throws CommonException
     */
    void contractTenant(Integer contractId) throws CommonException;

    /**
     * 通过房东租客查询合同信息
     * @param landlordName 房东名称
     * @param tenantName 租客名称
     * @param agencyId 中介id
     * @return Contract 合同实体
     * @throws CommonException
     */
    List<Contract> selectForAgency(String landlordName,String tenantName,Integer agencyId) throws CommonException;

}
