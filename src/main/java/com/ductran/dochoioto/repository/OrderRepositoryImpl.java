package com.ductran.dochoioto.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ductran.dochoioto.entity.Orders;

@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepository {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public List<Orders> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Orders> list = session.createQuery("From Orders").getResultList();
		return list;
	}

	@Override
	public List<Orders> findById(String id, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders findOneById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Orders Where orderId = :id ");
		query.setParameter("id", id);
		List<Orders> list = query.getResultList();
		if(list.size() > 0)
			return list.get(0);
		return null;
	}

	@Override
	public boolean add(Orders obj) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(obj);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean edit(Orders obj) {
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
		
		Query query = session.createQuery("Update Orders set orderStatus = O where orderId = :id");
		query.setParameter("id", id);
		if(query.executeUpdate()>0)
			return true;
		else return false;
		
	}

	@Override
	public String autoId() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select orderId From Orders Order by orderId desc ");
		List<String> list = query.getResultList();
		if(list.size() > 0)
			return list.get(0);
		return "O0000000";
	}

	@Override
	public List<Object[]> listOrder() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Orders o,Customers Group by o.orderId");
		List<Object[]> list = query.getResultList();
		return list;
	}
	@Override
	public List<Object[]> listOrderConfirmed() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Orders o,Customers Where o.orderConfirm = 1 Group by o.orderId ");
		List<Object[]> list = query.getResultList();
		return list;
	}
}
