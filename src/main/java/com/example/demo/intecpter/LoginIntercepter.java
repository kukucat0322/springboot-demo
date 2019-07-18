package com.example.demo.intecpter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginIntercepter implements HandlerInterceptor{

	/**
	 * 进controller之前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LoginIntercepter preHandle-------->");
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	/**
	 * 进controller之后，渲染页面之前
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LoginIntercepter postHandle-------->");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * 整个完成，通常用于资源清理回收
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LoginIntercepter afterCompletion-------->");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
