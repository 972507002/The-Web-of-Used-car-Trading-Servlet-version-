package cn.com.service;
import java.util.*;


import cn.com.bean.*;
public interface ITrendsService {
	public List<Trends> getITrendsByTime(Trends trends,int rows);
	public Trends getTrendsByWhere(Trends trends);
}
