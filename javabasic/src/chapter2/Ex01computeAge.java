package chapter2;

import java.util.Scanner;

public class Ex01computeAge {

	public static void main(String[] args) {
		// 필요한 변수 선언
		Scanner sc = new Scanner(System.in);
		String name ;
		int age, birthYear;
		
		//키보드를 통한 입력
		System.out.println("이름을 입력해 주세요 : ");
		name = sc.next();
		System.out.println("태어난 연도를 입력해 주세요 : ");
		birthYear = sc.nextInt();
		
		// 나이 계산
	    age = 2019 - birthYear;
		
	    // 화면상에 출력
	    System.out.println(name + "님의 나이는" + age + "세 입니다.");
	}

}
