package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Operation;
import com.google.gson.Gson;
import com.model.User;

/**
 * Servlet implementation class regiest
 */
/**
 * * <b>Description:</b>注册方法<br>
 * 
 * @author 李帆
 * @version 1.0
 * @Note <b>ProjectName:</b> MyWeb <br>
 * 		<b>PackageName:</b> com.servlet <br>
 * 		<b>ClassName:</b> Regiest <br>
 * 		<b>Date:</b> 2018年12月3日 下午8:54:39
 */

@WebServlet("/regiest")
public class Regiest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Operation Controller = new Operation();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Regiest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter writer = response.getWriter();
		if (!Controller.check(id)) {
			writer.append('N');
		} else {
			String name = new String(request.getParameter("name").getBytes("iso8859-1"), "utf-8");
			String area = new String(request.getParameter("area").getBytes("iso8859-1"), "utf-8");
			String password = new String(request.getParameter("password").getBytes("iso8859-1"), "utf-8");
			String num = request.getParameter("num");
			String sex = request.getParameter("sex");

			User user = new User(name, area, password, num, sex, id);
			if (name == null || area == null || password == null)
				writer.append('N');
			else if (Controller.regiest(user) == 1) {
				Gson gson = new Gson();
				String json = gson.toJson(user);
				writer.append(json);
			}
		}

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
