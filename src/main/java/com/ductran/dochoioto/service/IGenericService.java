package com.ductran.dochoioto.service;

import java.util.List;

public interface IGenericService<T> {
	public List<T> findAll();
	public List<T> findById(String id,int limit);
	public T findOneById(String id);
	public boolean add(T obj);
	public boolean edit(T obj);
	public boolean delete(String id);
	public String autoID();
}
