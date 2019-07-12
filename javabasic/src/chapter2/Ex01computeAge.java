package chapter2;

import java.util.Scanner;

public class Ex01computeAge {

	public static void main(String[] args) {
		// 필요한 변수 선언
		Scanner sc = new Scanner(System.in);
      // 클래스    객체 = 시스템이 입력을 받을 수 있는 새로운 Scanner
		String name ;
	  // 클래스    객체
		int age, birthYear;
	  //타입   변수,   변수
		
		//키보드를 통한 입력
		System.out.println("이름을 입력해 주세요 : ");
		name = sc.next();
	  // 변수 = 객체.메서드
		System.out.println("태어난 연도를 입력해 주세요 : ");
		birthYear = sc.nextInt();
	  //    변수     = 객체.메서드
		
		// 나이 계산
	    age = 2019 - birthYear;
		
	    // 화면상에 출력
	    System.out.println(name + "님의 나이는" + age + "세 입니다.");
	}

}

// 클래스를 만들고 사용하기 위해서는 반드시 해당 클래스에 대한 객체를 생성 해주어야 한다.
// Scanner - 클래스, 정수, 실수, 문자열을 읽어올 수 있다.
		 //- 사용자에게 입력 장치로 입력을 받아 그 값을 변수에 저장하는 역할을 함.
// import java.util.Scanner - Scanner를 사용하기 위해 외부 클래스 호출
// 클래스 - 유사한 특징을 지닌 객체들의 속성을 묶어 놓은 집합체
// ex) 클래스 : 학생
     //객체 : 김동수, 이영희, 안준영 등등
// 변수: 값을 저장할 수 있는 메모리 공간
// 값을 넣어주는 것 : 대입연산자
// 개행문자 : 줄바꿈 문자, 행을 바꿈(고칠 개, 갈 행)
// next() : 개행문자, 공백은 무시하고 문자를 입력받음
// nextInt - int를 입력 받을 때 사용
// 메소드 : 입력값이 있고, 그 입력값을 받아서 무언가 한 다음 결과를 도출해 내는 수학의 함수와 비슷한 개념.
// 메소드 : 클래스가 가지고 있는 기능, 클래스 안에 선언됨
// 메소드 입력값 : 매개변수, 결과값 : 리턴값
// ex) 필드 : 물체의 상태, 메소드: 물체의 행동
// boolean : true, false