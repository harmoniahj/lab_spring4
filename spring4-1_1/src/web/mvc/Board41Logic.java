package web.mvc;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class Board41Logic {
	Logger logger = Logger.getLogger(Board41Logic.class);
	
	private Board41MDao boardMDao = null;
	public void setBoardMDao(Board41MDao boardMDao) {
		this.boardMDao = boardMDao;
	}
	
	private Board41SDao boardSDao = null;
	public void setBoardSDao(Board41SDao boardSDao) {
		this.boardSDao = boardSDao;
	}
	
	public List<Map<String,Object>> getBoardList(Map<String, Object> pmap) {
		logger.info("getBoardList 호출 성공");
		
		List<Map<String,Object>> boardList = null;
		boardList = boardMDao.getBoardList(pmap);
		return boardList;
	}
	
 // board/boardInsert.sp4?bm_no=10&bm_title=게시판&bs_file=a.txt&bm_writer=김유신&bm_email=test@hot.com&bm_content=내용&bm_pw=123
	public int boardInsert(Map<String, Object> pmap) {
		logger.info("boardInsert 성공");
		
		int result = 0;
		int fileOk = 0;
		boardMDao.boardMInsert(pmap);
		
	 // 첨부파일이 존재??
		if(pmap.containsKey("bm_file")) {
			fileOk = boardSDao.boardSinsert(pmap);
		}
		result = 1;
		
		return result;
	}
}