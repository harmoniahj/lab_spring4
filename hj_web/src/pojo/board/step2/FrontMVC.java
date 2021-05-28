package pojo.board.step2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class FrontMVC extends HttpServlet {
	Logger logger = Logger.getLogger(FrontMVC.class);
	
	BoardController boardController 	= new BoardController();
	MemberController memberController 	= new MemberController();
	ZipCodeController zipCodeController = new ZipCodeController();
	
	public void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		logger.info("doService 호출 성공");
		String uri = req.getRequestURI(); // /board/crudBoard.po1
		
		logger.info("uri ===> " + uri);
		String context = req.getContextPath(); // /board/crudBoard.po1
		
		logger.info("context ===> " + context);		
		String command = uri.substring(context.length()+1); // 앞에 /를 삭제
		
		int end = command.lastIndexOf('.');
		command = command.substring(0, end); // board/crudBoard
		
		String upmu[] = null;
		upmu = command.split("/");
		ActionForward forward = null;
		req.setAttribute("upmu", upmu);
		
		if("member".equals(upmu[0])) { // /board/boardInsert.po2
			logger.info("회원관리 구현 컨트롤 계층 연결");
			forward = memberController.execute(req,res);
		}
		else if("board".equals(upmu[0])) { // /zipcode/getZipCodeList.po2
			logger.info("게시판 구현 컨트롤 계층 연결");
			forward = boardController.execute(req,res);
		}
		else if("zipcode".equals(upmu[0])) {
			logger.info("우편번호 조회 컨트롤 계층 연결");
			forward = zipCodeController.execute(req,res);
		}
		
	 // 아래 널 비교 없으면 NullPointerException 이 발생함 - 500번에러
		if(forward !=null) {
			if(forward.isRedirect()) {
				res.sendRedirect(forward.getPath());
			}
			else {
				RequestDispatcher view = req.getRequestDispatcher(forward.getPath());
				view.forward(req, res);
			}
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		doService(req,res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		doService(req,res);		
	}
}