package web.mvc;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

public class Board41SDao {
	private SqlSessionTemplate sqlSessionTemplate = null;
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public int boardSinsert(Map<String, Object> pmap) {
		int result = 0;
		pmap.put("bs_seq", 1);
		pmap.put("bs_size", 50);
		sqlSessionTemplate.insert("boardSInsert",pmap);
		
		return result;
	}
}