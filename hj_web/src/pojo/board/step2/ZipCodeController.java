package pojo.board.step2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ZipCodeController {
	Logger logger = Logger.getLogger(ZipCodeController.class);
	
	ZipCodeLogic zipCodeLogic = new ZipCodeLogic();
	
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		logger.info("execute 호출");
		
		ActionForward forward = new ActionForward();
		zipCodeLogic.getZipCodeList();
		return forward;
	}
}