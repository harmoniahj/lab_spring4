package web.mvc;

import com.vo.BoardMVO;
import com.vo.BoardSVO;

public class VOTest {
	public static void main(String[] args) {
		BoardMVO bmVO = new BoardMVO();
		BoardSVO bsVO = new BoardSVO();
		
		bsVO.setBs_file("avatar.png");
		bmVO.setBsVO(bsVO);
	//	BoardSVO = bsVO2(bsVO);
	//	String bs_file = bsVO2.getBs_file();
		
		System.out.println(bmVO.getBsVO().getBs_file());
	//	System.out.println(bs_file);
	}
}