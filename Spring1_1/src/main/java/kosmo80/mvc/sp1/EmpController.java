package kosmo80.mvc.sp1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class EmpController extends MultiActionController {
	Logger logger = Logger.getLogger(EmpController.class);
	
	private EmpLogic empLogic = null;
	
 // setter 객체 주입코드
	public void setEmpLogic(EmpLogic empLogic) {
		this.empLogic = empLogic;
	}
	
	public ModelAndView getEmpList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("getEmpList  호출 성공");
		ModelAndView mav = new ModelAndView();
		List<Map<String,Object>> empList = null;
		empList = empLogic.getEmpList();
	 // ModelAndView는 scope속성이 request이다.
		mav.addObject("empList", empList);
		mav.setViewName("di/getEmpList");
		return mav;
	 // return "redirect:getEmpList.jsp";
	}
	
	public void getEmpList2(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("getEmpList2  호출 성공");

		ModelAndView mav = new ModelAndView();
		List<Map<String,Object>> empList = null;
		empList = empLogic.getEmpList();
		req.setAttribute("empList", empList);
		RequestDispatcher view = req.getRequestDispatcher("getEmpList.jsp");
		view.forward(req, res);
	 // return "redirect:getEmpList.jsp";
	}
	
	public void empInsert(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("empInsert  호출 성공");
		res.sendRedirect("/di/empInsertOk.jsp");
	}
}
