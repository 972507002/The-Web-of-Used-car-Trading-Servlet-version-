package cn.com.bean;

import java.io.Serializable;

public class PerSonCar implements Serializable {
	private long p_id;
	private long u_id;
	  private long c_uid;
	  private long c_id;
	  private String p_state;
	  private String p_bz;
  
	  public String getP_bz() {
		return p_bz;
	}
	public void setP_bz(String p_bz) {
		this.p_bz = p_bz;
	}
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
