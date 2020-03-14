package com.ductran.dochoioto.service;

import java.util.List;

import com.ductran.dochoioto.model.ProductModel;

public interface ProductService extends IGenericService<ProductModel>{
	List<ProductModel> findAllByCode(String code,int startPosition,int maxResult);
	ProductModel findOneByCode(String code);
	List<ProductModel> findAllById(String id, int maxResult);
}
