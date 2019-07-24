//나혼자 코딩 p.190

package staticex;
	
public class Student3 {
	private static int serialNum = 1000;
	int studentID;
	String studentName;
	int grade;
	String address;
	int studentCardID;
	
	public Student3() {
		serialNum++;
		studentCardID = serialNum + 100;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String name) {
		studentName = name;
	}
	public static int getSerialNum() {
		int i = 10;
		return serialNum;
	}
	public static void setSerialNum(int serialNum) {
		Student3.serialNum = serialNum;
	}


}
