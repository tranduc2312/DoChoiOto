package com.ductran.dochoioto.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ductran.dochoioto.entity.Comments;

@Repository
@Transactional
public class CommentRepositoryImpl implements CommentRepository {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public List<Comments> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Comments> list = session.createQuery("From Comments").getResultList();
		return list;
	}

	@Override
	public List<Comments> findById(String id, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comments findOneById(String id) {
		Session session = sessionFactory.getCurrentSession();
		List<Comments> list = session.createQuery("From Comments Where cmtId = :id").getResultList();
		if(list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	@Override
	public boolean add(Comments obj) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(obj);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean edit(Comments obj) {
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
		Query query = session.createQuery("Update Comments set cmtStatus = 0 Where cmtId = :id");
		query.setParameter("id", id);
		if(query.executeUpdate() > 0) {
			return true;
		}else return false;
	}

	@Override
	public String autoId() {
		Session session = sessionFactory.getCurrentSession();
		List<String> list = session.createQuery("Select cmtId From Comments Order by cmtId desc").getResultList();
		if(list.size() > 0) {
			return list.get(0);
		}else {
			return "C0000000";
		}
	}

}
