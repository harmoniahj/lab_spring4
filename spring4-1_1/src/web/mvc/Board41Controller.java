package web.mvc;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class Board41Controller extends MultiActionController {
 // <bean id="board-controller">
 //	 <property name="boardLogic"> -> setter메소드 명
	private Board41Logic boardLogic = null;

 // setter 메소드를 통해 게으른 객체 주입
	public void setBoardLogic(Board41Logic boardLogic) {
		this.boardLogic = boardLogic;
	}
}