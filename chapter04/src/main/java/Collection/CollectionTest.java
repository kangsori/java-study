package Collection;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class CollectionTest {

	public static void main(String[] args) {
		List<String> list01 = new ArrayList();
		List<String> list02 = new LinkedList<>();
		
		list01.add("둘리");
		list01.add("마이콜");
		list01.add("도우너");
		
		list01.add(0,null);
		list01.remove(1);
		
		list01.set(2, "바보");
		list01.add(3, "멍청이");
	
		
		list02.add("둘리");
		list02.add("마이콜");
		list02.add("도우너");
		
		list02.add(0,null);
		
		list02.set(2, "바보");
		
		System.out.println(list01);
		System.out.println(list02);
		
		
		Vector<String> v= new Vector<>();
		
		v.add("둘리");
		v.add("마이콜");
		v.add("도우너");
		v.add(2, "바보");

		// 순회1
		for(int i=0; i<v.size();i++) {
			String s = v.get(i);
			System.out.println(s);
		}
		
		v.set(1, "소리");
		// 삭제
		v.remove(0);
		//v.removeAll(v);
		//v.removeAllElements();
		System.out.println(v);
		
//		// 순회2
//		Enumeration<String> e = v.elements();
//		while(e.hasMoreElements()) {
//			String s = e.nextElement();
//			System.out.println(s);
//		}
		
		

	}

}
