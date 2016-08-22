package cn.com.dao;

import java.util.*;

import cn.com.bean.*;

public interface ITrendsDao {
       public List<Trends>  getITrendsByTime(Trends trends,int rows);
       public Trends getTrendsByWhere(Trends trends);
       public int addTrends(Trends trends);
       public int deleteTrends(Trends trends);
       public int updateTrends(Trends trends);
}
