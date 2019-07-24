//나 혼자 코딩 p. 190

package staticex;

public class StudentTest6 {

	public static void main(String[] args) {
		Student3 studentKim = new Student3();
		studentKim.setStudentName("김김김");
		System.out.println(Student3.getSerialNum());
		System.out.println(studentKim.studentName + " 카드번호:" + studentKim.studentCardID);
		
		Student3 studentWang = new Student3();
		studentWang.setStudentName("왕왕왕");
		System.out.println(Student3.getSerialNum());
		System.out.println(studentWang.studentName + " 카드번호:" + studentKim.studentCardID);

	}

}
