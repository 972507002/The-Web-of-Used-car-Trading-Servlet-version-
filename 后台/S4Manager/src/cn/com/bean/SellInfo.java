package cn.com.bean;

import java.io.Serializable;

public class SellInfo  implements Serializable{
 private long u_id;
 private long c_id;
 private String priceType;
 private String transferFee;
 private String stage;
public long getU_id() {
	return u_id;
}
public void setU_id(long u_id) {
	this.u_id = u_id;
}
public long getC_id() {
	return c_id;
}
public void setC_id(long c_id) {
	this.c_id = c_id;
}
public String getPriceType() {
	return priceType;
}
public void setPriceType(String priceType) {
	this.priceType = priceType;
}
public String getTransferFee() {
	return transferFee;
}
public void setTransferFee(String transferFee) {
	this.transferFee = transferFee;
}
public String getStage() {
	return stage;
}
public void setStage(String stage) {
	this.stage = stage;
}
public SellInfo() {
	super();
	// TODO Auto-generated constructor stub
}

}
