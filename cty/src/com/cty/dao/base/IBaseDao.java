package com.cty.dao.base;

import java.io.Serializable;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;

public interface IBaseDao<T>{
	public void save(T entity);
	public void delete(T entity);
	public void update(T entity);
	public T findById(Serializable id);
	public List<T> findAll();
	//提供通用修改方法
	public void executeUpdate(String queryName,Object ...objects);
	//public void pageQuery(PageBean pageBean);
}
