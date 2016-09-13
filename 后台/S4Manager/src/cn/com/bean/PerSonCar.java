package cn.com.bean;

import java.io.Serializable;
/** 
  * 个人汽车订单类 
  * @author lej 
  */ 

public class PerSonCar implements Serializable {
	private long p_id; //个人汽车订单编号
	private long u_id;  //用户编号
	  private long c_uid;  //车主编号
	  private long c_id;  //车辆编号
	  private String p_state;  //订单状态
	  
	public long getP_id() {
		return p_id;
	}
	public void setP_id(long p_id) {
		this.p_id = p_id;
	}

public long getU_id() {
	return u_id;
}
public void setU_id(long u_id) {
	this.u_id = u_id;
}
public long getC_uid() {
	return c_uid;
}
public void setC_uid(long c_uid) {
	this.c_uid = c_uid;
}
public long getC_id() {
	return c_id;
}
public void setC_id(long c_id) {
	this.c_id = c_id;
}
public String getP_state() {
	return p_state;
}
public void setP_state(String p_state) {
	this.p_state = p_state;
}
}
