package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Operation;

/**
 * Servlet implementation class clean
 */
/**
 * * <b>Description:</b>删除菜谱<br>
 * 
 * @author 李帆
 * @version 1.0
 * @Note <b>ProjectName:</b> MyWeb <br>
 * 		<b>PackageName:</b> com.servlet <br>
 * 		<b>ClassName:</b> Clean <br>
 * 		<b>Date:</b> 2018年12月3日 下午8:51:33
 */

@WebServlet("/clean")
public class Clean extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Operation Controller = new Operation();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Clean() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String string = new String(request.getParameter("str").getBytes("iso8859-1"), "utf-8");

		String[] names = string.split("/");

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		try {
			for (int i = 0; i < names.length; ++i)
				Controller.delete_Food(names[i]);
		} catch (Exception e) {
			response.getWriter().append("N");
		}
		response.getWriter().append("Y");
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
