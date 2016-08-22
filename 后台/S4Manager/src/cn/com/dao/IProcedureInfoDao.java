package cn.com.dao;

import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.ProcedureInfo;

public interface IProcedureInfoDao {
public Map<Long, ProcedureInfo> getAllProcedureInfo();
public ProcedureInfo getProcedureInfoById(CarInfo carInfo);
public int addProcedureInfo(ProcedureInfo procedureInfo);
public int updateProcedureInfo(ProcedureInfo procedureInfo);
public int deleteprocedureinfouser(ProcedureInfo p);
public int deletecidprocedureinfouser(ProcedureInfo p);
public boolean checkprocedureinfouser(ProcedureInfo p);
public boolean checkcidprocedureinfouser(ProcedureInfo p);
}
