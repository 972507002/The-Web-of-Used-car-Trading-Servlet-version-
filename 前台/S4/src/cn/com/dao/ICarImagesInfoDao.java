package cn.com.dao;

import java.util.Map;

import cn.com.bean.*;

/**
 * 汽车图片信息操作接口
 * @author lej
 */
public interface ICarImagesInfoDao {
  /**
   * 根据编号获取汽车照片的方法
   * @parma carInfo
   * @return Map<Integer,String>
   */
public Map<Integer, String> getCarImagesInfoByID(CarInfo carInfo);
/**
 * 添加照片信息的方法
 * @parma carImagesInfo
 *@reutn int 
 */
public int addCarImagesInfo(CarImagesInfo carImagesInfo);
/**
 *修改照片信息的方法 
 * @parmas
 * @return int
 */
public int updateCarImagesInfo(CarImagesInfo carImagesInfo);

}
