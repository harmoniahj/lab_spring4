package web.mvc;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.google.gson.Gson;
import com.util.HashMapBinder;

public class Board41Controller extends MultiActionController {
	Logger logger = Logger.getLogger(Board41Controller.class);
	
	private Board41Logic boardLogic = null;
	
	//setter메소드를 통하여 게으른 객체 주입
	public void setBoardLogic(Board41Logic boardLogic) {
		this.boardLogic = boardLogic;
	}
	/* request로 유지, 메소드를 정의하는 것은 가능
	 * 파라미터가 없이도 괜찮???
	 * 파라미터에 req나 res가 없으면 아무리 xml문서에 url매핑을 해두었다 하더라도 찾지 못함 > 의존적
	 * 최초 ModelAndView를 사용 > 이것은 MultiActionController를 상속 받았을 때 
	 * 우리가 doGet에서는 누릴 수 없었던 반환 타입을 바꾸어 쓸 수 있는 혜택을 누릴 수 있게 됨
	 *  forward로 페이지를 부름
	 *  ModelAndView가 있는데 굳이 파라미터에 req, res가 있어야만 한다 그렇지 않으면 매핑을 해주지 않을  것이라고 
	 *  말하는 것은 앞뒤가 맞지 않음 > 굳이 없어도 되는 것을 형식적으로 가지고 있어야 한다. doGet안에 있는 것여서 너도 있어야 해줄거야? 라고 말하는 것 
	 */
	
	public ModelAndView getBoardList(HttpServletRequest req, HttpServletResponse res)  throws Exception {
		logger.info("getBoardList 호출 성공");
		
		HashMapBinder hmb = new HashMapBinder(req);
		Map<String,Object> target = new HashMap<>();
		hmb.bind(target);
		
		List<Map<String,Object>> boardList = null;
		boardList=boardLogic.getBoardList(target); // where bm_no=? and bm_title LIKE '%'||?||'%'
		
		logger.info("boardList:" + boardList);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/getBoardList");
		mav.addObject("boardList", boardList);
	 // RequestDispatcher view = req.getRequestDispatcher("getBoardList.jsp");
	 // view.forward(req, res);
		
		return mav;
	}
	
 // json으로 내보내줌 - @RestController : String, @Controller : void, ModelAndView, String
 // @RestController
	public void jsongetBoardList(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("jsonGetBoardList 호출 성공");
		
		List<Map<String,Object>> boardList = null;
		boardList = boardLogic.getBoardList(null);
		
		Gson g = new Gson();
		String imsi = g.toJson(boardList);
		PrintWriter out = res.getWriter();
		res.setContentType("application/json;charset=utf-8");
		out.print(imsi);
	}
}