package cn.com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.ProcedureInfo;
import cn.com.dao.IProcedureInfoDao;
import cn.com.util.DbUtil;
/**
 * 手续信息操作实现类
 * @author lej
 */
public class ProcedureInfoDaoImpl implements IProcedureInfoDao{
 /**
   * 
   * 获取所有手续信息的方法
   *@return Map<Long,ProcedureInfo> 
   */
	@Override
	public Map<Long, ProcedureInfo> getAllProcedureInfo() {
		// TODO Auto-generated method stub

		String sql="select * from procedureinfo";
		Map<Long, ProcedureInfo> procedureInfoMap=new HashMap<Long, ProcedureInfo>();
		//获取结果集
		ResultSet res=DbUtil.executeQuery(sql, null);
		try {
			while(res.next()){
				ProcedureInfo procedureInfo=new ProcedureInfo();
				procedureInfo.setU_id(res.getLong("u_id"));
				procedureInfo.setC_id(res.getLong("c_id"));
				procedureInfo.setPurchaseTax(res.getString("purchaseTax"));
				procedureInfo.setDrivingLicense(res.getString("drivingLicense"));
				procedureInfo.setNcw(res.getString("ncw"));
				procedureInfo.setRegistration(res.getString("registration"));
				procedureInfo.setNewInvoice(res.getString("newInvoice"));
				procedureInfo.setKey(res.getInt("key"));
				procedureInfo.setTransferTimes(res.getInt("transferTimes"));
				procedureInfo.setTransferTicket(res.getString("transferTicket"));
				procedureInfoMap.put(procedureInfo.getU_id(), procedureInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return procedureInfoMap;
	}
  /**
   * 
   * 根据编号获取手续信息的方法
   *@return ProcedureInfo
   */
	@Override
	public ProcedureInfo getProcedureInfoById(CarInfo carInfo) {
		// TODO Auto-generated method stub
		ProcedureInfo procedureInfo2=null;
		String sql="select * from procedureinfo where u_id=? and c_id=?";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(carInfo.getU_id());
		params.add(carInfo.getC_id());
		//获取结果集
		ResultSet res=DbUtil.executeQuery(sql, params);
		try {
			while(res.next()){
				procedureInfo2=new ProcedureInfo();
				procedureInfo2.setU_id(res.getLong("u_id"));
				procedureInfo2.setC_id(res.getLong("c_id"));
				procedureInfo2.setPurchaseTax(res.getString("purchaseTax"));
				procedureInfo2.setDrivingLicense(res.getString("drivingLicense"));
				procedureInfo2.setNcw(res.getString("ncw"));
				procedureInfo2.setRegistration(res.getString("registration"));
				procedureInfo2.setNewInvoice(res.getString("newInvoice"));
				procedureInfo2.setKey(res.getInt("key"));
				procedureInfo2.setTransferTimes(res.getInt("transferTimes"));
				procedureInfo2.setTransferTicket(res.getString("transferTicket"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return procedureInfo2;
	}
  /**
   * 
   * 添加手续信息的方法
   *@return int
   */
	@Override
	public int addProcedureInfo(ProcedureInfo procedureInfo) {
		// TODO Auto-generated method stub
		String sql="insert into procedureinfo values(?,?,?,?,?,?,?,?,?,?)";
		//绑定参数
		List<Object> params=new ArrayList<Object>();
		params.add(procedureInfo.getU_id());
		params.add(procedureInfo.getC_id());
		params.add(procedureInfo.getPurchaseTax());
		params.add(procedureInfo.getDrivingLicense());
		params.add(procedureInfo.getNcw());
		params.add(procedureInfo.getRegistration());
		params.add(procedureInfo.getNewInvoice());
		params.add(procedureInfo.getKey());
		params.add(procedureInfo.getTransferTimes());
		params.add(procedureInfo.getTransferTicket());
		
		return DbUtil.executeUpdate(sql, params);
	}
  /**
   * 
   * 删除手续信息的方法
   *@return  int
   */
	@Override
	public int updateProcedureInfo(ProcedureInfo procedureInfo) {
		// TODO Auto-generated method stub
		List<Object> params=new ArrayList<Object>();
		StringBuffer sql=new StringBuffer("update  procedureinfo set purchaseTax=?,drivingLicense=?,ncw=?,registration=?,newInvoice=?,key=?,transferTimes=?,transferTicket=? where u_id=? and c_id=? ");
		//绑定参数
		params.add(procedureInfo.getPurchaseTax());
		params.add(procedureInfo.getDrivingLicense());
		params.add(procedureInfo.getNcw());
		params.add(procedureInfo.getRegistration());
		params.add(procedureInfo.getNewInvoice());
		params.add(procedureInfo.getKey());
		params.add(procedureInfo.getTransferTimes());
		params.add(procedureInfo.getTransferTicket());
		params.add(procedureInfo.getU_id());
		params.add(procedureInfo.getC_id());

		
		return DbUtil.executeUpdate(sql.toString(), params);
	}

}
