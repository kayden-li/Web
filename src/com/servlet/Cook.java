package com.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dao.Operation;
import com.model.Food;

/**
 * Servlet implementation class cook
 */
/**
 * * <b>Description:</b>添加菜谱<br>
 * 
 * @author 李帆
 * @version 1.0
 * @Note <b>ProjectName:</b> MyWeb <br>
 * 		<b>PackageName:</b> com.servlet <br>
 * 		<b>ClassName:</b> Cook <br>
 * 		<b>Date:</b> 2018年12月3日 下午8:52:00
 */

@WebServlet("/cook")
public class Cook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Operation Controller = new Operation();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cook() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 设置编码

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter writer = response.getWriter();

		String fName = "";
		String suffix = "";
		Food food = new Food();
		/*
		 * food.setArea((String) request.getAttribute("area")); food.setIntro((String)
		 * request.getAttribute("intro")); food.setName((String)
		 * request.getAttribute("name")); food.setPublisher((String)
		 * request.getAttribute("publisher"));
		 */
		// 获得磁盘文件条目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 获取文件需要上传到的路径
		// String path = request.getRealPath("/upload1");//该方法已经被淘汰
		// request.getRealPath("")是本项目的路径
		String path = request.getRealPath("") + "\\RES";
		// String path = "c:/upload1";
		// 如果没以下两行设置的话，上传大的 文件 会占用 很多内存，
		// 设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同
		/**
		 * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem 格式的
		 * 然后再将其真正写到 对应目录的硬盘上
		 */
		factory.setRepository(new File(path));
		// 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
		factory.setSizeThreshold(1024 * 1024);
		// 高水平的API文件上传处理
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			// 可以上传多个文件
			List<FileItem> list = (List<FileItem>) upload.parseRequest((HttpServletRequest) request);
			for (FileItem item : list) {
				// 获取表单的属性名字
				String name = item.getFieldName();
				// 如果获取的 表单信息是普通的 文本 信息
				if (item.isFormField()) {
					String field = item.getFieldName();
					String value = new String(item.getString().getBytes("iso8859-1"), "utf-8");
					if (field.equals("name"))
						food.setName(value);
					else if (field.equals("intro"))
						food.setIntro(value);
					else if (field.equals("area"))
						food.setArea(value);
					else if (field.equals("publisher"))
						food.setPublisher(value);
				} else {// 对传入的非 简单的字符串进行处理 ，比如说二进制的 图片，电影这些
					/**
					 * 以下三步，主要获取 上传文件的名字
					 */
					// 获取路径名
					String value = item.getName();
					// 索引到最后一个反斜杠
					int start = value.lastIndexOf("\\");
					// 截取 上传文件的 字符串名字，加1是 去掉反斜杠，
					String filename = value.substring(start + 1);
					// 真正写到磁盘上
					// 它抛出的异常 用exception 捕捉
					// item.write( new File(path,filename) );//第三方提供的
					// 手动写入的
					// 如果有文件名
					if (filename.indexOf(".") >= 0) {
						// 就截取.之前的字符串
						int indexdot = filename.indexOf(".");
						suffix = filename.substring(indexdot);
						fName = filename.substring(0, filename.lastIndexOf("."));
						Date now = new Date();
						fName = fName + "_" + now.getTime();
						fName = fName + suffix;
					}
					OutputStream out = new FileOutputStream(new File(path, fName));
					food.setImg(fName);
					InputStream in = item.getInputStream();
					int length = 0;
					byte[] buf = new byte[1024];
					System.out.println("获取上传文件的总共的容量：" + item.getSize());
					// in.read(buf) 每次读到的数据存放在 buf 数组中
					while ((length = in.read(buf)) != -1) {
						// 在 buf 数组中 取出数据 写到 （输出流）磁盘上
						out.write(buf, 0, length);
					}
					in.close();
					out.close();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int flag = Controller.insert_Food(food);
		if (flag == 1)
			writer.append("制作成功！");
		else
			writer.append("制作失败了！！！");
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
