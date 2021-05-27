package pojo.board.step2;

import java.util.Map;

//Pure
public class BoardLogic {
	private SqlMapBoardMDao smBm = new SqlMapBoardMDao();
	private SqlMapBoardSDao smBs = new SqlMapBoardSDao();
	public int boardInsert(Map<String, Object> pmap) {
		int result = 0;
		int result1 = 0;
		int result2 = 0;
		result = 1;
		result1 = smBm.boardMInsert();
		result2 = smBs.boardSInsert();
		if(result1==1 && result2 ==1) {
			result = 1;
		}else {
			result = 0;
		}
		return result;
	}

}
