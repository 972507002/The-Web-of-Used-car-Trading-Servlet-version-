package cn.com.bean;

import java.io.Serializable;
/**
 * 
 * 用户信息类
 * @author lej
 */
public class UserInfo  implements Serializable{
  private long u_id; //用户编号
  private long u_tel; //用户手机（账号）
  private String u_pwd; //用户密码
  private long u_card; //用户身份证
  private String  u_adr; //用户地址
  private long u_qq; //用户QQ
  private String u_email; //用户邮箱
  private String u_name; //用户姓名
  private String u_sex; //用户性别
  private String u_admin; //用户权限
public String getU_admin() {
	return u_admin;
}
public void setU_admin(String u_admin) {
	this.u_admin = u_admin;
}
public String getU_sex() {
	return u_sex;
}
public void setU_sex(String u_sex) {
	this.u_sex = u_sex;
}
public String getU_name() {
	return u_name;
}
public void setU_name(String u_name) {
	this.u_name = u_name;
}
public long getU_id() {
	return u_id;
}
public void setU_id(long u_id) {
	this.u_id = u_id;
}
public long getU_tel() {
	return u_tel;
}
public void setU_tel(long u_tel) {
	this.u_tel = u_tel;
}
public String getU_pwd() {
	return u_pwd;
}
public void setU_pwd(String u_pwd) {
	this.u_pwd = u_pwd;
}
public long getU_card() {
	return u_card;
}
public void setU_card(long u_card) {
	this.u_card = u_card;
}
public String getU_adr() {
	return u_adr;
}
public void setU_adr(String u_adr) {
	this.u_adr = u_adr;
}
public long getU_qq() {
	return u_qq;
}
public void setU_qq(long u_qq) {
	this.u_qq = u_qq;
}
public String getU_email() {
	return u_email;
}
public void setU_email(String u_email) {
	this.u_email = u_email;
}
  
}
