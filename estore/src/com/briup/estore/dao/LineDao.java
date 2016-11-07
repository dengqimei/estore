package com.briup.estore.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.briup.estore.bean.Line;

public class LineDao {
	
	public void saveLine(Line line){
		SqlSessionFactory sqlSessionFactory = BaseDao.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		LineMapper mapper = sqlSession.getMapper(LineMapper.class);
		mapper.saveLine(line);
		sqlSession.commit();
	}
	
	public void deleteLine(Long id){
		SqlSessionFactory sqlSessionFactory = BaseDao.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		LineMapper mapper = sqlSession.getMapper(LineMapper.class);
		mapper.deleteLine(id);
		sqlSession.commit();
	}
	public List<Line> findLineByOrderId(Long id){
		SqlSessionFactory sqlSessionFactory = BaseDao.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		LineMapper mapper = sqlSession.getMapper(LineMapper.class);
		List<Line> list = mapper.findLineByOrderId(id);
		return list;
	}
	
}
