package cn.realliu.htm.web.controller;

import cn.realliu.htm.common.bean.*;
import cn.realliu.htm.common.exception.CommonException;
import cn.realliu.htm.service.interfaces.ContractService;
import cn.realliu.htm.service.interfaces.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/4/12
 * @Time: 18:06
 * @Description：合同业务
 */
@Service
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private ContractService contractService;
    @Autowired
    private HouseService houseService;

    //通过房东id和合同状态查找合同信息
    @RequestMapping(value = "/selectByLandlordId",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectByLandlordId(HttpSession session){

        Landlord landlord = (Landlord) session.getAttribute("landlord");

        try{
            List<Contract> contracts = contractService.selectByLandlordId(landlord.getLandlordId(), "LR");
            session.setAttribute("contracts",contracts);
            return "redirect:/showContractForLandlord";

        }catch (CommonException e){
            e.printStackTrace();
            return "redirect:/showContractForLandlord";

        }

    }

    //通过合同id查找合同信息
    @RequestMapping(value = "/selectByContractId/{contractId}",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectByContractId(@PathVariable("contractId")Integer contractId, HttpSession session){

        try {

            Contract contract = contractService.selectByContractId(contractId);

            House chouse = houseService.selectById(contract.getHouseId());

            session.setAttribute("contract",contract);
            session.setAttribute("chouse",chouse);

            return "redirect:/showleaseContract";

        } catch (CommonException e) {
            e.printStackTrace();
            return "redirect:contract/selectByLandlordId";
        }
    }

    //房东合同处理
    @ResponseBody
    @RequestMapping(value = "/contractProcess",method = RequestMethod.POST)
    public String contractProcess(String contractId,String view,HttpSession session){
        Integer cId = Integer.parseInt(contractId);
        try{
            contractService.contractProcess(cId,view);
            return "true";
        }catch (CommonException e){
            e.printStackTrace();
            return "false";
        }
    }

    //通过租客id和合同状态查找合同信息
    @RequestMapping(value = "/selectByTenantId",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectByTenantId(HttpSession session){

        Tenant tenant = (Tenant) session.getAttribute("tenant");

        try {
            List<Contract> contracts = contractService.selectByTenantId(tenant.getTenantId(), "TR");
            session.setAttribute("contracts",contracts);
            return "redirect:/showContractForTenant";
        } catch (CommonException e) {
            e.printStackTrace();
            return "redirect:/showContractForTenant";
        }

    }

    //通过合同id查找合同信息
    @RequestMapping(value = "/selectByContractIdForTenant/{contractId}",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectByContractIdForTenant(@PathVariable("contractId")Integer contractId, HttpSession session){

        try {

            Contract contract = contractService.selectByContractId(contractId);

            House chouse = houseService.selectById(contract.getHouseId());

            session.setAttribute("contract",contract);
            session.setAttribute("chouse",chouse);

            return "redirect:/showlContract";

        } catch (CommonException e) {
            e.printStackTrace();
            return "redirect:contract/selectByTenantId";
        }
    }

    //租客合同拒绝处理
    @ResponseBody
    @RequestMapping(value = "/contractTenant",method = RequestMethod.POST)
    public String contractTenant(String contractId,HttpSession session){
        Integer cId = Integer.parseInt(contractId);
        try{
            contractService.contractTenant(cId);
            return "true";
        }catch (CommonException e){
            e.printStackTrace();
            return "false";
        }
    }

    //通过房东租客查询合同信息
    @RequestMapping(value = "/selectForAgency",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectForAgency(String landlordName,String tenantName,HttpSession session){

        Agency agency = (Agency) session.getAttribute("agency");

        try {
            List<Contract> contracts = contractService.selectForAgency(landlordName, tenantName, agency.getAgencyId());
            session.setAttribute("contracts",contracts);
            return "redirect:/showContractForAgency";
        } catch (CommonException e) {
            e.printStackTrace();
            return "redirect:/showContractForAgency";
        }

    }

    //通过租客id查找合同信息
    @RequestMapping(value = "/selectCountForTenant",method = {RequestMethod.GET,RequestMethod.POST})
    public String selectCountForTenant(HttpSession session){

        Tenant tenant = (Tenant) session.getAttribute("tenant");

        try {
            List<Contract> contracts = contractService.selectByTenantId(tenant.getTenantId(), null);
            session.setAttribute("contracts",contracts);
            return "redirect:/showCountForTenant";
        } catch (CommonException e) {
            e.printStackTrace();
            return "redirect:/showCountForTenant";
        }

    }

}
