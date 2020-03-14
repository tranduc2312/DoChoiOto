package com.ductran.dochoioto.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ductran.dochoioto.entity.Images;
@Repository
@Transactional
public class ImageRepositoryImpl implements ImageRepository {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public List<Images> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Images> list = session.createQuery("From Images").getResultList();
		return list;
	}

	@Override
	public List<Images> findById(String id, int limit) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Images Where product.productId = :id ");
		query.setParameter("id", id);
		query.setMaxResults(limit);
		List<Images> list = query.getResultList();
		return list;
	}

	@Override
	public Images findOneById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Images Where imageId = :id ");
		query.setParameter("id", id);
		List<Images> list = query.getResultList();
		if(list.size() > 0)
			return list.get(0);
		return null;
	}

	@Override
	public boolean add(Images obj) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(obj);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean edit(Images obj) {
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
		
		Query query = session.createQuery("Update Images set imageStatus = O where imageId = :id");
		query.setParameter("id", id);
		if(query.executeUpdate()>0)
			return true;
		else return false;
		
	}

	@Override
	public String autoId() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select imageId From Images Order by imageId desc ");
		List<String> list = query.getResultList();
		if(list.size() > 0)
			return list.get(0);
		return "I0000000";
	}

}
