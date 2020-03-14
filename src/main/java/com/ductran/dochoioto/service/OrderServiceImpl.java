package com.ductran.dochoioto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ductran.dochoioto.entity.Customers;
import com.ductran.dochoioto.entity.Orders;
import com.ductran.dochoioto.model.CustomerModel;
import com.ductran.dochoioto.model.OrderModel;
import com.ductran.dochoioto.repository.OrderRepository;

@Service
public class OrderServiceImpl extends GenericService implements OrderService {
	@Autowired
	OrderRepository dao;
	@Override
	public List<OrderModel> findAll() {
		List<Orders> listOrders = dao.findAll();
		List<OrderModel> listModel = new ArrayList<OrderModel>();
		for (Orders order : listOrders) {
			OrderModel model = new OrderModel(order);
			listModel.add(model);
		}
		return listModel;
	}

	@Override
	public List<OrderModel> findById(String id, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderModel findOneById(String id) {
		OrderModel model = new OrderModel(dao.findOneById(id));
		return model;
	}

	@Override
	public boolean add(OrderModel obj) {
		Orders order = new Orders(obj);
		order.setOrderStatus(true);
		return dao.add(order);
	}

	@Override
	public boolean edit(OrderModel obj) {
		Orders order = new Orders(obj);
		return dao.edit(order);
	}

	@Override
	public boolean delete(String id) {
		return dao.delete(id);
	}

	@Override
	public String autoID() {
		return setID(dao.autoId());
	}

	@Override
	public List<OrderModel> listOrder() {
		List<Object[]> listOrders = dao.listOrder();
		List<OrderModel> listModel = new ArrayList<OrderModel>();
		for (Object[] objects : listOrders) {
			Orders order = (Orders) objects[0];
			Customers ctm = (Customers) objects[1];
			order.setCustomers(ctm);
			OrderModel orderModel = new OrderModel(order);
			listModel.add(orderModel);
		}
		return listModel;
	}

}
