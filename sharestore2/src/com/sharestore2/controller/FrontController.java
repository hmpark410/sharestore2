package com.sharestore2.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FrontController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	String charset = null;
	HashMap<String, Controller> list = null;
	
	@Override
	//서블릿 초기화 
	public void init(ServletConfig sc) throws ServletException{
		charset = sc.getInitParameter("charset");
		list = new HashMap<String, Controller>();
		
		list.put("/test.do", new testController());
		list.put("/search.do", new SearchController());
		//Buyer
		list.put("/memberInsert.do", new MemberInsertController());
		list.put("/memberLogin.do", new MemberLoginController());
		list.put("/forgetId.do", new ForgetIdController());
		list.put("/forgetPasswd.do", new ForgetPasswdController());
		list.put("/memberUpdate.do", new MemberUpdateController());
		list.put("/memberDelete.do", new MemberDeleteController());
		//Seller
		list.put("/sellerInsert.do", new SellerInsertController());
		list.put("/sellerDelete.do", new SellerDeleteController());
		list.put("/sellerPrdlist.do", new SellerPrdlistController());
		list.put("/sellerPrdDelete.do", new SellerPrdDeleteController());
		list.put("/sellerPrdUpdatelist.do", new SellerPrdUpdatelistController());
		list.put("/sellerPrdUpdate.do", new SellerPrdUpdateController());
		//Product
		list.put("/productInsert.do", new ProductInsertController());		
		list.put("/productView.do", new ProductViewController());		
		//Order
		list.put("/orderList.do", new OrderListController());
		list.put("/sellerOrdermgt.do", new SellerOrdermgtController());
		list.put("/sellerOrderUpdate.do", new SellerOrderUpdateController());
		list.put("/memberOrderUpdate.do", new MemberOrderUpdateController());
		list.put("/orderProductInsert.do", new OrderProductInsertController());
		list.put("/orderInsert.do", new OrderInsertController());
		list.put("/cartInsert.do", new CartInsertController());
		list.put("/cartDelete.do", new CartDeleteController());
		list.put("/orderDetail.do", new OrderDetailController());
		//Admin
		list.put("/adminBuyer.do", new AdminBuyerController());
		list.put("/adminBuyerDelete.do", new AdminBuyerDeleteController());
		list.put("/adminSeller.do", new AdminSellerController());
		list.put("/adminSellerDelete.do", new AdminSellerDeleteController());
		list.put("/adminProduct.do", new AdminProductController());
		list.put("/adminPrdUpdatelist.do", new AdminPrdUpdatelistController());
		list.put("/adminPrdUpdate.do", new AdminPrdUpdateController());
		list.put("/adminPrdDelete.do", new AdminPrdDeleteController());
		list.put("/adminSaleList.do", new AdminSaleListController());
		//Page
		list.put("/apparelAll.do", new ApparelAllController());
		list.put("/apparelWomen.do", new ApparelWomenController());
		list.put("/apparelMen.do", new ApparelMenController());
		list.put("/bagAll.do", new BagAllController());
		list.put("/bagWomen.do", new BagWomenController());
		list.put("/bagMen.do", new BagMenController());
		list.put("/shoesAll.do", new ShoesAllController());
		list.put("/shoesWomen.do", new ShoesWomenController());
		list.put("/shoesMen.do", new ShoesMenController());
		list.put("/accAll.do", new AccAllController());
		list.put("/accWomen.do", new AccWomenController());
		list.put("/accMen.do", new AccMenController());
		list.put("/lifeAll.do", new LifeAllController());
	}
		
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		request.setCharacterEncoding(charset);	
		String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = url.substring(contextPath.length());
		Controller subController = list.get(path);
		subController.execute(request, response);
	}
}
