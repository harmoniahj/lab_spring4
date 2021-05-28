package com.util;

import java.io.FileNotFoundException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class MyBatisCommonFactory {
	static Logger logger = Logger.getLogger(MyBatisCommonFactory.class);
	public static SqlSessionFactory sqlSessionFactory = null;
	public MyBatisCommonFactory() {
		//init();
	}
	public static void init() {
		try {
			String resource = "com/mybatis/MapperConfig.xml";
			/* String resource = "com/mybatis/Configuration.xml"; */
			Reader reader = Resources.getResourceAsReader(resource);
			logger.info("before sqlSessionFactory:"+sqlSessionFactory);
			//if(sqlSessionFactory==null) {
			logger.info("if sqlSessionFactory:"+sqlSessionFactory);
			sqlSessionFactory = 
						new SqlSessionFactoryBuilder().build(reader, "development");
			//}
			logger.info("after sqlSessionFactory:"+sqlSessionFactory);
		} catch (FileNotFoundException ffe) {
			ffe.getMessage();
		} catch(Exception e) {
			e.getMessage();
		}
	}
	/* */
	public static SqlSessionFactory getSqlSessionFactory() {
		init();
		return sqlSessionFactory;
	}
	
}
