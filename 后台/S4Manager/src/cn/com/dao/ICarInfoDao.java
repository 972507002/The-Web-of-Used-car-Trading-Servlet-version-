package cn.com.dao;
import java.util.*;
import cn.com.bean.*;
public interface ICarInfoDao {
  public Map<Long, CarInfo> getCarInfoByCountDesc(CarInfo carInfo);
  public Map<Long, CarInfo>  getCarInfoByBrandCountDesc(CarInfo carInfo);
  public Map<Long, CarInfo> getCarInfoBySjTime(CarInfo carInfo);
  public Map<Long, CarInfo> getFourthCarInfoBySjTime(CarInfo carInfo);
  public Map<Long, CarInfo>  getCarInfoByTypeCountDesc(CarInfo carInfo);
  public Map<Long, CarInfo> getCarInfoByBrand(CarInfo carInfo);
  public Map<Long,CarInfo>   getCarInfoByType(CarInfo carInfo);
  public Map<Long, CarInfo> getCarByWhere(CarInfo carInfo);
  public int updateCarInfo(CarInfo carInfo);
  public int addCarInfo(CarInfo carInfo);
  public CarInfo getCarInfoByUMN(CarInfo carInfo);
  public int updateCarAll(CarInfo carInfo);
  public int deletecarinfouser(CarInfo u);
  public int deletecarinfo(CarInfo c);
  public boolean checkcarinfouser(CarInfo c);
}
