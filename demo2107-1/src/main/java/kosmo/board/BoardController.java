package kosmo.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vo.UserVO;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
 // @Autowired > 생성자, 메소드, 멤버변수 사용가능 => NoSuchBeanDefinition 발생
	@Autowired
	private BoardLogic boardLogic = null;
	
	@GetMapping(value="login.do")
	public String loginView(@ModelAttribute("user") UserVO vo) {
		return "redirect:login.jsp";
	}
	
	public ModelAndView getBoardList(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		return null;
	}
}