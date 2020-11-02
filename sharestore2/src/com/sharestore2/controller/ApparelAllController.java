package com.sharestore2.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sharestore2.dao.ProductDAO;
import com.sharestore2.service.ProductService;
import com.sharestore2.vo.ProductVO;

public class ApparelAllController implements Controller{
	public void execute (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ProductService service = ProductService.getInstance();
		ArrayList<ProductVO> productPageAllList1 = service.productPageAllList1();
	
		request.setAttribute("productList", productPageAllList1);

		HttpUtil.forward(request, response, "/apparelAll.jsp");
	}
	
}
