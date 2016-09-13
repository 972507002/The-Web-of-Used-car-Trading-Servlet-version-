package cn.com.bean;

import java.io.Serializable;
/** 
  * 手续信息类 
  * @author  lej 
  */ 

public class ProcedureInfo  implements Serializable{
 private long u_id; //车主编号
 private long c_id; //车辆编号 
 private String purchaseTax; //购置税
 private String drivingLicense;  //行驶证
 private String ncw;  //新车质保
 private String registration; //登记证
 private String newInvoice; //新车发票
 private int key;  //钥匙
 private int transferTimes; //过户次数
 private String transferTicket; //过户票
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
public String getPurchaseTax() {
	return purchaseTax;
}
public void setPurchaseTax(String purchaseTax) {
	this.purchaseTax = purchaseTax;
}
public String getDrivingLicense() {
	return drivingLicense;
}
public void setDrivingLicense(String drivingLicense) {
	this.drivingLicense = drivingLicense;
}
public String getNcw() {
	return ncw;
}
public void setNcw(String ncw) {
	this.ncw = ncw;
}
public String getRegistration() {
	return registration;
}
public void setRegistration(String registration) {
	this.registration = registration;
}
public String getNewInvoice() {
	return newInvoice;
}
public void setNewInvoice(String newInvoice) {
	this.newInvoice = newInvoice;
}
public int getKey() {
	return key;
}
public void setKey(int key) {
	this.key = key;
}
public int getTransferTimes() {
	return transferTimes;
}
public void setTransferTimes(int transferTimes) {
	this.transferTimes = transferTimes;
}
public String getTransferTicket() {
	return transferTicket;
}
public void setTransferTicket(String transferTicket) {
	this.transferTicket = transferTicket;
}
public ProcedureInfo() {
	super();
	// TODO Auto-generated constructor stub
}

}
