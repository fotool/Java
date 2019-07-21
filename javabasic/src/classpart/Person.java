// 나 혼자 코딩 p.152
// 나이 :40, 이름: James, 기혼, 자녀:3명
// 출력결과 - 나이, 이름, 결혼여부, 자녀수


package classpart;

public class Person {
	String name;
	
	
	public String getPersonName() {
		return name;
	}
	
	public static void main(String[] args) {
		// 생성자 생성
		Person person = new Person(); //Person class 생성
		person.name = "James";
		int age = 40;
		int children = 3;
		boolean isMarried = true;
		// 이름 출력
		System.out.println(person.getPersonName());
		System.out.println("나이는 " + age + "짤");
		System.out.println("자녀는 " + children + "명");
		if(isMarried)
		System.out.println("결혼 여부 : " + isMarried);
		
	}// end of main
	
	
}// end of class
