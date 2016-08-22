package cn.com.bean;

import java.io.Serializable;

public class PriceInterval implements Serializable{
 private int p_id;
 private String p_name;
 private Long p_count;
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
