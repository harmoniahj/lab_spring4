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
 // <bean id="board-controller">
 //	 <property name="boardLogic"> -> setter메소드 명
	private Board41Logic boardLogic = null;

 // setter 메소드를 통해 게으른 객체 주입
	public void setBoardLogic(Board41Logic boardLogic) {
		this.boardLogic = boardLogic;
	}
	
/* request로 유지, 메소드를 정의하는것 가능 
 * 파라미터 없어도 괜찮?? > 파라미터에 req나 res가 없으면 아무리 xml 문서에 url매핑을 해두었다 하더라도 찾지를 못함 > 의존적임
 * 처음 ModelAndview 사용 > 상속 받았을 때 doGet에서는 누릴 수 없었던 반환 타입을 바꾸어 슬 수 있는 혜택을 누릴수 있게됨
 * forward로 페이지를 부름 > 굳이 없어도 되는 것을 형식적으로 가지고 있어야 함 > doGet안에 있는 것이니까 너도 있어야 해줄겨??라 말하는 것
 */
	
 // spring-servelet.xml > viewResolver
	public ModelAndView getBoardList(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("getBoardList 호출 성공");
		
		HashMapBinder hmb = new HashMapBinder(req);
		Map<String,Object> target = new HashMap<>();
		hmb.bind(target);
		
		List<Map<String,Object>> boardList = null;
		boardLogic.getBoardList(target); // where bm_no=? and bm_title like '%' || ? || '%'
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/getBoardList"); // > 없어도 /board/getBoardList.sp4 의 getBoardList를 가져와 getBoardList.jsp로 이동
		mav.addObject("boardList", boardList);
	 // RequestDispatcher view = req.getRequestDispatcher("getBoardList.jsp");
 	 // view.forward(req, res);
		
		return mav;
	}
	
 // json으로 내보냄 줌 > @RestController > String, @Controller > void, ModelAndView > String
 // @RestController > spring boot에서 사용
	public void jsongetBoardList(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("jsonGetBoardList 호출 성공");
		
		List<Map<String, Object>> boardList = null;
		boardList = boardLogic.getBoardList(null);
		
		Gson g = new Gson();
		String imsi = g.toJson(boardList);
		res.setContentType("application/json;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print(imsi);
	}
}