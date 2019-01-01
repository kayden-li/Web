package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Operation;
import com.google.gson.Gson;
import com.model.Food;

/**
 * Servlet implementation class Getinfo
 */
/**
 * * <b>Description:</b>按地区获取菜谱信息<br>
 * 
 * @author 李帆
 * @version 1.0
 * @Note <b>ProjectName:</b> MyWeb <br>
 * 		<b>PackageName:</b> com.servlet <br>
 * 		<b>ClassName:</b> Getinfo <br>
 * 		<b>Date:</b> 2018年12月3日 下午8:52:50
 */

@WebServlet("/get")
public class Getinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Operation Controller = new Operation();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Getinfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String area = new String(request.getParameter("area").getBytes("iso8859-1"), "utf-8");
		List<Food> foods = Controller.find(area);

		Gson gson = new Gson();
		String json = gson.toJson(foods);

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.append(json);
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
