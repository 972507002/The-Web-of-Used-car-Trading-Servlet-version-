package cn.com.bean;

import java.io.Serializable;
/** 
  * 价格区间信息类 
  * @author lej 
  */ 

public class PriceInterval implements Serializable{
 private int p_id; //价格编号
 private String p_name; //价格名称
 private Long p_count; //热度
public int getP_id() {
	return p_id;
}
public void setP_id(int p_id) {
	this.p_id = p_id;
}
public String getP_name() {
	return p_name;
}
public void setP_name(String p_name) {
	this.p_name = p_name;
}
public Long getP_count() {
	return p_count;
}
public void setP_count(Long p_count) {
	this.p_count = p_count;
}
}
