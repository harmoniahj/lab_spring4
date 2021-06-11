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
		int bm_no =0; // 게시글이 새글인지 댓글인지
		int bm_group = 0;
		if(pmap.get("bm_group") == null) { // read.jsp에서 댓글 쓰기 버튼 누름
			bm_group = Integer.parseInt(pmap.get("bm_group").toString());
		}
		
	 // 댓글인지 확인
		if(bm_group > 0) {
			boardMDao.bmStepUpdate(pmap); // 조건에 맞지 않으면 처리 생략될 수 있음
			pmap.put("bm_pos", Integer.parseInt(pmap.get("bm_pos").toString()) + 1);
			pmap.put("bm_step", Integer.parseInt(pmap.get("bm_step+bm_step").toString()) + 1);
		}
		else { // 새글
			bm_group = boardMDao.getBmGroup(); // 새글일때 새로운 그룹번호 추가
			pmap.put("bm_group", bm_group);
			pmap.put("bm_pos", 0);
			pmap.put("bm_step", 0);
		}
	
	 // 첨부파일 있는지 확인
		if((pmap.get("bm_pos") != null) & (pmap.get("bm_pos").toString().length() > 0)) {
			pmap.put("bm_no", bm_no);
			pmap.put("bm_seq", 1);
			boardSDao.boardSinsert(pmap);
		}
		boardMDao.boardMInsert(pmap);
		
		int fileOk = 0;
		boardMDao.boardMInsert(pmap);
		result = 1;
		
		return result;
	}
}