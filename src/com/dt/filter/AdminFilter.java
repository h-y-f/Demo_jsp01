package com.dt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class AdminFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		String admin= (String)req.getSession().getAttribute("admin");
        System.out.println("filter��ʼ�����˰�");
		if(admin!=null ){
			System.out.println("��Ҫ����admin"+"?"+admin);
			chain.doFilter(request, response);
		}
		request.setAttribute("msg", "��¼����ܷ���");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
 
	}

	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
