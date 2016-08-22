package cn.com.bean;

import java.io.Serializable;

public class CarBrand implements Serializable {
 private int b_id;
 private String b_name;
 private long b_count;
 private String b_img;
 private String b_szm;
public String getB_szm() {
	return b_szm;
}
public void setB_szm(String b_szm) {
	this.b_szm = b_szm;
}
public String getB_img() {
	return b_img;
}
public void setB_img(String b_img) {
	this.b_img = b_img;
}
public long getB_count() {
	return b_count;
}
public void setB_count(long b_count) {
	this.b_count = b_count;
}
public int getB_id() {
	return b_id;
}
public void setB_id(int b_id) {
	this.b_id = b_id;
}
public String getB_name() {
	return b_name;
}
public void setB_name(String b_name) {
	this.b_name = b_name;
}
}
