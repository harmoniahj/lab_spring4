package data.json;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import data.vo.DeptVO;

public class A2 {
	public static void main(String[] args) {
		List<DeptVO> dname = new ArrayList<>();
		int i = 0;
		DeptVO dvo = new DeptVO();
		dvo.setDeptno(10);
		dvo.setDname("개발1팀");
		dvo.setLoc("제주");
		dname.add(i++, dvo);
		
		dvo = null;
		dvo = new DeptVO();
		dvo.setDeptno(20);
		dvo.setDname("운영팀");
		dvo.setLoc("괌");
		dname.add(i++, dvo);
		
		dvo = null;
		dvo = new DeptVO();
		dvo.setDeptno(30);
		dvo.setDname("형상관리팀");
		dvo.setLoc("서울");
		dname.add(i++, dvo);
		
	//	System.out.println(dname);
	//	System.out.println(dname.size());
		Gson g = new Gson();
		String imsi = g.toJson(dname);
		System.out.println(imsi);
	}
}