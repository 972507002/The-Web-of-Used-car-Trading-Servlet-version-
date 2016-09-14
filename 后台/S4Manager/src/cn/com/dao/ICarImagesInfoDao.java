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
/**
 * 根据车主编号删除汽车照片信息的方法
 *@return int  
 */
public int deleteimagesinfouser(CarImagesInfo c);
/**
 * 根据车编号删除汽车照片信息的方法
 *@return int  
 */
public int deletecidimagesinfouser(CarImagesInfo c);
/**
 * 
 * 检查是否还有与某车主编号关联的汽车照片信息
 * @return boolean
 */
public boolean checkimageinfouser(CarImagesInfo c);
/**
 * 
 * 检查是否还有与某车编号关联的汽车照片信息
 * @return boolean
 */
public boolean checkcidimageinfouser(CarImagesInfo c);
}
