package pojo.board.step2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class BoardController{
	Logger logger = Logger.getLogger(BoardController.class);
	
	private BoardLogic boardLogic = new BoardLogic();
	
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		logger.info("step2 ===> execute 호출 성공");
		
		ActionForward forward = new ActionForward();
		String viewName = null;
		boolean isRedirect = false;
		String crud = (String)req.getAttribute("crud");
		String[] upmu = (String[])req.getAttribute("upmu");
		
		logger.info("upmu:"+upmu);
		
		if("boardInsert".equals(upmu[1])) {
			logger.info("글쓰기 호출 성공");
			viewName = "boardInsertSuccess.jsp";
			isRedirect = true;
			forward.setRedirect(isRedirect);
			forward.setPath(viewName);
		}
		return forward;
	}	
}