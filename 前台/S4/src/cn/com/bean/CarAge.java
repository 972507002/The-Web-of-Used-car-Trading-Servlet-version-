package cn.com.bean;

import java.io.Serializable;
/**
 * 车龄信息类
 * @author lej
 */
public class CarAge implements Serializable{
 private int a_id;   //车龄编号
 private String a_name;  //车龄名称
 private long a_count;  //热度
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
