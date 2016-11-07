package com.briup.estore.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.briup.estore.bean.Book;

public class BookDao {
	
	public List<Book> listAllBooks(){
		SqlSessionFactory sqlSessionFactory = BaseDao.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		BookMapper mapper = sqlSession.getMapper(BookMapper.class);
		List<Book> list = mapper.queryAll();
		return list;
	}
	
	public Book findById(Long id){
		SqlSessionFactory sqlSessionFactory = BaseDao.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		BookMapper mapper = sqlSession.getMapper(BookMapper.class);
		Book book = mapper.queryById(id);
		return book;
	}
	
}
