package com.cty.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 自定义Struts拦截器 实现用户未登录跳转到登录页面
 * @author cuity
 *
 */
public class LoginInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		System.out.println("拦截登录");
//		includeMethods
		
		return invocation.invoke();//fagn
	}

}
