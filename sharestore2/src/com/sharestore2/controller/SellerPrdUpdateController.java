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
		
		request.setCharacterEncoding("UTF-8");
		MultipartRequest multi = null;
		
		int sizeLimit = 10 * 1024 * 1024;
		
		String savePath = request.getSession().getServletContext().getRealPath("/data");
		
		try{
            multi=new MultipartRequest(
                    request
                    , savePath
                    , sizeLimit
                    , "UTF-8"
                    , new DefaultFileRenamePolicy()); 
 
         }catch (Exception e) {
                e.printStackTrace();
         }
		
		String productNumber = multi.getParameter("productNumber");
		String category = multi.getParameter("category");
		String name = multi.getParameter("name");
		String size = multi.getParameter("size");
		int price = Integer.parseInt(multi.getParameter("price"));
		int stock = Integer.parseInt(multi.getParameter("stock"));
		String exp = multi.getParameter("exp");
		String filename1 = multi.getFilesystemName("filename1");
		String filename2 = multi.getFilesystemName("filename2");
		String filename3 = multi.getFilesystemName("filename3");
		
		ProductVO product = new ProductVO();
		product.setproductNumber(productNumber);
		product.setCategory(category);
		product.setName(name);
		product.setSize(size);
		product.setPrice(price);
		product.setStock(stock);
		product.setExp(exp);
		product.setFilename1(filename1);
		product.setFilename2(filename2);
		product.setFilename3(filename3);
		
		ProductService service = ProductService.getInstance();	
		service.SellerPrdUpdate(product);
		
		request.setAttribute("productNumber", productNumber);
		HttpUtil.forward(request, response, "/result/sellerPrdUpdateOut.jsp");
	}
}
