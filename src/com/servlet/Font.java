package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Font
 */
/**
 * * <b>Description:</b>首页，在此处进入首页<br>
 * 
 * @author 李帆
 * @version 1.0
 * @Note <b>ProjectName:</b> MyWeb <br>
 *       <b>PackageName:</b> com.servlet <br>
 *       <b>ClassName:</b> Font <br>
 *       <b>Date:</b> 2018年12月3日 下午8:52:20
 */

@WebServlet("/main")
public class Font extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Font() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("test", "<script>$('iframe').contents().find('body').css('background','red')<\\/script>");
		request.getRequestDispatcher("Font.jsp").forward(request, response);
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
