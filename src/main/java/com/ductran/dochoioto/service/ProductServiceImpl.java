package com.ductran.dochoioto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ductran.dochoioto.entity.Products;
import com.ductran.dochoioto.model.ProductModel;
import com.ductran.dochoioto.repository.ProductRepository;

@Service
public class ProductServiceImpl extends GenericService implements ProductService {
	@Autowired
	ProductRepository dao;
	@Override
	public List<ProductModel> findAll() {
		List<Products> listProduct = dao.findAll();
		List<ProductModel> listModel = new ArrayList<ProductModel>();
		for (Products products : listProduct) {
			ProductModel model = new ProductModel(products);
			listModel.add(model);
		}
		return listModel;
	}

	@Override
	public List<ProductModel> findById(String id, int limit) {
		List<Products> listProduct = dao.findById(id,limit);
		List<ProductModel> listModel = new ArrayList<ProductModel>();
		for (Products products : listProduct) {
			ProductModel model = new ProductModel(products);
			listModel.add(model);
		}
		return listModel;
	}

	@Override
	public ProductModel findOneById(String id) {
		ProductModel model = new ProductModel(dao.findOneById(id));
		return model;
	}

	@Override
	public boolean add(ProductModel obj) {
		Products product = new Products(obj);
		product.setProductStatus(true);
		return dao.add(product);
	}

	@Override
	public boolean edit(ProductModel obj) {
		Products product = new Products(obj);
		return dao.edit(product);
	}

	@Override
	public boolean delete(String id) {
		return dao.delete(id);
	}

	@Override
	public String autoID() {
		System.out.println(setID(dao.autoId()));
		return setID(dao.autoId());
	}

	@Override
	public List<ProductModel> findAllByCode(String code,int startPosition,int maxResult) {
		List<Products> listProduct = dao.findAllByCode(code,startPosition,maxResult);
		List<ProductModel> listModel = new ArrayList<ProductModel>();
		for (Products products : listProduct) {
			ProductModel model = new ProductModel(products);
			listModel.add(model);
		}
		return listModel;
	}

	@Override
	public ProductModel findOneByCode(String code) {
		ProductModel model = new ProductModel(dao.findOneByCode(code));
		return model;
	}

	@Override
	public List<ProductModel> findAllById(String id, int maxResult) {
		List<Object> listProduct = dao.findAllById(id, maxResult);
		List<ProductModel> listModel = new ArrayList<ProductModel>();
		for (Object obj : listProduct) {
			
			ProductModel model = new ProductModel();
			listModel.add(model);
		}
		return listModel;
	}
	

}
