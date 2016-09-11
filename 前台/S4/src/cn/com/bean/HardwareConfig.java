package cn.com.bean;

import java.io.Serializable;
/**
 * 车辆硬件配置信息类
 * @author  lej
 */
public class HardwareConfig implements Serializable{
 private long u_id; //车主编号
 private long c_id;  //车辆编号
 private String consoleLceScreen;  //中控台液晶屏
 private String autoLight;  //自动头灯
 private String headLights; //氙气大灯
 private String lightWash;  //大灯清洗
 private String efgv;    //电动折叠后视镜
 private int seatNumber;  //座位数
 private String fuelForm; //燃料形式
 private String cvt;  //变速箱
 private String drivingMethod;  //驱动方式
 private String pke;  //无钥匙进入
 private String keyLessgo; //无钥匙启动
private String sunRoof;  //全景天窗
private String leatherSeat;  //真皮座椅
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
public String getConsoleLceScreen() {
	return consoleLceScreen;
}
public void setConsoleLceScreen(String consoleLceScreen) {
	this.consoleLceScreen = consoleLceScreen;
}
public String getAutoLight() {
	return autoLight;
}
public void setAutoLight(String autoLight) {
	this.autoLight = autoLight;
}
public String getHeadLights() {
	return headLights;
}
public void setHeadLights(String headLights) {
	this.headLights = headLights;
}
public String getLightWash() {
	return lightWash;
}
public void setLightWash(String lightWash) {
	this.lightWash = lightWash;
}
public String getEfgv() {
	return efgv;
}
public void setEfgv(String efgv) {
	this.efgv = efgv;
}
public int getSeatNumber() {
	return seatNumber;
}
public void setSeatNumber(int seatNumber) {
	this.seatNumber = seatNumber;
}
public String getFuelForm() {
	return fuelForm;
}
public void setFuelForm(String fuelForm) {
	this.fuelForm = fuelForm;
}
public String getCvt() {
	return cvt;
}
public void setCvt(String cvt) {
	this.cvt = cvt;
}
public String getDrivingMethod() {
	return drivingMethod;
}
public void setDrivingMethod(String drivingMethod) {
	this.drivingMethod = drivingMethod;
}
public String getPke() {
	return pke;
}
public void setPke(String pke) {
	this.pke = pke;
}
public String getKeyLessgo() {
	return keyLessgo;
}
public void setKeyLessgo(String keyLessgo) {
	this.keyLessgo = keyLessgo;
}
public String getSunRoof() {
	return sunRoof;
}
public void setSunRoof(String sunRoof) {
	this.sunRoof = sunRoof;
}
public String getLeatherSeat() {
	return leatherSeat;
}
public void setLeatherSeat(String leatherSeat) {
	this.leatherSeat = leatherSeat;
}
public HardwareConfig() {
	super();
	// TODO Auto-generated constructor stub
}
 
}
