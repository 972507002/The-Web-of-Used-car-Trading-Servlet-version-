package cn.com.bean;

import java.io.Serializable;

public class CarType implements Serializable {
  private int t_id;
  private String t_name;
  private String t_img;
  private long t_count;
  private String t_class;
public String getT_class() {
	return t_class;
}
public void setT_class(String t_class) {
	this.t_class = t_class;
}
public int getT_id() {
	return t_id;
}
public void setT_id(int t_id) {
	this.t_id = t_id;
}
public String getT_name() {
	return t_name;
}
public void setT_name(String t_name) {
	this.t_name = t_name;
}
public String getT_img() {
	return t_img;
}
public void setT_img(String t_img) {
	this.t_img = t_img;
}
public long getT_count() {
	return t_count;
}
public void setT_count(long t_count) {
	this.t_count = t_count;
}
  
}
