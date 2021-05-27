package data.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import data.vo.DeptVO;

public class A3 {

	public static void main(String[] args) {
		List<Map<String,Object>> dname = new ArrayList<>();
		int i = 0;
		
		Map<String,Object> rmap = new HashMap<>();
		rmap.put("deptno",10);
		rmap.put("dname","개발1팀");
		rmap.put("loc","제주");
		dname.add(i++,rmap);
		
		rmap = null;
		rmap = new HashMap<>();
		rmap.put("deptno",20);
		rmap.put("dname","운영팀");
		rmap.put("loc","괌");
		dname.add(i++,rmap);
		
		rmap = null;
		rmap = new HashMap<>();
		rmap.put("deptno",30);
		rmap.put("dname","형상관리팀");
		rmap.put("loc","서울");
		dname.add(i++,rmap);
		
		System.out.println(dname);
		
		Gson g = new Gson();
		String imsi = g.toJson(dname);
		System.out.println(imsi);
	}
}