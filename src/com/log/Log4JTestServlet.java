package com.log;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * * <b>Description:</b>日志测试<br>
 * 
 * @author 李帆
 * @version 1.0
 * @Note <b>ProjectName:</b> MyWeb <br>
 * 		<b>PackageName:</b> com.log <br>
 * 		<b>ClassName:</b> Log4JTestServlet <br>
 * 		<b>Date:</b> 2018年12月3日 下午8:50:30
 */

public class Log4JTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(Log4JTestServlet.class);

	public Log4JTestServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {

	}

	/**
	 * <b>Description:</b>输出日志信息<br>
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @Note <b>Author:</b> 李帆 <br>
	 * 		<b>Date:</b> 2018年12月3日 下午8:50:43 <br>
	 * 		<b>Version:</b> 1.0
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 记录debug级别的信息
		logger.debug("这是 debug 消息。");
		// 记录info级别的信息
		logger.info("这是 info 消息。");
		// 记录error级别的信息
		logger.error("这是 error 消息。");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}