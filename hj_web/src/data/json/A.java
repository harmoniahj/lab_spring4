package data.json;

import java.util.ArrayList;
import java.util.List;

public class A {
	public static void main(String[] args) {
		List<String> dname = new ArrayList<>();
		int i = 0;
		dname.add(i++, "개발1팀");
		dname.add(i++, "형상관리팀");
		dname.add(i++, "운영팀");
		System.out.println(dname);
	}
}