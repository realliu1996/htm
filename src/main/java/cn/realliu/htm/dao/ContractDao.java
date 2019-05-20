package cn.realliu.htm.dao;

import cn.realliu.htm.common.bean.Contract;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/4/17
 * @Time: 14:56
 * @Description：合同与数据库交互接口
 */
public interface ContractDao {

    //新增合同
    void insert(Contract contract);

    //通过房东id和合同状态查找合同信息
    List<Contract> selectByLandlordId(@Param("landlordId")Integer landlordId,@Param("status")String status);

    //通过合同id查找合同信息
    Contract selectByContractId(Integer contractId);

    //通过合同id修改合同状态
    void update(@Param("contractId")Integer contractId,@Param("landlordConfirm")String landlordConfirm,@Param("tenantConfirm")String tenantConfirm,@Param("status")String status);

    //付款成功修改合同状态
    void updateForPay(@Param("contractId")Integer contractId,@Param("landlordConfirm")String landlordConfirm,@Param("tenantConfirm")String tenantConfirm,@Param("payment")String payment,@Param("status")String status);


    //通过租客id和合同状态查找合同信息
    List<Contract> selectByTenantId(@Param("tenantId")Integer tenantId,@Param("status")String status);

    //通过房东租客查询合同信息
    List<Contract> selectForAgency(@Param("landlordName")String landlordName,@Param("tenantName")String tenantName,@Param("agencyId")Integer agencyId);

}
