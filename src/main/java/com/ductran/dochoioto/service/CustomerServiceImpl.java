package com.ductran.dochoioto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ductran.dochoioto.entity.Customers;
import com.ductran.dochoioto.model.CustomerModel;
import com.ductran.dochoioto.repository.CustomerRepository;

@Service
public class CustomerServiceImpl extends GenericService implements CustomerService {
	@Autowired
	CustomerRepository dao;
	@Override
	public List<CustomerModel> findAll() {
		List<Customers> listCustomer = dao.findAll();
		List<CustomerModel> listModel = new ArrayList<CustomerModel>();
		for (Customers customers : listCustomer) {
			CustomerModel model = new CustomerModel(customers);
			listModel.add(model);
		}
		return listModel;
	}

	@Override
	public List<CustomerModel> findById(String id, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerModel findOneById(String id) {
		CustomerModel model = new CustomerModel(dao.findOneById(id));
		return model;
	}

	@Override
	public boolean add(CustomerModel obj) {
		Customers customer = new Customers(obj);
		customer.setCtmStatus(true);
		return dao.add(customer);
	}

	@Override
	public boolean edit(CustomerModel obj) {
		Customers customer = new Customers(obj);
		return dao.edit(customer);
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
