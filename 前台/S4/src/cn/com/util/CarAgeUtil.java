package cn.com.util;

public class CarAgeUtil {
   private int minAge=0;
   private int maxAge=0;
public int getMinAge() {
	return minAge;
}
public void setMinAge(int minAge) {
	this.minAge = minAge;
}
public int getMaxAge() {
	return maxAge;
}
public void setMaxAge(int maxAge) {
	this.maxAge = maxAge;
}
public CarAgeUtil(String age){发
	if(age.contains("ÒÔÄÚ")){
		String [] s=age.split("Äê");
		this.maxAge=Integer.parseInt(s[0]);
		}
		if(age.contains("ÒÔÉÏ")){
			String [] s=age.split("Äê");
			this.minAge=Integer.parseInt(s[0]);
		}
		if(age.contains("-")){
			String [] s=age.split("Äê");
			String [] s1 =   s[0].split("-");
			this.maxAge=Integer.parseInt(s1[1]);
			this.minAge=Integer.parseInt(s1[0]);
		}
}
}
