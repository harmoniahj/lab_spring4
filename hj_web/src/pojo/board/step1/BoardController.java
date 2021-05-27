package pojo.board.step1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

//@Configuration
//@Controller
public class BoardController extends HttpServlet implements Action{
	Logger logger = Logger.getLogger(BoardController.class);
	
//	@Autowired
//	@Bean
	private BoardLogic boardLogic = new BoardLogic();
	private ActionForward forward = null;
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("execute 호출");
		String uri = req.getRequestURI(); // /board/crudBoard.po1
		logger.info("uri ===> "+uri);
		
		String context = req.getContextPath(); // /board/crudBoard.po1
		String command = uri.substring(context.length()+1); // 앞에 /를 삭제함
		int end = command.lastIndexOf('.');
		command = command.substring(0, end); // board/crudBoard
		
		String upmu[] = null;
		upmu = command.split("/");
	 // upmu[0] = 폴더이름 board
	 // upmu[1] = 페이지(업무페이지) 이름
		
		for(String str:upmu) {
			logger.info("str ===> "+str);			
		}
		
		Map<String,Object> pmap = new HashMap<>();
		String path = null;
		boolean isRedirect = false;
		int result = 0;
		result = boardLogic.boardInsert(pmap);
		
		if(result == 1) {
			path = "boardInsertSuccess.jsp";
		}
		else if(result == 0) {
			path = "boardInsertFail.jsp";
		}
		res.sendRedirect(path);
		
		return null;
	}
	/*
	 * 자바이면 웹 서비스 즉 웹 어플리케이션 구현은 어렵다.
	 * 웹 어플리케이션을 구현 하려면 반드시 http프로토콜을 지원 받아야 함 > API
	 * http 프로토콜을 지원하는 API는 servlet-api.jar에 있음
	 * 반드시 표준 서블릿을 상속 받아야 함 > doGet을 오버라이드 할 수 있게 됨
	 * WAS인 톰캣 내부에 servlet-api.jar, jsp-api.jar가 내장됨
	 */
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException
	{
		execute(req,res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException
	{
		execute(req,res);		
	}	
}
