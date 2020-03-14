package com.ductran.dochoioto.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ductran.dochoioto.entity.Customers;

@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public List<Customers> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Customers> list = session.createQuery("From Customers").getResultList();
		return list;
	}

	@Override
	public List<Customers> findById(String id, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customers findOneById(String id) {
		Session session = sessionFactory.getCurrentSession();
		List<Customers> list = session.createQuery("From Customers Where ctmId = :id").getResultList();
		if(list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	@Override
	public boolean add(Customers obj) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(obj);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean edit(Customers obj) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(obj);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Update Customers set ctmStatus = 0 Where ctmId = :id");
		query.setParameter("id", id);
		if(query.executeUpdate() > 0) {
			return true;
		}else return false;
	}

	@Override
	public String autoId() {
		Session session = sessionFactory.getCurrentSession();
		List<String> list = session.createQuery("Select ctmId From Customers Order by ctmId desc").getResultList();
		if(list.size() > 0) {
			return list.get(0);
		}else {
			return "C0000000";
		}
	}

}
