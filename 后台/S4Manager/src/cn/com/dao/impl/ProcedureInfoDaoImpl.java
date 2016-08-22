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

public class ProcedureInfoDaoImpl implements IProcedureInfoDao{

	@Override
	public Map<Long, ProcedureInfo> getAllProcedureInfo() {
		// TODO Auto-generated method stub
//		private long u_id;
//		 private long c_id;
//		 private String purchaseTax;
//		 private String drivingLicense;
//		 private String ncw;
//		 private String registration;
//		 private String newInvoice;
//		 private int key;
//		 private int transferTimes;
//		 private String transferTicket;
		String sql="select * from procedureinfo";
		Map<Long, ProcedureInfo> procedureInfoMap=new HashMap<Long, ProcedureInfo>();
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

	@Override
	public ProcedureInfo getProcedureInfoById(CarInfo carInfo) {
		// TODO Auto-generated method stub
		ProcedureInfo procedureInfo2=null;
		String sql="select * from procedureinfo where u_id=? and c_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(carInfo.getU_id());
		params.add(carInfo.getC_id());
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

	@Override
	public int addProcedureInfo(ProcedureInfo procedureInfo) {
		// TODO Auto-generated method stub
		String sql="insert into procedureinfo values(?,?,?,?,?,?,?,?,?,?)";
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

	@Override
	public int updateProcedureInfo(ProcedureInfo procedureInfo) {
		// TODO Auto-generated method stub
		List<Object> params=new ArrayList<Object>();
		StringBuffer sql=new StringBuffer("update  procedureinfo set purchaseTax=?,drivingLicense=?,ncw=?,registration=?,newInvoice=?,key=?,transferTimes=?,transferTicket=? where u_id=? and c_id=? ");
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

	@Override
	public int deleteprocedureinfouser(ProcedureInfo p) {
		// TODO Auto-generated method stub
		String sql="delete from procedureinfo where u_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(p.getU_id());
		return DbUtil.executeUpdate(sql, params);
	}

	@Override
	public int deletecidprocedureinfouser(ProcedureInfo p) {
		// TODO Auto-generated method stub
		String sql="delete from procedureinfo where c_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(p.getC_id());
		return DbUtil.executeUpdate(sql, params);
	}

	@Override
	public boolean checkprocedureinfouser(ProcedureInfo p) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="select * from procedureinfo where u_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(p.getU_id());
		ResultSet res=DbUtil.executeQuery(sql, params);
		try {
			while(res.next())
			{
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean checkcidprocedureinfouser(ProcedureInfo p) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="select * from procedureinfo where c_id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(p.getC_id());
		ResultSet res=DbUtil.executeQuery(sql, params);
		try {
			while(res.next())
			{
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
