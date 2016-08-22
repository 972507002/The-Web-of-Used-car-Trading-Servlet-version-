package cn.com.service;

import java.util.Map;


import cn.com.bean.CarImagesInfo;
import cn.com.bean.CarInfo;

public interface ICarImagesInfoService {
	public Map<Integer, String> getCarImagesInfoByID(CarInfo carInfo);
	public boolean addCarImagesInfo(CarImagesInfo carImagesInfo);
	public boolean updateCarImagesInfo(CarImagesInfo carImagesInfo);
	 public boolean deleteimagesinfouser(CarImagesInfo c);
	 public boolean deletecidimagesinfouser(CarImagesInfo c);
	 public boolean checkimageinfouser(CarImagesInfo c);
	 public boolean checkcidimageinfouser(CarImagesInfo c);
	
}
