package chapter11;

class Student{
	
	int studentId;
	String studentName;
	
	public Student(int studentId, String studentName){
		this.studentId = studentId;
		this.studentName = studentName;
	}
	
	public String toString(){
		return studentId + "," + studentName;
	}

	@Override  // equals()메서드 재정의
	public boolean equals(Object obj) {
		if(obj instanceof Student){
			Student std = (Student)obj;
			if(this.studentId == std.studentId) //재정의한 equals()
				return true;				//메서드는 학생의
			else return false;				//학번이 같은면
		}									//true 반환
		return false;
	}

	
	 @Override public int hashCode() { 
		 return studentId;
		 }
	 
	
}

public class EqualsTest {

	public static void main(String[] args) {

		Student studentLee = new Student(100, "이상원");
		Student studentLee2 = studentLee; // 주소복사
		Student studentSang = new Student(100, "이상원");
		studentLee.hashCode();
		String str1="korea";
		int n1 = 1;
		str1.hashCode();
	
		// 동일한 주소의 두 인스턴스 비교
		if(studentLee == studentLee2)
			System.out.println("studentLee와 studentLee2의 주소는 같습니다.");
		else
			System.out.println("studentLee와 studentLee2의 주소는 다릅니다.");
		if(studentLee.equals(studentLee2))
			System.out.println("studentLee와 studentLee2는 동일합니다.");
		else
			System.out.println("studentLee와 studentLee2는 동일하지 않습니다.");
		
		//주소는 다르지만 equals 의 결과가 true 인 경우
		if(studentLee == studentSang)
			System.out.println("studentLee와 studentSang의 주소는 같습니다.");
		else
			System.out.println("studentLee와 studentSang의 주소는 다릅니다.");
		if(studentLee.equals(studentSang))
			System.out.println("studentLee와 studentSang은 동일합니다.");
		else
			System.out.println("studentLee와 studentSang은 동일하지 않습니다.");

		System.out.println("studentLee의 hashCode :" +studentLee.hashCode());
		System.out.println("studentSang의 hashCode :" +studentSang.hashCode());
		
		System.out.println("studentLee의 실제 주소값 :"+ System.identityHashCode(studentLee));
		System.out.println("studentSang의 실제 주소값 :"+ System.identityHashCode(studentSang));
	
	}
}