package cn.com.dao;

import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.ProcedureInfo;
/**
 * 手续信息操作接口
 * @author lej
 */
public interface IProcedureInfoDao {
  /**
   * 
   * 获取所有手续信息的方法
   *@return Map<Long,ProcedureInfo> 
   */
public Map<Long, ProcedureInfo> getAllProcedureInfo();
/**
   * 
   * 根据编号获取手续信息的方法
   *@return ProcedureInfo
   */
public ProcedureInfo getProcedureInfoById(CarInfo carInfo);
/**
   * 
   * 添加手续信息的方法
   *@return int
   */
public int addProcedureInfo(ProcedureInfo procedureInfo);
/**
   * 
   * 修改手续信息的方法
   *@return  int
   */
public int updateProcedureInfo(ProcedureInfo procedureInfo);
}
