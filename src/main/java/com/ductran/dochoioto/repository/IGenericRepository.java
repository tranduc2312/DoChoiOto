package com.ductran.dochoioto.repository;

import java.util.List;

public interface IGenericRepository<T> {
	public List<T> findAll();
	public List<T> findById(String id);
	public T findOneById(String id);
	public boolean add(T obj);
	public boolean edit(T obj);
	public boolean delete(String id);
	public String autoId();
}
