package chapter04;

public class ObjectTest03 {

	public static void main(String[] args) {
		
		//new 하면 무조건 힙에 생성
		String s1 = new String("hello");
		String s2 = new String("hello");
		
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		
		System.out.println(s1.hashCode() + ":" +s2.hashCode());
		System.out.println(System.identityHashCode(s1) + ":" + System.identityHashCode(s2));

		System.out.println("======================================================");
		
		// constants pool에서 해시값으로 레퍼런스주소 찾아서 쓴다 , 리터럴로쓰면 같은값은 공유해서 쓸 수 있다. => 리터럴로 쓰는게 좋음 
		String s3 = "hello";
		String s4 = "hello";
		
		System.out.println(s3==s4);
		System.out.println(s3.equals(s4));
		
		System.out.println(s3.hashCode() + ":" +s4.hashCode());
		System.out.println(System.identityHashCode(s3) + ":" + System.identityHashCode(s4));

		
	}
}
