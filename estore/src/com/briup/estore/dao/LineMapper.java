package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.Line;

public interface LineMapper {
	
	void saveLine(Line line);
	
	void deleteLine(Long id);
	
	List<Line> findLineByOrderId(Long id);
	
}
