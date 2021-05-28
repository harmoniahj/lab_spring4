package pojo.board.step2;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;
 
public class SqlMapZipCodeDao {
	Logger logger = Logger.getLogger(SqlMapZipCodeDao.class);
	
	SqlSessionFactory sqlSessionFactory = null;
	SqlSession sqlSession = null;
	
	public void getZipCodeList() {
		logger.info("getZipCodeList 호출 성공 ===> " + sqlSessionFactory);
		
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
		String time = null;
		
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			time = sqlSession.selectOne("getZipCodeList");
			
			logger.info("단위 테스트 : " + time);
		} catch (Exception e) {
			logger.info(e.toString());
		}
	}
}