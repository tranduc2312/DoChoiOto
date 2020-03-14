package com.ductran.dochoioto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ductran.dochoioto.entity.OrderDetails;
import com.ductran.dochoioto.model.OrderDetailModel;
import com.ductran.dochoioto.repository.OrderDetailRepository;

@Service
public class OrderDetailServiceImpl extends GenericService implements OrderDetailService {
	@Autowired
	OrderDetailRepository dao;
	@Override
	public List<OrderDetailModel> findAll() {
		List<OrderDetails> list = dao.findAll();
		List<OrderDetailModel> listModel = new ArrayList<OrderDetailModel>();
		for (OrderDetails orderDetails : list) {
			OrderDetailModel model = new OrderDetailModel(orderDetails);
			listModel.add(model);
		}
		return listModel;
	}

	@Override
	public List<OrderDetailModel> findById(String id, int limit) {
		List<OrderDetails> list = dao.findAll();
		List<OrderDetailModel> listModel = new ArrayList<OrderDetailModel>();
		for (OrderDetails orderDetails : list) {
			OrderDetailModel model = new OrderDetailModel(orderDetails);
			listModel.add(model);
		}
		return listModel;
	}

	@Override
	public OrderDetailModel findOneById(String id) {
		OrderDetailModel model = new OrderDetailModel(dao.findOneById(id));
		return model;
	}

	@Override
	public boolean add(OrderDetailModel obj) {
		OrderDetails order = new OrderDetails(obj);
		order.setOrderDStatus(true);
		return dao.add(order);
	}

	@Override
	public boolean edit(OrderDetailModel obj) {
		OrderDetails order = new OrderDetails(obj);
		return dao.add(order);
	}

	@Override
	public boolean delete(String id) {
		return dao.delete(id);
	}

	@Override
	public String autoID() {
		return setID(dao.autoId());
	}

}
