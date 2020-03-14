package com.ductran.dochoioto.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ductran.dochoioto.entity.Categories;
import com.ductran.dochoioto.entity.Products;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Products> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Products> list = session.createQuery("From Products Order by productId DESC").getResultList();
		return list;
	}

	@Override
	public List<Products> findById(String id, int limit) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Products Where category.categoryId = :id ");
		//Query query = session.createQuery("From Products p inner join Images i where p.category.categoryId = :id group by p.productId ");
		query.setParameter("id", id);
		if(limit!=-1)
			query.setMaxResults(limit);
		List<Products> list = query.getResultList();
		return list;
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
		System.out.println("List size Product: "+list.size());
		if(list.size() > 0)
			return list.get(0);
		return "P0000000";
	}

	@Override
	public List<Products> findAllByCode(String code,int startPosition,int maxResult) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Products Where category.categoryCode = :id ");
		query.setFirstResult(startPosition);
		if(maxResult!=-1)
			query.setMaxResults(maxResult);
		
		Categories category = new Categories();
		category.setCategoryCode(code);
		category.setCategoryId(code);
		query.setParameter("id", code);
		List<Products> list = query.getResultList();
		return list;
	}

	@Override
	public Products findOneByCode(String code) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Products Where productCode = :id ");
		query.setParameter("id", code);
		List<Products> list = query.getResultList();
		if(list.size() > 0)
			return list.get(0);
		return null;
	}

	@Override
	public List<Object> findAllById(String id, int maxResult) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select p.product_Code,p.product_Name, p.product_Price, i.imageUrl From Products p , Images i Inner join p.productId = i.productId "
		+	" Where p.productId = :id and i.isBanner = 1 ");
		query.setParameter("id", id);
		query.setMaxResults(maxResult);
		List<Object> list = query.getResultList();
		if(list.size() > 0)
			return list;
		return null;
	}
	
}
