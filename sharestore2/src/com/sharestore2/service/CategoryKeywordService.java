package com.sharestore2.service;

import java.util.ArrayList;

import com.sharestore2.dao.CategoryKeywordDAO;
import com.sharestore2.vo.CategoryKeywordVO;

public class CategoryKeywordService {
	
	private static CategoryKeywordService service = new CategoryKeywordService();
	public CategoryKeywordDAO dao = CategoryKeywordDAO.getInstance();
	//생성자 
	private CategoryKeywordService() {}
	
	//Service 외부 사용 
	public static CategoryKeywordService getInstance() {
		return service;
	}
	//검색기능
	public ArrayList<CategoryKeywordVO> ctgkwSelect(String selectTxt) {
		ArrayList<CategoryKeywordVO> ctgkwSelect = dao.ctgkwSelect(selectTxt);
		return ctgkwSelect;
	}

}
