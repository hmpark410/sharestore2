package com.sharestore2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sharestore2.service.ProductService;
import com.sharestore2.vo.ProductVO;

public class AdminPrdUpdateController implements Controller{
	public void execute (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		

		String sellerId = request.getParameter("sellerId");
		int productNumber = Integer.parseInt(request.getParameter("productNumber"));
		String category = request.getParameter("category");
		String subCategory = request.getParameter("sub_category");
		if(subCategory.equals("아우터")) {subCategory = "1";}
		else if(subCategory.equals("원피스")) {subCategory = "2";}
		else if(subCategory.equals("상의/티")) {subCategory = "3";}
		else if(subCategory.equals("블라우스/셔츠")) {subCategory = "4";}
		else if(subCategory.equals("니트")) {subCategory = "5";}
		else if(subCategory.equals("하의/팬츠")) {subCategory = "6";}
		else if((category.equals("1001") || category.equals("2001")) && subCategory.equals("기타")) {subCategory = "7";}
		else if(subCategory.equals("숄더백")) {subCategory = "8";}
		else if(subCategory.equals("토트백")) {subCategory = "9";}
		else if(subCategory.equals("클러치")) {subCategory = "10";}
		else if(subCategory.equals("백팩")) {subCategory = "11";}
		else if(subCategory.equals("지갑/파우치")) {subCategory = "12";}
		else if((category.equals("1002") || category.equals("2002")) && subCategory.equals("기타")) {subCategory = "13";}
		else if(subCategory.equals("펌프스")) {subCategory = "14";}
		else if(subCategory.equals("플랫/로퍼")) {subCategory = "15";}
		else if(subCategory.equals("슬리퍼/뮬")) {subCategory = "16";}
		else if(subCategory.equals("샌들")) {subCategory = "17";}
		else if(subCategory.equals("부츠")) {subCategory = "18";}
		else if(subCategory.equals("스니커즈")) {subCategory = "19";}
		else if((category.equals("1003") || category.equals("2003")) && subCategory.equals("기타")) {subCategory = "20";}
		else if(subCategory.equals("주얼리")) {subCategory = "21";}
		else if(subCategory.equals("모자")) {subCategory = "22";}
		else if(subCategory.equals("시계")) {subCategory = "23";}
		else if(subCategory.equals("스카프/머플러")) {subCategory = "24";}
		else if(subCategory.equals("안경")) {subCategory = "25";}
		else if(subCategory.equals("선글라스")) {subCategory = "26";}
		else if((category.equals("1004") || category.equals("2004")) && subCategory.equals("기타")) {subCategory = "27";}
		else if(subCategory.equals("가구/수납")) {subCategory = "28";}
		else if(subCategory.equals("홈데코")) {subCategory = "29";}
		else if(subCategory.equals("조명")) {subCategory = "30";}
		else if(subCategory.equals("가전제품")) {subCategory = "31";}
		else if(subCategory.equals("디지털기기")) {subCategory = "32";}
		else if(subCategory.equals("펫용품")) {subCategory = "33";}
		else if(subCategory.equals("문구")) {subCategory = "34";}
		else if(category.equals("3005") && subCategory.equals("기타")) {subCategory = "35";}
		
		String name = request.getParameter("name");
		String size = request.getParameter("size");
		int price = Integer.parseInt(request.getParameter("price"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		String exp = request.getParameter("exp");
		
		System.out.println(sellerId+productNumber+category+subCategory+name+size+price+stock+exp);
		
		ProductVO product = new ProductVO();
		product.setproductNumber(productNumber);
		product.setCategory(category);
		product.setSubCategory(subCategory);
		product.setName(name);
		product.setSize(size);
		product.setPrice(price);
		product.setStock(stock);
		product.setExp(exp);
		
		ProductService service = ProductService.getInstance();	
		service.SellerPrdUpdate(product);
		
		request.setAttribute("productNumber", productNumber);
		HttpUtil.forward(request, response, "/result/adminPrdUpdateOut.jsp");
	}
}
