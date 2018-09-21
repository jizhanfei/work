package com.cty.web.action.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 通用Action 实现
 * @author cuity
 *
 * @param <T>
 */
public class BaseAction<T> extends  ActionSupport implements ModelDriven<T>{
	protected T model;
	public T getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	public BaseAction() {
		ParameterizedType  parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] type = parameterizedType.getActualTypeArguments();
		Class<T> entity = (Class<T>) type[0];
		try {
			model = entity.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
 
}
