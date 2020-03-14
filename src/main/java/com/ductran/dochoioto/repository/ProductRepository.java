package com.ductran.dochoioto.repository;

import java.util.List;

import com.ductran.dochoioto.entity.Products;

public interface ProductRepository extends IGenericRepository<Products>{
	List<Products> findAllByCode(String code,int startPosition,int maxResult);
	Products findOneByCode(String code);
	List<Object> findAllById(String id, int maxResult);
}
