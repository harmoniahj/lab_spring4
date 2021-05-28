package pojo.board.step2;

import org.apache.log4j.Logger;

public class ZipCodeLogic {
	Logger logger = Logger.getLogger(ZipCodeLogic.class);
	
	SqlMapZipCodeDao sqlZipCodeDao = new SqlMapZipCodeDao();
	
	public void getZipCodeList() {
		logger.info("getZipCodeList  호출 성공");
		sqlZipCodeDao.getZipCodeList();
	}	
}