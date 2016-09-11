package cn.com.bean;

import java.io.Serializable;
/**
 * 车系信息类
 * @author lej
 */
public class Model  implements Serializable{
 private int m_id; //车系ID
 private int b_id;  //品牌ID
 private String m_name; //车型名称
public int getM_id() {
	return m_id;
}
public void setM_id(int m_id) {
	this.m_id = m_id;
}
public int getB_id() {
	return b_id;
}
public void setB_id(int b_id) {
	this.b_id = b_id;
}
public String getM_name() {
	return m_name;
}
public void setM_name(String m_name) {
	this.m_name = m_name;
}
}
