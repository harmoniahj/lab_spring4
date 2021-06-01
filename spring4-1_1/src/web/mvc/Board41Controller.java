package web.mvc;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class Board41Controller extends MultiActionController {
	Logger logger = Logger.getLogger(Board41Controller.class);
 // <bean id="board-controller">
 //	 <property name="boardLogic"> -> setter메소드 명
	private Board41Logic boardLogic = null;

 // setter 메소드를 통해 게으른 객체 주입
	public void setBoardLogic(Board41Logic boardLogic) {
		this.boardLogic = boardLogic;
	}
	
 // request로 유지
 // 메소드를 정의하는것 가능, 파라미터 없어도 괜찮??
	public ModelAndView getBoardList() {
		logger.info("getBoardList 호출 성공");
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}
	
 // json으로 내보냄 줌 > @RestController > String, @Controller > void, ModelAndView > String
	public void jsongetBoardList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("jsongetBoardList 호출 성공");
	}
}