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
	
 // setter메소드를 통하여 게으른 객체 주입
	public void setBoardLogic(Board41Logic boardLogic) {
		this.boardLogic = boardLogic;
	}
	
 /* request로 유지> 메소드를 정의하는 것은 가능
  * 파라미터가 없이도 괜찮???
  * > 파라미터에 req나 res가 없으면 아무리 xml문서에 url매핑을 해두었다 하더라도 찾지 못함 -> 의존적임
  * 최초  ModelAndView 사용 > MultiActionController를 상속 받았을 때  doGet에서는 누릴 수 없었던 반환 타입을 바꾸어 쓸 수 있는 혜택을 누릴 수 있게 됨
  * ModelAndView의 scope를 request로 한 이유 >  forward로 페이지를 부름
  * ModelAndView 가 있는데 굳이 파라미터에 req, res가 있어야만 함
  * 굳이 없어도 되는 것을 형식적으로 가지고 있어야 함 */
	
	public ModelAndView getBoardList(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("getBoardList 호출 성공");
		
		HashMapBinder hmb = new HashMapBinder(req);
		Map<String,Object> target = new HashMap<>();
		hmb.bind(target);
		
		List<Map<String,Object>> boardList = null;
		boardList=boardLogic.getBoardList(target); // where bm_no=? and bm_title like '%'||?||'%'
		logger.info("boardList:" + boardList);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/getBoardList");
		mav.addObject("boardList", boardList);
	 // RequestDispatcher view = req.getRequestDispatcher("getBoardList.jsp");
	 // view.forward(req, res);
		return mav;
	}
	
	/********************************************************
	 * 게시글 상세보기 구현
	 * @param req
	 * @param res
	 * @return ModelAndView
	 * @throws Exception
	 * 주의사항 - 전체조회와 하나로 합쳐 지니까 target에 구분값을 추가할것.
	 ********************************************************/
	public ModelAndView getBoardDetail(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("getBoardDetail 호출 성공");
		
		HashMapBinder hmb = new HashMapBinder(req);
		Map<String,Object> target = new HashMap<>();
		hmb.bind(target); // bm_no값 담음.
		target.put("gubun", "detail");
		
		logger.info("bm_no : " + target.get("bm_no"));
		List<Map<String,Object>> boardDetail = null;
		boardDetail=boardLogic.getBoardList(target);//where bm_no=? and bm_title LIKE '%'||?||'%'
		
		logger.info("boardList:" + boardDetail);//
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/read");
		mav.addObject("boardDetail", boardDetail);
	 // RequestDispatcher view = req.getRequestDispatcher("getBoardList.jsp");
	 // view.forward(req, res);
		
		return mav;
	}
	
	public ModelAndView updateForm(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("updateForm 호출 성공");
		
		HashMapBinder hmb = new HashMapBinder(req);
		Map<String,Object> target = new HashMap<>();
		hmb.bindPost(target); // bm_no값 담음.
		logger.info("bm_no : " + target.get("bm_no")); 
		
		ModelAndView mav = new ModelAndView(); 
		mav.setViewName("board/updateForm");
		mav.addObject("target", target);
		
		return mav;
	}
	
 // json으로 내보내준다. - @RestController:String, @Controller:void, ModelAndView, String
 // @RestController
	public void jsongetBoardList(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("jsonGetBoardList 호출 성공");
		
		HashMapBinder hmb = new HashMapBinder(req);
		Map<String,Object> target = new HashMap<>();
		hmb.bind(target);		
		
		List<Map<String,Object>> boardList = null;
		boardList = boardLogic.getBoardList(target);
		
		Gson g = new Gson();
		String imsi = g.toJson(boardList);
		res.setContentType("application/json;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print(imsi);
	}
	
	public void boardInsert(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("boardInsert호출 성공");
		
		HashMapBinder hmb = new HashMapBinder(req);
		Map<String,Object> pmap = new HashMap<>();
	 // 사용자가 입력한 값이나 서버에서 클라이언트에게 요청한 값 넘김
	 // hmb.bindPost(pmap);
		hmb.multiBind(pmap);
		
		int result = 0;
		result = boardLogic.boardInsert(pmap);
		if(result == 1) {
			res.sendRedirect("./getBoardList.sp4");
		}
		else {
			res.sendRedirect("등록실패 페이지 이동처리");
		}
	}
	
	public void boardUpdate(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("boardUpdate호출 성공");
		
		HashMapBinder hmb = new HashMapBinder(req);
		Map<String,Object> pmap = new HashMap<>();
		
		hmb.bindPost(pmap);
		int result = 0;
		result = boardLogic.boardUpdate(pmap);
		if(result == 1) {
			res.sendRedirect("./getBoardList.sp4");
		}
		else {
			res.sendRedirect("등록실패 페이지 이동처리");
		}
	}
	
	public void boardDelete(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("boardUpdate호출 성공");
		
		HashMapBinder hmb = new HashMapBinder(req);
		Map<String,Object> pmap = new HashMap<>();
		
		hmb.bindPost(pmap);
		int result = 0;
		result = boardLogic.boardDelete(pmap);
		if(result == 1) {
			res.sendRedirect("./getBoardList.sp4");
		}
		else {
			res.sendRedirect("등록실패 페이지 이동처리");
		}
	}
}