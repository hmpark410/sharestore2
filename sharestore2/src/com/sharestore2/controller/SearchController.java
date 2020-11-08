package com.sharestore2.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharestore2.service.CategoryKeywordService;
import com.sharestore2.service.ProductService;
import com.sharestore2.vo.CategoryKeywordVO;
import com.sharestore2.vo.OrderProductVO;
import com.sharestore2.vo.ProductVO;

public class SearchController implements Controller{
	public void execute (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String search = request.getParameter("search");
		
		ProductService service = ProductService.getInstance();
		CategoryKeywordService service2 = CategoryKeywordService.getInstance();
		ArrayList<CategoryKeywordVO> ctgkwSelect = service2.ctgkwSelect(search);
		ArrayList<ProductVO> productlist = null;
		
		if(search.isEmpty()) {
			ArrayList<ProductVO> allProduct = service.productList();
			request.setAttribute("allProduct", allProduct);
		} else {
			if(!ctgkwSelect.isEmpty()) {
				for (int i = 0; i < ctgkwSelect.size(); i++) {
					CategoryKeywordVO ctgkw = ctgkwSelect.get(i);
					String category = ctgkw.getCategory();
					ArrayList<ProductVO> productPageList = service.productPageList(category);
					for (int j = 0; j < productPageList.size(); j++) {
						ProductVO product = productPageList.get(i);
						productlist = new ArrayList<ProductVO>();
						ProductVO product2 = new ProductVO();
						product2.setproductNumber(product.getproductNumber());
						product2.setCategory(category);
						product2.setName(product.getName());
						product2.setSize(product.getSize());
						product2.setPrice(product.getPrice());
						product2.setStock(product.getStock());
						product2.setExp(product.getExp());
						product2.setSellerId(product.getSellerId());
						product2.setFilename1(product.getFilename1());
						product2.setFilename2(product.getFilename2());
						product2.setFilename3(product.getFilename3());
						productlist.add(product2);		
					}
					request.setAttribute("allProduct", productlist);
				}
			} else {
				ArrayList<ProductVO> pdtSelect = service.pdtSelect(search);
				request.setAttribute("allProduct", pdtSelect);
			}
		}

		HttpUtil.forward(request, response, "/selectPage.jsp");
	}
	
}
