// p.144 코딩해 보세요!

package classpart;

public class Student {
	int studentID;
	String studentName;
	int grade;
	String address;
		
	public String getStudentName() {
	return studentName;
	}//end of String
		
	public static void main(String[] args) {
			Student studentAhn = new Student(); // Student 클래스 생성
			studentAhn.studentName = "안연수";
			
			System.out.println(studentAhn.studentName);
			System.out.println(studentAhn.getStudentName());

		}// end of main
		
		
	}// end of class Student

