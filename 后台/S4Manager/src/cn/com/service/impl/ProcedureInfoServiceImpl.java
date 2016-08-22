package cn.com.service.impl;

import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.ProcedureInfo;
import cn.com.dao.impl.ProcedureInfoDaoImpl;
import cn.com.service.IProcedureInfoService;

public class ProcedureInfoServiceImpl implements IProcedureInfoService{
private ProcedureInfoDaoImpl procedureInfoDaoImpl=new ProcedureInfoDaoImpl();
	@Override
	public Map<Long, ProcedureInfo> getAllProcedureInfo() {
		// TODO Auto-generated method stub
		return procedureInfoDaoImpl.getAllProcedureInfo();
	}

	@Override
	public ProcedureInfo getProcedureInfoById(CarInfo carInfo) {
		// TODO Auto-generated method stub
		return procedureInfoDaoImpl.getProcedureInfoById(carInfo);
	}

	@Override
	public boolean addProcedureInfo(ProcedureInfo procedureInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(procedureInfoDaoImpl.addProcedureInfo(procedureInfo)>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean updateProcedureInfo(ProcedureInfo procedureInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(procedureInfoDaoImpl.updateProcedureInfo(procedureInfo)>0){
			flag=true;
		}
		
		return flag;
	}

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

	@Override
	public boolean checkprocedureinfouser(ProcedureInfo p) {
		// TODO Auto-generated method stub
		return procedureInfoDaoImpl.checkprocedureinfouser(p);
	}

	@Override
	public boolean checkcidprocedureinfouser(ProcedureInfo p) {
		// TODO Auto-generated method stub
		return procedureInfoDaoImpl.checkcidprocedureinfouser(p);
	}

}
