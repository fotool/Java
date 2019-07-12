/*
 * A03_RelationalOperator.java
 * 1. 관계 연산자의 종류
 * > : 왼쪽 항이 크면 참을, 아니면 거짓을 반환한다.
 * < :
 * >= : 
 * <= :
 * == : 두 항의 값이 같으면 참, 아니면 거짓을 반환한다.
 * != : 두 항의 값이 다르면 참, 아니면 거짓을 반환한다.
 */
package chapter3;

import java.util.Scanner;

public class A03_RelationalOperator {

	public static void main(String[] args) {
		// 생년을 입력 받아  성년(19세 이상) 여부를 판단하라.
		// 필요한 변수 선언 
		// 관계연산의 결과는 참 또는 거짓의 boolean type이다.
		Scanner kbd = new Scanner(System.in);
		int age, birthYear;
		boolean isAdult;
		
		// 생년 입력 요구 메시지 출력
		System.out.println("생년 : ");
		// 생년 입력
		birthYear = kbd.nextInt();
		// 나이계산 및 성년 여부 판단
		age = 2019 - birthYear;
		isAdult = age >= 19;
		
		// 처리 결과를 출력
		System.out.println(birthYear + "생은 성년? " + isAdult);
	}
}

// 프로그래밍 순서 (변수선언 -> 입력 -> 처리 -> 출력) !!!!!!
// 변수 선언
// 데이터 타입 -> 변수이름(자유롭게 정할 수 있음, 제한사항 지킬 것)
// 프로그램에는 정답이 없음 (ex. 서울 가는 방법 찾기)
// 코드 최적화 (code optimization)

