package cn.com.service;

import java.util.Map;


import cn.com.bean.CarImagesInfo;
import cn.com.bean.CarInfo;
/**
 * 汽车图片信息服务接口
 * @author lej
 */
public interface ICarImagesInfoService {
  /**
   * 根据编号获取汽车照片的服务
   * @parma carInfo
   * @return Map<Integer,String>
   */
	public Map<Integer, String> getCarImagesInfoByID(CarInfo carInfo);
/**
 * 添加照片信息的服务
 * @parma carImagesInfo
 *@reutn boolean 
 */
	public boolean addCarImagesInfo(CarImagesInfo carImagesInfo);
/**
 *修改照片信息的服务
 * @parmas
 * @return boolean
 */
	public boolean updateCarImagesInfo(CarImagesInfo carImagesInfo);
/**
 * 根据车主编号删除汽车照片信息的服务
 *@return boolean  
 */
	 public boolean deleteimagesinfouser(CarImagesInfo c);
/**
 * 根据车编号删除汽车照片信息的服务
 *@return boolean  
 */
	 public boolean deletecidimagesinfouser(CarImagesInfo c);
/**
 * 
 * 检查是否还有与某车主编号关联的汽车照片信息的服务
 * @return boolean
 */
	 public boolean checkimageinfouser(CarImagesInfo c);
/**
 * 
 * 检查是否还有与某车编号关联的汽车照片信息的服务
 * @return boolean
 */
	 public boolean checkcidimageinfouser(CarImagesInfo c);
	
}
