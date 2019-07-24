package chapter8;

public class Car {
	// 생성자 호출 관계 확인
	// 디폴트 생성자 default constructor
	public Car() {
		System.out.println("Car클래스 생성자 호출!!");
	}
	
	public Car (String name) {
		System.out.println("Car 클래스 생성자 호출 with " + name);
	}
}

/*
 * sub class 가 super class를 호출할 때는 별도의 명시가 없는 한 기본 생성자 호출.
 */
