package kosmo80.mvc.sp4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class EmpController extends MultiActionController {
	Logger logger = Logger.getLogger(EmpController.class);
	
	public ModelAndView getEmpList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("getEmpList  호출 성공");
		ModelAndView mav = new ModelAndView();
	//	/WEB-INF/views/getEmpList.jsp
		
		List<Map<String,Object>> empList = new ArrayList<>();
		Map<String,Object> rmap = new HashMap<>();
		rmap.put("mem_name", "이순신장군");
		empList.add(rmap);
	// ModelAndView는 scope속성이 request
		mav.addObject("empList", empList);
		mav.setViewName("di/getEmpList");
		return mav;
	}
	
	public void empInsert(HttpServletRequest req
			            , HttpServletResponse res) 
	throws Exception
	{
		logger.info("empInsert  호출 성공");
		res.sendRedirect("/di/empInsertOk.jsp");
	}
}