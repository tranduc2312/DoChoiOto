package com.ductran.dochoioto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ductran.dochoioto.entity.Comments;
import com.ductran.dochoioto.model.CommentModel;
import com.ductran.dochoioto.repository.CommentRepository;

@Service
public class CommentServiceImpl extends GenericService implements CommentService{
	@Autowired
	CommentRepository dao;
	@Override
	public List<CommentModel> findAll() {
		List<Comments> listComment = dao.findAll();
		List<CommentModel> listModel = new ArrayList<CommentModel>();
		for (Comments comments : listComment) {
			CommentModel model = new CommentModel(comments);
			listModel.add(model);
		}
		return listModel;
	}

	@Override
	public List<CommentModel> findById(String id, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentModel findOneById(String id) {
		CommentModel model = new CommentModel(dao.findOneById(id));
		return model;
	}

	@Override
	public boolean add(CommentModel obj) {
		Comments comment = new Comments(obj);
		comment.setCmtStatus(true);
		return dao.add(comment);
	}

	@Override
	public boolean edit(CommentModel obj) {
		Comments comment = new Comments(obj);
		return dao.edit(comment);
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
