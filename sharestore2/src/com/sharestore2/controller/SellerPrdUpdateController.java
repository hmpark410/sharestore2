package com.sharestore2.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sharestore2.service.MemberService;
import com.sharestore2.service.ProductService;
import com.sharestore2.vo.ProductVO;
import com.sharestore2.vo.SellerVO;

public class SellerPrdUpdateController implements Controller{
	public void execute (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		String productNumber = request.getParameter("productNumber");
		String category = request.getParameter("category");
		String name = request.getParameter("name");
		String size = request.getParameter("size");
		int price = Integer.parseInt(request.getParameter("price"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		String exp = request.getParameter("exp");
		
		ProductVO product = new ProductVO();
		product.setproductNumber(productNumber);
		product.setCategory(category);
		product.setName(name);
		product.setSize(size);
		product.setPrice(price);
		product.setStock(stock);
		product.setExp(exp);
		
		ProductService service = ProductService.getInstance();	
		service.SellerPrdUpdate(product);
		
		request.setAttribute("productNumber", productNumber);
		HttpUtil.forward(request, response, "/result/sellerPrdUpdateOut.jsp");
	}
}
