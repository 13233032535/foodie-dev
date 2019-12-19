package com.imooc.mapper;

import com.imooc.pojo.OrderStatus;
import com.imooc.pojo.vo.MyOrdersVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrdersMapperCustom {

    /**
     * 查询我的订单
     * @param map
     * @return
     */
    List<MyOrdersVO> queryMyOrders(@Param("paramsMap")Map<String,Object> map);

    int getMyOrderStatusCounts(@Param("paramsMap")Map<String,Object> map);

    List<OrderStatus> getMyOrderTrend(@Param("paramsMap")Map<String,Object> map);
}
