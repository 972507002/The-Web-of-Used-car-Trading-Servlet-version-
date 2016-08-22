package cn.com.bean;

import java.io.Serializable;

public class Comment implements Serializable {
  private long uid;
  private String c_text;
  private String c_date;
  private long cid;
  private String c_img;
  private String c_bt;
  private String c_admin;
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
