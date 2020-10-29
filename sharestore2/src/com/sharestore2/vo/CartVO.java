package com.sharestore2.vo;
import java.util.ArrayList;
public class CartVO {
    public static final int SHOPPING = 0;
    public static final int ORDERD = 1;
    public static final int SHIPPING = 2;
    public static final int DELYVERED = 3;
 
    private String memberId;
    private int status;
    private ArrayList<OrderProductVO> orderProductList;
    private int totalPrice;
    
    public CartVO() {
    }  
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public int getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    public CartVO(int status, String memberId) {
        this.status = status;
        this.memberId = memberId;
    }
    public ArrayList<OrderProductVO> getOrderProductList() {
        return orderProductList;
    }
    public void setOrderProductList(ArrayList<OrderProductVO> orderProductList) {
        this.orderProductList = orderProductList;
    }
  
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
  
}