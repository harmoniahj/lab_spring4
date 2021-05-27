package pojo.board.step2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

//@Configuration
//@Controller
public class BoardController{
	Logger logger = Logger.getLogger(BoardController.class);
	
	private BoardLogic boardLogic = new BoardLogic();
	
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		logger.info("execute 호출 성공");
		
		ActionForward forward = new ActionForward();
		String viewName = null;
		boolean isRedirect = false;
		String crud = (String)req.getAttribute("crud");
		
		if("boardInser".contentEquals(crud)) {
			logger.info("글쓰기 호출 성공");
			viewName = "crudBoard.po2?crud=getBoardList"; 
			isRedirect = true;
			
			forward.setRedirect(isRedirect);
			forward.setPath(viewName);
		}
		
		return forward;
	}
}
