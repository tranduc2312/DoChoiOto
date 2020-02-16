package com.ductran.dochoioto.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ductran.dochoioto.entity.Categories;

@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Categories> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Categories> list = session.createQuery("From Categories").getResultList();
		return list;
	}

	@Override
	public List<Categories> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categories findOneById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Categories Where categoryId = :id");
		query.setParameter("id", id);
		List<Categories> list = query.getResultList();
		if(list.size()>0)
			return list.get(0);
		else
			return null;
	}

	@Override
	public boolean add(Categories obj) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(obj);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean edit(Categories obj) {
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
		Query query = session.createQuery("Update Categories set categoryStatus = 0 where categoryId = :id");
		query.setParameter("id", id);
		int result = query.executeUpdate();
		if(result > 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String autoId() {
		Session session = sessionFactory.getCurrentSession();
		List<String> list = session.createQuery("Select categoryId From Categories Order by categoryId desc").getResultList();
		if(list.size()>0)
			return list.get(0);
		else
			return "C0000000";
	}

}
