package com.ductran.dochoioto.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ductran.dochoioto.entity.Products;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Products> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Products> list = session.createQuery("From Products").getResultList();
		return list;
	}

	@Override
	public List<Products> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Products findOneById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Products Where productId = :id ");
		query.setParameter("id", id);
		List<Products> list = query.getResultList();
		if(list.size() > 0)
			return list.get(0);
		return null;
	}

	@Override
	public boolean add(Products obj) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(obj);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean edit(Products obj) {
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
		Query query = session.createQuery("Update Products Set productStatus = 0 Where productId = :id");
		query.setParameter("id", id);
		if(query.executeUpdate() > 0)
			return true;
		else
			return false;
	}

	@Override
	public String autoId() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select productId From Products Order by productId desc ");
		List<String> list = query.getResultList();
		if(list.size() > 0)
			return list.get(0);
		return "P0000000";
	}
	
}
