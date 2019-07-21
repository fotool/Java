package chapter6;

public class Student {
	public static int serialNum = 1000;
	public int studentID;
	public String StudentName;
	public int grade;
	public int money;
	public String address;
	
	// 이름과 가진 돈을 매개변수로 받는 생성자
	public Student(String studentName, int money) {
		this.studentID = ++serialNum;
		this.StudentName = studentName;
		this.money = money;
	}
	                   //Bus: 클래스 이름, bus:parameter
	public void takeOnBus(Bus bus) {
    // void : 어떤 타입이든 상관 없음
		bus.takeOn(1000);
		this.money -= 1000;
	}
	
	public void takeOffBus(Bus bus) {
		
	}
	    // void : 어떤 타입이든 상관 없음
			
	
	public void takeSubway(Subway subway) {
		subway.take(1500);
		this.money -= 1500;
	}
	
	public void showInfo() {
		System.out.println(studentID);
	                //생성자명이어야 함(Left Value)
	}
	
	public static void showSerial() {
		System.out.println(serialNum);
	}
	
}//end of class Student