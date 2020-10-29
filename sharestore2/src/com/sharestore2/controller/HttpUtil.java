package com.sharestore2.controller;
import javax.servlet.*;
import javax.servlet.http.*;

//출력 뷰 처리 객체 
public class HttpUtil {
	
	//다른 페이지 이동 
	public static void forward(HttpServletRequest request, HttpServletResponse response, String path) {
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}
		catch(Exception ex) {
			System.out.println("forward error : " + ex);
		}
	}

}
