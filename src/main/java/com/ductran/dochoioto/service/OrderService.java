package com.ductran.dochoioto.service;

import java.util.List;

import com.ductran.dochoioto.model.OrderModel;

public interface OrderService extends IGenericService<OrderModel>{
	List<OrderModel> listOrder();
}
