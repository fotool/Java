package chapter2;

import java.util.Scanner;
// import : 기본 package 이외에 별도의 package 에 저장되어 있는 클래스 가져 오는 것
public class Ex02RectangleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 변수 선언
		Scanner sc = new Scanner(System.in);
  // Scanner 참조형 데이터 타입
		double width, length, area;
	  // 실수 : 컴퓨터에서 사용되는 수 중에서 소수점이 붙어 있는 형태의 수
		
		// 키보드 입력
		System.out.println("가로 길이는? : ");
	  // 출력 역할
		width = sc.nextDouble();
	  // 입력 역할
		System.out.println("세로 길이는? : ");
		length = sc.nextDouble();
		
		//계산
		area = width*length;
		
		//출력
		System.out.println("사각형의 넓이는 "+area+"입니다.");
	}//end of main()

}//end of class

// 작성하는 프로그램의 시작점은 main 함수. 단 한개만 있어야 함.
// byte -> short, char -> int -> long -> float -> double
// ' 사용 : character type
// " 사용 : 문자