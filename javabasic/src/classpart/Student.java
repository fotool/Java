// p.144 �ڵ��� ������!

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
			Student studentAhn = new Student(); // Student Ŭ���� ����
			studentAhn.studentName = "�ȿ���";
			
			System.out.println(studentAhn.studentName);
			System.out.println(studentAhn.getStudentName());

		}// end of main
		
		
	}// end of class Student

