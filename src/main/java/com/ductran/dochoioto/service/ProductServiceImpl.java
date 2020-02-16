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
	public List<ProductModel> findById(String id) {
		// TODO Auto-generated method stub
		return null;
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
		return setID(dao.autoId());
	}
	

}
