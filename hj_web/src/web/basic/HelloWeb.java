package web.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
//어떻게 서블릿(자바)을 브라우저에서 호출할 수 있을까?
//URL로 요청을 할 수 있나?
@WebServlet(urlPatterns="/hello")
public class HelloWeb extends HttpServlet {
	Logger logger = Logger.getLogger(HelloWeb.class);
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		logger.info("doGet 호출 성공");
		PrintWriter out = res.getWriter();
		String mem_id = req.getParameter("mem_id");
		String mem_pw = req.getParameter("mem_pw");
		logger.info("사용자가 입력한 ID : "+mem_id);
		logger.info("사용자가 입력한 PW : "+mem_pw);
		out.println("<b>Hello Web Service!!!</b>");;
		
	}
}
