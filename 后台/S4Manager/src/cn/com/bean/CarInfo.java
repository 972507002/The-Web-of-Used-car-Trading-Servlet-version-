package cn.com.bean;

import java.io.Serializable;
/**
 * 车辆概要信息类
 * @author lej
 */

public class CarInfo implements Serializable {
 private long u_id; //车主编号
 private long c_id; //车辆编号
 private String c_brand; //品牌
 private String c_series; //车系
 private int c_releaseyear;  //款式年限
 private double c_volume; //排量
 private String c_gearType;  //挂档类型
 private String c_code;  //编号
 private String c_model; //型号
 private String c_licencetime; //上牌时间
 private double c_distance; //行驶距离
 private String c_emissionstandard; //排放标准
 private double c_price; //价格
 private long c_count;  //热度
 private String c_img; //头图片
 private String c_type; //车体形式
 private String c_state; //状态
 private long c_sccount; //收藏量
 private String c_czzx; //详情描叙
 private String c_sjtime; //上架时间
 private double newprice; //新车价
 private String c_mcsj; //卖出时间
public String getC_mcsj() {
	return c_mcsj;
}
public void setC_mcsj(String c_mcsj) {
	this.c_mcsj = c_mcsj;
}
public double getNewprice() {
	return newprice;
}
public void setNewprice(double newprice) {
	this.newprice = newprice;
}
public String getC_sjtime() {
	return c_sjtime;
}
public void setC_sjtime(String c_sjtime) {
	this.c_sjtime = c_sjtime;
}
public String getC_czzx() {
	return c_czzx;
}
public void setC_czzx(String c_czzx) {
	this.c_czzx = c_czzx;
}
public long getC_sccount() {
	return c_sccount;
}
public void setC_sccount(long c_sccount) {
	this.c_sccount = c_sccount;
}
public String getC_state() {
	return c_state;
}
public void setC_state(String c_state) {
	this.c_state = c_state;
}
public String getC_type() {
	return c_type;
}
public void setC_type(String c_type) {
	this.c_type = c_type;
}
public String getC_img() {
	return c_img;
}
public void setC_img(String c_img) {
	this.c_img = c_img;
}
public long getU_id() {
	return u_id;
}
public void setU_id(long u_id) {
	this.u_id = u_id;
}
public long getC_id() {
	return c_id;
}
public void setC_id(long c_id) {
	this.c_id = c_id;
}
public String getC_brand() {
	return c_brand;
}
public void setC_brand(String c_brand) {
	this.c_brand = c_brand;
}
public String getC_series() {
	return c_series;
}
public void setC_series(String c_series) {
	this.c_series = c_series;
}
public int getC_releaseyear() {
	return c_releaseyear;
}
public void setC_releaseyear(int c_releaseyear) {
	this.c_releaseyear = c_releaseyear;
}
public double getC_volume() {
	return c_volume;
}
public void setC_volume(double c_volume) {
	this.c_volume = c_volume;
}
public String getC_gearType() {
	return c_gearType;
}
public void setC_gearType(String c_gearType) {
	this.c_gearType = c_gearType;
}
public String getC_code() {
	return c_code;
}
public void setC_code(String c_code) {
	this.c_code = c_code;
}
public String getC_model() {
	return c_model;
}
public void setC_model(String c_model) {
	this.c_model = c_model;
}
public String getC_licencetime() {
	return c_licencetime;
}
public void setC_licencetime(String c_licencetime) {
	this.c_licencetime = c_licencetime;
}
public double getC_distance() {
	return c_distance;
}
public void setC_distance(double c_distance) {
	this.c_distance = c_distance;
}
public String getC_emissionstandard() {
	return c_emissionstandard;
}
public void setC_emissionstandard(String c_emissionstandard) {
	this.c_emissionstandard = c_emissionstandard;
}
public double getC_price() {
	return c_price;
}
public void setC_price(double c_price) {
	this.c_price = c_price;
}
public long getC_count() {
	return c_count;
}
public void setC_count(long c_count) {
	this.c_count = c_count;
}
public CarInfo() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(obj instanceof CarInfo){
		CarInfo c=(CarInfo) obj;
		if(this.getC_id()==c.getC_id()){
		  flag=true;
		}
	}
	return flag;
}
 
}
