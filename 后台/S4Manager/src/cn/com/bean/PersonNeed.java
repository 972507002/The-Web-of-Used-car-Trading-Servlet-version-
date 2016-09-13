package cn.com.bean;

import java.io.Serializable;
/** 
  * 个人需求信息类 
  *@author lej 
  */ 

public class PersonNeed implements Serializable {
 private long p_id; //需求编号
 private long u_id; //用户编号
 private String p_brand; //需求品牌
 private String p_series; //需求车系
 private String p_age; //需求车龄
 private String p_price;  //需求价格
 private String p_time; //需求购车时间
 private String p_miaoshu; //需求描叙
 private String p_state;  //需求状态
 private String p_tjtime; //需求提交时间
public String getP_tjtime() {
	return p_tjtime;
}
public void setP_tjtime(String p_tjtime) {
	this.p_tjtime = p_tjtime;
}
public String getP_state() {
	return p_state;
}
public void setP_state(String p_state) {
	this.p_state = p_state;
}
public long getP_id() {
	return p_id;
}
public void setP_id(long p_id) {
	this.p_id = p_id;
}
public long getU_id() {
	return u_id;
}
public void setU_id(long u_id) {
	this.u_id = u_id;
}
public String getP_brand() {
	return p_brand;
}
public void setP_brand(String p_brand) {
	this.p_brand = p_brand;
}
public String getP_series() {
	return p_series;
}
public void setP_series(String p_series) {
	this.p_series = p_series;
}
public String getP_age() {
	return p_age;
}
public void setP_age(String p_age) {
	this.p_age = p_age;
}
public String getP_price() {
	return p_price;
}
public void setP_price(String p_price) {
	this.p_price = p_price;
}
public String getP_time() {
	return p_time;
}
public void setP_time(String p_time) {
	this.p_time = p_time;
}
public String getP_miaoshu() {
	return p_miaoshu;
}
public void setP_miaoshu(String p_miaoshu) {
	this.p_miaoshu = p_miaoshu;
}
}
