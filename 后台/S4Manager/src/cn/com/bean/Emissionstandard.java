package cn.com.bean;

import java.io.Serializable;

public class Emissionstandard implements Serializable {
  private int e_id;
  private String e_name;
  private long e_count;
public int getE_id() {
	return e_id;
}
public void setE_id(int e_id) {
	this.e_id = e_id;
}
public String getE_name() {
	return e_name;
}
public void setE_name(String e_name) {
	this.e_name = e_name;
}
public long getE_count() {
	return e_count;
}
public void setE_count(long e_count) {
	this.e_count = e_count;
}
  
}
