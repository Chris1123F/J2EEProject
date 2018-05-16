package com.nju.training.dao;

import com.nju.training.model.Order;
import com.nju.training.util.ResultMessage.OrderMessage;

public interface OrderDao {
    public int getOrderLength();

    public OrderMessage addOrder(Order order);

    public OrderMessage cancelOrder(Order order);

    public OrderMessage payOrder(Order order);

    public OrderMessage dispayOrder(Order order);

    public Order getOrder(String orderid);
}
