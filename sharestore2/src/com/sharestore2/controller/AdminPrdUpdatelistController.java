package com.sharestore2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharestore2.service.ProductService;
import com.sharestore2.vo.ProductVO;

public class AdminPrdUpdatelistController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] varChk = request.getParameterValues("class");
		int[] chk = new int[varChk.length];

		for (int i = 0; i < varChk.length; i++) {
			chk[i] = Integer.parseInt(varChk[i]);
		}

		for (int productNumber : chk) {

			ProductService service = ProductService.getInstance();
			ArrayList<ProductVO> adminPrdUpdatelist = service.adminPrdUpdatelist(productNumber);

			request.setAttribute("adminPrdUpdatelist", adminPrdUpdatelist);

		}
		HttpUtil.forward(request, response, "adminProductUpdate.jsp");

	}
}
