package web.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class DeptServlet extends HttpServlet {
	Logger logger = Logger.getLogger(DeptServlet.class);
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
//		res.setContentType("application/json;utf-8");
		logger.info("doGet 호출 성공");
		res.setContentType("application/json;charset=utf-8");
		PrintWriter out = res.getWriter();//응답 객체를 활용하여  객체 주입 받는다.
	 // out.print("<b>응답페이지</b>");브라우저에 출력한다. 그러니까 서블릿으로 웹서비스가 가능함.
	 // deptList.nhn?mode=json|youtube|naver
		String mode = req.getParameter("mode");
		if(mode==null) {
			String mem_id = req.getParameter("m_id");
			logger.info("사용자가 입력한 아이디는 "+mem_id);			
		}else if("json".equals(mode)) {
			logger.info("json 호출 성공");
			List<Map<String,Object>> dname = new ArrayList<>();
			int i = 0;
			Map<String,Object> rmap = new HashMap<>();
			rmap.put("deptno",11);
			rmap.put("dname","개발팀");
			rmap.put("loc","제주");
			dname.add(i++,rmap);
			rmap = null;
			rmap = new HashMap<>();
			rmap.put("deptno",21);
			rmap.put("dname","운영팀");
			rmap.put("loc","괌");
			dname.add(i++,rmap);
			rmap = null;
			rmap = new HashMap<>();
			rmap.put("deptno",31);
			rmap.put("dname","형상관리팀");
			rmap.put("loc","서울");
			dname.add(i++,rmap);
			req.setAttribute("dname", dname);
			RequestDispatcher view = req.getRequestDispatcher("/dept/jsonDeptList.jsp");
			view.forward(req, res);				
		}else if("youtube".equals(mode)) {
			logger.info("youtube 호출 성공");
			
		}else if("naver".equals(mode)) {
			logger.info("naver 호출 성공");
			
		}
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		logger.info("doPost 호출 성공");
	}
	
}