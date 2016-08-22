package cn.com.bean;

import java.io.Serializable;

public class ProcedureInfo  implements Serializable{
 private long u_id;
 private long c_id;
 private String purchaseTax;
 private String drivingLicense;
 private String ncw;
 private String registration;
 private String newInvoice;
 private int key;
 private int transferTimes;
 private String transferTicket;
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
