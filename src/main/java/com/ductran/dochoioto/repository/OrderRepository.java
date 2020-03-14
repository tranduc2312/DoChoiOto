package com.ductran.dochoioto.repository;

import java.util.List;

import com.ductran.dochoioto.entity.Orders;

public interface OrderRepository extends IGenericRepository<Orders> {
	List<Object[]> listOrder();
	List<Object[]> listOrderConfirmed();
}
