package cn.com.dao;

import java.util.Map;

import cn.com.bean.*;


public interface ICarImagesInfoDao {
public Map<Integer, String> getCarImagesInfoByID(CarInfo carInfo);
public int addCarImagesInfo(CarImagesInfo carImagesInfo);
public int updateCarImagesInfo(CarImagesInfo carImagesInfo);
public int deleteimagesinfouser(CarImagesInfo c);
public int deletecidimagesinfouser(CarImagesInfo c);
public boolean checkimageinfouser(CarImagesInfo c);
public boolean checkcidimageinfouser(CarImagesInfo c);
}
