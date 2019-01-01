package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AllSite
 */
/**
 * * <b>Description:</b>适用于全站的过滤器，当直接访问jsp页面时禁用缓存<br>
 * 
 * @author 李帆
 * @version 1.0
 * @Note <b>ProjectName:</b> MyWeb <br>
 * 		<b>PackageName:</b> com.filter <br>
 * 		<b>ClassName:</b> AllSite <br>
 * 		<b>Date:</b> 2018年12月3日 下午8:46:47
 */

public class AllSite implements Filter {

	/**
	 * Default constructor.
	 */
	public AllSite() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	/**
	 * <b>Description:</b>禁用缓存<br>
	 * 
	 * @param request
	 *            请求
	 * @param response
	 *            回应
	 * @param chain
	 *            过滤器
	 * @throws IOException
	 *             io异常
	 * @throws ServletException
	 *             服务器异常
	 * @Note <b>Author:</b> 李帆 <br>
	 * 		<b>Date:</b> 2018年12月3日 下午8:48:04 <br>
	 * 		<b>Version:</b> 1.0
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		res.setHeader("Cache-Control", "no-cache");
		res.setHeader("pragma", "no-cache");
		res.setDateHeader("ecpires", 0);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
