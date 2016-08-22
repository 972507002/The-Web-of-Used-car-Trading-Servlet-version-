package cn.com.bean;

import java.io.Serializable;

public class CarImagesInfo implements Serializable {
private long c_id;
private long u_id;
private String image1;
private String image2;
private String image3;
private String image4;
private String image5;
private String image6;
private String image7;
private String image8;
private String image9;
private String image10;
public long getC_id() {
	return c_id;
}
public void setC_id(long c_id) {
	this.c_id = c_id;
}
public long getU_id() {
	return u_id;
}
public void setU_id(long u_id) {
	this.u_id = u_id;
}
public String getImage1() {
	return image1;
}
public void setImage1(String image1) {
	this.image1 = image1;
}
public String getImage2() {
	return image2;
}
public void setImage2(String image2) {
	this.image2 = image2;
}
public String getImage3() {
	return image3;
}
public void setImage3(String image3) {
	this.image3 = image3;
}
public String getImage4() {
	return image4;
}
public void setImage4(String image4) {
	this.image4 = image4;
}
public String getImage5() {
	return image5;
}
public void setImage5(String image5) {
	this.image5 = image5;
}
public String getImage6() {
	return image6;
}
public void setImage6(String image6) {
	this.image6 = image6;
}
public String getImage7() {
	return image7;
}
public void setImage7(String image7) {
	this.image7 = image7;
}
public String getImage8() {
	return image8;
}
public void setImage8(String image8) {
	this.image8 = image8;
}
public String getImage9() {
	return image9;
}
public void setImage9(String image9) {
	this.image9 = image9;
}
public String getImage10() {
	return image10;
}
public void setImage10(String image10) {
	this.image10 = image10;
}
public CarImagesInfo(long c_id, long u_id, String image1, String image2,
		String image3, String image4, String image5, String image6,
		String image7, String image8, String image9, String image10) {
	super();
	this.c_id = c_id;
	this.u_id = u_id;
	this.image1 = image1;
	this.image2 = image2;
	this.image3 = image3;
	this.image4 = image4;
	this.image5 = image5;
	this.image6 = image6;
	this.image7 = image7;
	this.image8 = image8;
	this.image9 = image9;
	this.image10 = image10;
}
public CarImagesInfo() {
	super();
	// TODO Auto-generated constructor stub
}

}
