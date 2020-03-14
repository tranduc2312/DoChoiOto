package com.ductran.dochoioto.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ductran.dochoioto.entity.OrderDetails;
import com.ductran.dochoioto.entity.Orders;
//Edit here
@Repository
@Transactional
public class OrderDetailRepositoryImpl implements OrderDetailRepository{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public List<OrderDetails> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<OrderDetails> list = session.createQuery("From OrderDetails").getResultList();
		return list;
	}

	@Override
	public List<OrderDetails> findById(String id, int limit) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From OrderDetails Where order = :order"); 
		Orders order =new Orders();
		order.setOrderId(id);
		query.setParameter("order", order);
		List<OrderDetails> list = query.getResultList();
		return list;
	}

	@Override
	public OrderDetails findOneById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From OrderDetails Where orderId = :id ");
		query.setParameter("id", id);
		List<OrderDetails> list = query.getResultList();
		if(list.size() > 0)
			return list.get(0);
		return null;
	}

	@Override
	public boolean add(OrderDetails obj) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(obj);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean edit(OrderDetails obj) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(obj);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("Update OrderDetails set OrderDStatus = O where orderId = :id");
		query.setParameter("id", id);
		if(query.executeUpdate()>0)
			return true;
		else return false;
		
	}

	@Override
	public String autoId() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select orderId From OrderDetails Order by orderId desc ");
		List<String> list = query.getResultList();
		if(list.size() > 0)
			return list.get(0);
		return "O0000000";
	}
}
