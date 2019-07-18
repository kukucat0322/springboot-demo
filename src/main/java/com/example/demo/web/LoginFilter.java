package com.example.demo.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns="/login")
public class LoginFilter implements Filter{
	
	

	@Override
	public void destroy() {
		System.out.println("destory...");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init...");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletResponse resp = (HttpServletResponse) res;
		System.out.println("doFilter...");
		String username = req.getParameter("name");
		if("zhangsan".equals(username)) {
			chain.doFilter(req, resp);
		}else {
			resp.sendRedirect("/index.html");
		}
	}

}
