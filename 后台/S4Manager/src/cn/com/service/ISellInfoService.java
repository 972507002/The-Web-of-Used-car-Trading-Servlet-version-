package cn.com.service;

import java.util.Map;

import cn.com.bean.CarInfo;
import cn.com.bean.SellInfo;

public interface ISellInfoService {
	/**
	 * ��ȡ����������Ϣҵ��
	 */
	public Map<Long, SellInfo> getAllSellInfo();
	/**
	 * ���ݳ���Ż�ȡ�������ҵ��
	 */
	public SellInfo getSellInfoById(CarInfo carInfo);
	/**
	 * �����������ҵ��
	 */
	public boolean addSellInfo(SellInfo sellInfo);
	/**
	 * ɾ���������ҵ��
	 */
	public int deleteSellInfo(SellInfo sellInfo);
	public boolean updateSellInfo(SellInfo sellInfo);
	public boolean deletesellinfouser(SellInfo s);
	 public boolean deletecidsellinfouser(SellInfo s);
	 public boolean checksellinfouser(SellInfo s);
	 public boolean checkcidsellinfouser(SellInfo s);
}
