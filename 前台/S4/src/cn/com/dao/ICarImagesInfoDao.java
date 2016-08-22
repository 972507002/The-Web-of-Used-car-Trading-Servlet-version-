package cn.com.dao;

import java.util.Map;

import cn.com.bean.*;


public interface ICarImagesInfoDao {
public Map<Integer, String> getCarImagesInfoByID(CarInfo carInfo);
public int addCarImagesInfo(CarImagesInfo carImagesInfo);
public int updateCarImagesInfo(CarImagesInfo carImagesInfo);

}
