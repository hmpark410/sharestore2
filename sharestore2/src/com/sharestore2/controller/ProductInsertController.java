package com.sharestore2.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sharestore2.service.ProductService;
import com.sharestore2.vo.ProductVO;
import com.sharestore2.vo.SellerVO;

public class ProductInsertController implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
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
		
		HttpSession session = request.getSession();
		SellerVO seller = (SellerVO) session.getAttribute("seller");
		String id = seller.getSellerId();

		// TODO Auto-generated method stub
		//상품_ID(PK), 상품명, 사이즈, 가격, 수량, 상태, 셀러_ID(FK), 카테고리_ID(FK)
		//파라미터 추출
		//String productId = sellerId + category  
		String category = multi.getParameter("category");
		String name = multi.getParameter("name");
		String size = multi.getParameter("size");
		int price = Integer.parseInt(multi.getParameter("price"));
		int stock = Integer.parseInt(multi.getParameter("stock"));
		String exp = multi.getParameter("exp");
		String sellerId = id;
		String filename1 = multi.getFilesystemName("filename1");
		String filename2 = multi.getFilesystemName("filename2");
		String filename3 = multi.getFilesystemName("filename3");
		
		//유효성 체크
		//VO 객체 데이터 바인딩
		ProductVO product = new ProductVO();
		product.setCategory(category);
		product.setName(name);
		product.setSize(size);
		product.setPrice(price);
		product.setStock(stock);
		product.setExp(exp);
		product.setSellerId(sellerId);
		product.setFilename1(filename1);
		product.setFilename2(filename2);
		product.setFilename3(filename3);
		
		//Service 객체 메소드 호출
		ProductService service = ProductService.getInstance();
		service.productService(product);
		
		request.setAttribute("product", product); 
		HttpUtil.forward(request, response, "/sellerPage.jsp");
	}
}


	
