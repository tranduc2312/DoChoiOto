package com.ductran.dochoioto.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ductran.dochoioto.entity.Users;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Users> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Users> list =  session.createQuery("From Users").getResultList();
		
		return list;
	}

	@Override
	public List<Users> findById(String id, int limit) {
		return null;
	}

	@Override
	public Users findOneById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Users Where userId = :id ");
		query.setParameter("id", id);
		List<Users> list = query.getResultList();
		if(list.size()>0)
			return list.get(0);
		else return null;
	}

	@Override
	public boolean add(Users obj) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(obj);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean edit(Users obj) {
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
	
		Query query = session.createQuery("Update Users set userStatus = 0 where userId = :id");
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
		List<String> list = session.createQuery("Select userId From Users Order by userId desc").getResultList();
		if(list.size()>0)
			return list.get(0);
		else
			return "U0000000";
	}

}
