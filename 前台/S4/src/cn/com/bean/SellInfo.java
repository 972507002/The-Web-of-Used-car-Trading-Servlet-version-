package cn.com.bean;

import java.io.Serializable;
/**
 * 销售信息类
 * @author lej
 */
public class SellInfo  implements Serializable{
 private long u_id;  //车主编号
 private long c_id;  //车辆编号
 private String priceType;  //价格类型
 private String transferFee;  //含过户费
 private String stage;  //支持分期
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
