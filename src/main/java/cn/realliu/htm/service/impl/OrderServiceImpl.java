package cn.realliu.htm.service.impl;

import cn.realliu.htm.common.bean.Order;
import cn.realliu.htm.common.exception.CommonException;
import cn.realliu.htm.dao.OrderDao;
import cn.realliu.htm.service.interfaces.OrderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/4/17
 * @Time: 15:02
 * @Description：订单逻辑实现
 */
@Service
@Transactional(isolation= Isolation.DEFAULT,propagation= Propagation.REQUIRED,readOnly=true)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    /**
     * 新增订单
     * @param order 订单信息
     * @throws CommonException
     */
    @Override
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
    public void insertUser(Order order) throws CommonException{

        if (StringUtils.isBlank(order.getAmount()) || StringUtils.isBlank(order.getBody()) ||
            StringUtils.isBlank(order.getStatus()) || StringUtils.isBlank(order.getSubject()) ||
            StringUtils.isBlank(order.getTradeNo()) || order.getContractId() == 0 ||
            order.getHouseId() == 0 ){
            throw CommonException.getException(401);
        }

        orderDao.insert(order);

    }

    /**
     * 通过商户订单号查找订单
     * @param tradeNo 商户订单号
     * @return Order 订单实体
     * @throws CommonException
     */
    @Override
    public Order selectByTradeNo(String tradeNo) throws CommonException{

        Order order = orderDao.selectByTradeNo(tradeNo);

        if (order == null){
            throw  CommonException.getException(404);
        }
        return order;
    }

    /**
     * 通过商户订单号修改订单状态
     * @param tradeNo 商户订单号
     * @param status 订单状态
     * @throws CommonException
     */
    @Override
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
    public void update(String tradeNo,String status) throws CommonException{

        if (StringUtils.isBlank(tradeNo) || StringUtils.isBlank(status)){
            throw CommonException.getException(401);

        }
        orderDao.update(tradeNo,status);
    }
}
