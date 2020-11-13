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

		String category = multi.getParameter("category");
		String subCategory = multi.getParameter("sub_category");
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
		product.setSubCategory(subCategory);
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
		HttpUtil.forward(request, response, "/result/sellerPrdInsertOut.jsp");
	}
}


	
