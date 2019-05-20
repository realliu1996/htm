package cn.realliu.htm.dao;

import cn.realliu.htm.common.bean.Order;
import org.apache.ibatis.annotations.Param;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/4/16
 * @Time: 23:44
 * @Description：订单与数据库交互接口
 */
public interface OrderDao {

    //新增订单
    void insert(Order order);

    //通过商户订单号查找订单
    Order selectByTradeNo(String tradeNo);

    //通过商户订单号修改订单状态
    void update(@Param("tradeNo")String tradeNo,@Param("status")String status);
}
