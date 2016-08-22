package cn.com.service;

import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.ProcedureInfo;

public interface IProcedureInfoService {
	public Map<Long, ProcedureInfo> getAllProcedureInfo();
	public ProcedureInfo getProcedureInfoById(CarInfo carInfo);
	public boolean addProcedureInfo(ProcedureInfo procedureInfo);
	public boolean updateProcedureInfo(ProcedureInfo procedureInfo);
}
