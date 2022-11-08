package collect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.text.html.parser.Entity;

public class Program {

	public static void main(String[] args) {
		//인터페이스 = new 구현체
		//Set 계열 (중복을 제거하는 컬렉션)
		Set<Integer> set = new HashSet<>();
		set.add(3);
		set.add(3);
		set.add(3);
		
		for(int obj : set)
			System.out.println(obj);
		
		//List 계열 (순서가 키가 되는 컬렉션)
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(3);
		list.add(3);
		
		for(Object obj : list)
			System.out.println(obj);
		
		//Map 계열 (사용자 정의된 키를 가지는 컬렉션)
		Map<String, Integer> map = new HashMap<>();
		map.put("kor", 3);
		map.put("eng", 3);
		map.put("math", 3);
		
		for(Object obj : map.keySet())
			System.out.println(obj);
		
		for(Object obj: map.values())
			System.out.println(obj);
		
//		Note note = new Note();
//		note.id = 1;
//		note.title = "hello";
//		note.hit = 20;
		
		Map<String, Object> note = new HashMap<>();
		note.put("id", 1);
		note.put("title", "hello");
		note.put("hit", 20);
		
		List<Map<String, Object>> noteList = new ArrayList<>();
		noteList.add(note);

		for(Map<String, Object> obj : noteList)
			System.out.println(obj);
		
		
		
//		Object exam = new Exam(1,2,3);
//		
////		Object[] list = new Object[10];
////		
////		list[0] = exam;
////		System.out.println(((Exam) list[0]).total());
//		
////		GList list = new GList();
//		ArrayList list = new ArrayList();
//		list.add(exam);
//		list.add(new Exam(1,1,1));
//		list.add(new Exam(1,1,2));
//		list.add(new Exam(1,2,2));
//		list.add(2);
//		list.add(new Exam(2,2,2));
//		
//		for(Object obj : list)
//			System.out.println(obj);
//		int size = list.size();
//		
////		for(int i=0; i<size; i++)
////			System.out.println(((Exam)list.get(i)).total());
	}

}
