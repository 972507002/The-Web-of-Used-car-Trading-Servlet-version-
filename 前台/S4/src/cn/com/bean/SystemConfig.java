package cn.com.bean;

import java.io.Serializable;
/**
 * 车辆系统配置类
 * @author lej
 */
public class SystemConfig implements Serializable {
 private long u_id;  //车主编号
 private long c_id;  //车辆编号
 private String guidanceSystem;  //导航系统
 private String alb; //防抱死制动系统
 private String fpg; //前驻车雷达
 private String rpg; //后驻车雷达
 private String rcpa; //倒车影像系统
 private String dsea; //驾驶员座椅电动调节
 private String fsea;  //副驾驶座椅电动调节
 private String dlcc; //定速巡航
 private String hfs; //前排座椅加热
 private String hrs; //后排座椅加热
 private String fsv;  //前排座椅通风
 private String rsv;  //后排座椅通风
 private String fsm;  //前排座椅记忆
 private String rsm;  //后排座椅记忆
 private String rvmh; //后视镜加热
 private String ess;  //发动机启停
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
public String getGuidanceSystem() {
	return guidanceSystem;
}
public void setGuidanceSystem(String guidanceSystem) {
	this.guidanceSystem = guidanceSystem;
}
public String getAlb() {
	return alb;
}
public void setAlb(String alb) {
	this.alb = alb;
}
public String getFpg() {
	return fpg;
}
public void setFpg(String fpg) {
	this.fpg = fpg;
}
public String getRpg() {
	return rpg;
}
public void setRpg(String rpg) {
	this.rpg = rpg;
}
public String getRcpa() {
	return rcpa;
}
public void setRcpa(String rcpa) {
	this.rcpa = rcpa;
}
public String getDsea() {
	return dsea;
}
public void setDsea(String dsea) {
	this.dsea = dsea;
}
public String getFsea() {
	return fsea;
}
public void setFsea(String fsea) {
	this.fsea = fsea;
}
public String getDlcc() {
	return dlcc;
}
public void setDlcc(String dlcc) {
	this.dlcc = dlcc;
}
public String getHfs() {
	return hfs;
}
public void setHfs(String hfs) {
	this.hfs = hfs;
}
public String getHrs() {
	return hrs;
}
public void setHrs(String hrs) {
	this.hrs = hrs;
}
public String getFsv() {
	return fsv;
}
public void setFsv(String fsv) {
	this.fsv = fsv;
}
public String getRsv() {
	return rsv;
}
public void setRsv(String rsv) {
	this.rsv = rsv;
}
public String getFsm() {
	return fsm;
}
public void setFsm(String fsm) {
	this.fsm = fsm;
}
public String getRsm() {
	return rsm;
}
public void setRsm(String rsm) {
	this.rsm = rsm;
}
public String getRvmh() {
	return rvmh;
}
public void setRvmh(String rvmh) {
	this.rvmh = rvmh;
}
public String getEss() {
	return ess;
}
public void setEss(String ess) {
	this.ess = ess;
}
public SystemConfig() {
	super();
	// TODO Auto-generated constructor stub
}

}
