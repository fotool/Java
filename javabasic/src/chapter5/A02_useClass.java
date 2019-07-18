/*
 * 클래스의 생성자constructor
 */

package chapter5;

public class A02_useClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Student st1 = new Student(); Student st2 = new Student("홍길동"); Student st3 =
		 * new Student(1, "박문수", 4, "컴퓨터과", "청원구"); st1.study(); st2.study();
		 * st3.study(); st3.showInfo();
		 */
		/*
		 * Student st1 = new Student(); st1.setname ( "홍길동"); st1.id = 1; st1.address =
		 * "청주시 청원구"; //System.out.println(st1.getname); System.out.println(st1.id);
		 * System.out.println(st1.address);
		 */
		
		InfoHiding info = new InfoHiding();
		//info.id = 1;
		//System.out.println(info.id);
		info.setId(1);
		System.out.println(info.getId());
	}

}
