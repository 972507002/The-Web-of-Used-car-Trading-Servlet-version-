package cn.com.dao;

import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.SellInfo;

public interface ISellInfoDao {
	/**
	 * ��ȡ����������Ϣ
	 * @return
	 */
public Map<Long, SellInfo> getAllSellInfo();
/**
 * ���ݳ���Ż�ȡ�������
 * @return
 */
public SellInfo getSellInfoById(CarInfo carInfo);
/**
 * �����������
 * @param sellInfo
 * @return
 */
public int addSellInfo(SellInfo sellInfo);
/**
 * ɾ���������
 * @param sellInfo
 * @return
 */
public int deleteSellInfo(SellInfo sellInfo);
public int updateSellInfo(SellInfo sellInfo);

}
