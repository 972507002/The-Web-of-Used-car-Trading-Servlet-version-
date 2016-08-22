package cn.com.bean;

import java.io.Serializable;

public class CarAge implements Serializable{
 private int a_id;
 private String a_name;
 private long a_count;
public int getA_id() {
	return a_id;
}
public void setA_id(int a_id) {
	this.a_id = a_id;
}
public String getA_name() {
	return a_name;
}
public void setA_name(String a_name) {
	this.a_name = a_name;
}
public long getA_count() {
	return a_count;
}
public void setA_count(long a_count) {
	this.a_count = a_count;
}
}
