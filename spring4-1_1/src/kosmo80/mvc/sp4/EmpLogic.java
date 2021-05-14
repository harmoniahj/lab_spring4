package kosmo80.mvc.sp4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

public class EmpLogic {
	Logger logger = Logger.getLogger(EmpLogic.class);
	
	public List<Map<String, Object>> getEmpList() {
		logger.info("getEmpList 호출 성공");
		return null;
	}
}