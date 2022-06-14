package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestBookDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.GuestBookVo;


@WebServlet("/gbc")
public class GuestBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		System.out.println(action);
		
		switch(action) {
			case "addList":
				GuestBookDao gbDao = new GuestBookDao();
				
				List<GuestBookVo> gList = gbDao.select();
				request.setAttribute("gList", gList);
				
				WebUtil.forward(request, response, "/WEB-INF/addList.jsp");
				break;
			
			case "add":
				String name = request.getParameter("name");
				String pw = request.getParameter("pw");
				String content = request.getParameter("content");
				
				gbDao = new GuestBookDao();
				gbDao.add(new GuestBookVo(name, pw, content));
				
				WebUtil.redirect(request, response, "/guestbook2/gbc?action=addList");
				break;
				
			case "deleteForm":
				int no = Integer.parseInt(request.getParameter("no"));
				
				request.setAttribute("no", no);
				
				WebUtil.forward(request, response, "/WEB-INF/deleteForm.jsp");
				break;
			
			case "delete":
				no = Integer.parseInt(request.getParameter("no"));
				pw = request.getParameter("pw"); 

				gbDao = new GuestBookDao();
				if (pw.equals(gbDao.findPW(no))) {
					gbDao.delete(no);
				}
				WebUtil.redirect(request, response, "/guestbook2/gbc?action=addList");
				break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
}
