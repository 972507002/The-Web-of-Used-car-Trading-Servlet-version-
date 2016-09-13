package cn.com.bean;

import java.io.Serializable;
/**
 * 汽车基本信息类
 * @author le
 *
 */
public class BasicInfo implements Serializable {
 private long u_id;  //车主编号
 private long c_id;  //汽车编号
 private String aidd; //年检到期时间
 private String srdt; //强险到期时间
 private String bodyColor; //车身颜色
 private String interiorColor; //内饰颜色
 private String domf;  //出厂日期
 private String orgin;  //产地
 private String cimd; //商业险到期日期
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
public String getAidd() {
	return aidd;
}
public void setAidd(String aidd) {
	this.aidd = aidd;
}
public String getSrdt() {
	return srdt;
}
public void setSrdt(String srdt) {
	this.srdt = srdt;
}
public String getBodyColor() {
	return bodyColor;
}
public void setBodyColor(String bodyColor) {
	this.bodyColor = bodyColor;
}

public String getInteriorColor() {
	return interiorColor;
}
public void setInteriorColor(String interiorColor) {
	this.interiorColor = interiorColor;
}
public String getDomf() {
	return domf;
}
public void setDomf(String domf) {
	this.domf = domf;
}
public String getOrgin() {
	return orgin;
}
public void setOrgin(String orgin) {
	this.orgin = orgin;
}
public String getCimd() {
	return cimd;
}
public void setCimd(String cimd) {
	this.cimd = cimd;
}
public BasicInfo() {
	super();
	// TODO Auto-generated constructor stub
}
 
}
