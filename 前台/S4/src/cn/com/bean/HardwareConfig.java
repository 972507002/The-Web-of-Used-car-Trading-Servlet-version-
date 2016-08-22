package cn.com.bean;

import java.io.Serializable;

public class HardwareConfig implements Serializable{
 private long u_id;
 private long c_id;
 private String consoleLceScreen;
 private String autoLight;
 private String headLights;
 private String lightWash;
 private String efgv;
 private int seatNumber;
 private String fuelForm;
 private String cvt;
 private String drivingMethod;
 private String pke;
 private String keyLessgo;
private String sunRoof;
private String leatherSeat;
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
