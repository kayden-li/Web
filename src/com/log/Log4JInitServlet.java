package com.log;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

/**
 * Servlet implementation class Log4JInitServlet
 */
/**
 * * <b>Description:</b>日志初始化<br>
 * 
 * @author 李帆
 * @version 1.0
 * @Note <b>ProjectName:</b> MyWeb <br>
 * 		<b>PackageName:</b> com.log <br>
 * 		<b>ClassName:</b> Log4JInitServlet <br>
 * 		<b>Date:</b> 2018年12月3日 下午8:49:24
 */

@WebServlet("/Log4JInitServlet")
public class Log4JInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Log4JInitServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * <b>Description:</b>日志信息初始化<br>
	 * 
	 * @param config
	 * @throws ServletException
	 * @Note <b>Author:</b> 李帆 <br>
	 * 		<b>Date:</b> 2018年12月3日 下午8:49:57 <br>
	 * 		<b>Version:</b> 1.0
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Log4JInitServlet 正在初始化 log4j日志设置信息");
		String log4jLocation = config.getInitParameter("log4j-properties-location");

		ServletContext sc = config.getServletContext();

		if (log4jLocation == null) {
			System.err.println("*** 没有 log4j-properties-location 初始化的文件, 所以使用 BasicConfigurator初始化");
			BasicConfigurator.configure();
		} else {
			String webAppPath = sc.getRealPath("/");
			String log4jProp = webAppPath + log4jLocation;
			File log4jPropFile = new File(log4jProp);
			if (log4jPropFile.exists()) {
				System.out.println("使用: " + log4jProp + "初始化日志设置信息");
				PropertyConfigurator.configure(log4jProp);
			} else {
				System.err.println("*** " + log4jProp + " 文件没有找到， 所以使用 BasicConfigurator初始化");
				BasicConfigurator.configure();
			}
		}
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
