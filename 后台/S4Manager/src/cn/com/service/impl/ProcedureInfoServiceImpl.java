package cn.com.service.impl;

import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.ProcedureInfo;
import cn.com.dao.impl.ProcedureInfoDaoImpl;
import cn.com.service.IProcedureInfoService;
/**
 * 手续信息服务实现类
 * @author lej
 */
public class ProcedureInfoServiceImpl implements IProcedureInfoService{
	//手续信息操作实现类的引用
private ProcedureInfoDaoImpl procedureInfoDaoImpl=new ProcedureInfoDaoImpl();
  /**
   * 
   * 获取所有手续信息的服务
   *@return Map<Long,ProcedureInfo> 
   */
	@Override
	public Map<Long, ProcedureInfo> getAllProcedureInfo() {
		// TODO Auto-generated method stub
		return procedureInfoDaoImpl.getAllProcedureInfo();
	}
  /**
   * 
   * 根据编号获取手续信息的服务
   *@return ProcedureInfo
   */
	@Override
	public ProcedureInfo getProcedureInfoById(CarInfo carInfo) {
		// TODO Auto-generated method stub
		return procedureInfoDaoImpl.getProcedureInfoById(carInfo);
	}
  /**
   * 
   * 添加手续信息的服务
   *@return boolean
   */
	@Override
	public boolean addProcedureInfo(ProcedureInfo procedureInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(procedureInfoDaoImpl.addProcedureInfo(procedureInfo)>0){
			flag=true;
		}
		return flag;
	}
  /**
   * 
   * 修改手续信息的服务
   *@return  boolean
   */
	@Override
	public boolean updateProcedureInfo(ProcedureInfo procedureInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(procedureInfoDaoImpl.updateProcedureInfo(procedureInfo)>0){
			flag=true;
		}
		
		return flag;
	}
/**
 * 根据车主编号删除手续信息的服务
 *@return boolean  
 */
	@Override
	public boolean deleteprocedureinfouser(ProcedureInfo p) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(procedureInfoDaoImpl.deleteprocedureinfouser(p)>0)
		{
			flag=true;
		}
		return flag;
	}
/**
 * 根据车编号删除手续信息的服务
 *@return boolean  
 */
	@Override
	public boolean deletecidprocedureinfouser(ProcedureInfo p) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(procedureInfoDaoImpl.deletecidprocedureinfouser(p)>0)
		{
			flag=true;
		}
		return flag;
	}
/**
 * 
 * 检查是否还有与某车主编号关联的手续信息的服务
 * @return boolean
 */
	@Override
	public boolean checkprocedureinfouser(ProcedureInfo p) {
		// TODO Auto-generated method stub
		return procedureInfoDaoImpl.checkprocedureinfouser(p);
	}
/**
 * 
 * 检查是否还有与某车编号关联的手续信息的服务
 * @return boolean
 */
	@Override
	public boolean checkcidprocedureinfouser(ProcedureInfo p) {
		// TODO Auto-generated method stub
		return procedureInfoDaoImpl.checkcidprocedureinfouser(p);
	}

}
