package cn.com.bean;

import java.io.Serializable;
/** 
5  * 评价信息类 
6  * @author lej 
7  */ 

public class Comment implements Serializable {
  private long uid;  //用户编号
  private String c_text; //评价正文
  private String c_date; //评价日期
  private long cid; //评价编号
  private String c_img; //评价图片
  private String c_bt; //评价标题
  private String c_admin; //评价等级
public String getC_admin() {
	return c_admin;
}
public void setC_admin(String c_admin) {
	this.c_admin = c_admin;
}
public String getC_bt() {
	return c_bt;
}
public void setC_bt(String c_bt) {
	this.c_bt = c_bt;
}
public String getC_img() {
	return c_img;
}
public void setC_img(String c_img) {
	this.c_img = c_img;
}
public long getCid() {
	return cid;
}
public void setCid(long cid) {
	this.cid = cid;
}
public long getUid() {
	return uid;
}
public void setUid(long uid) {
	this.uid = uid;
}
public String getC_text() {
	return c_text;
}
public void setC_text(String c_text) {
	this.c_text = c_text;
}
public String getC_date() {
	return c_date;
}
public void setC_date(String c_date) {
	this.c_date = c_date;
}
}
