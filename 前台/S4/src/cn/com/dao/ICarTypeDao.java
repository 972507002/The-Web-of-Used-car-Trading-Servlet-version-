package cn.com.dao;

import java.util.*;
import cn.com.bean.*;

public interface ICarTypeDao {
	public Map<Integer, CarType> getCarTypeByCount();
	public Map<Integer, CarType> getAllCarType();
}
