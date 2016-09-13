package cn.com.bean;
/** 
  * 公司动态信息类 
  * @author lej 
  */ 

public class Trends {
   private long tr_id; //动态信息编号
   private String tr_title; //动态信息标题
   private String tr_text; //动态信息正文
   private String tr_date; //动态信息日期
   private String tr_img; //动态信息配图
   private String tr_type;  //动态信息类型
public String getTr_type() {
	return tr_type;
}
public void setTr_type(String tr_type) {
	this.tr_type = tr_type;
}
public long getTr_id() {
	return tr_id;
}
public void setTr_id(long tr_id) {
	this.tr_id = tr_id;
}
public String getTr_title() {
	return tr_title;
}
public void setTr_title(String tr_title) {
	this.tr_title = tr_title;
}
public String getTr_text() {
	return tr_text;
}
public void setTr_text(String tr_text) {
	this.tr_text = tr_text;
}
public String getTr_date() {
	return tr_date;
}
public void setTr_date(String tr_date) {
	this.tr_date = tr_date;
}
public String getTr_img() {
	return tr_img;
}
public void setTr_img(String tr_img) {
	this.tr_img = tr_img;
}
}
