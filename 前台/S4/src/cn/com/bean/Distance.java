package cn.com.bean;

import java.io.Serializable;

public class Distance implements Serializable {
    private int d_id;
    private String d_name;
    private long d_count;
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public long getD_count() {
		return d_count;
	}
	public void setD_count(long d_count) {
		this.d_count = d_count;
	}
}
