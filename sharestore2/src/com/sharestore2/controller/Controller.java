package com.sharestore2.controller;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

//controller 기능 구현 메소드 통일 
public interface Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
	
}
