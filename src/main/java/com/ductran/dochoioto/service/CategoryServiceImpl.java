package com.ductran.dochoioto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ductran.dochoioto.entity.Categories;
import com.ductran.dochoioto.model.CategoriesModel;
import com.ductran.dochoioto.repository.CategoryRepository;

@Service
public class CategoryServiceImpl extends GenericService implements CategoryService{
	@Autowired
	CategoryRepository dao;
	
	@Override
	public List<CategoriesModel> findAll() {
		List<Categories> listCategory = dao.findAll();
		List<CategoriesModel> listModel = new ArrayList<CategoriesModel>();
		for (Categories categories : listCategory) {
			System.out.println("Service: "+categories.getCategoryName());
			CategoriesModel model = new CategoriesModel(categories);
			listModel.add(model);
		}
		return listModel;
	}

	@Override
	public List<CategoriesModel> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoriesModel findOneById(String id) {
		CategoriesModel model = new CategoriesModel(dao.findOneById(id));
		return model;
	}

	@Override
	public boolean add(CategoriesModel obj) {
		Categories category = new Categories(obj);
		category.setCategoryStatus(true);
		return dao.add(category);
	}

	@Override
	public boolean edit(CategoriesModel obj) {
		Categories category = new Categories(obj);
		return dao.edit(category);
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
