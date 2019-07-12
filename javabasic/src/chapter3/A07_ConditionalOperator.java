/*
 * A07_ConditionalOperator
 * 조건연산자
 * 조건식?결과1:결과2;  조건식이 참이면 결과1 조건식이 거짓이면 결과2가 선택됨. 
 */
/*
 * package chapter3;
 * 
 * public class A07_ConditionalOperator {
 * 
 * public static void main(String[] args) { int result; result = (10 < 5)?
 * 100:999 ; // 삼항 연산자 System.out.println(result); }
 * 
 * }
 */

package chapter3;

import java.util.Scanner;

public class A07_ConditionalOperator {
	
	public static void main(String[] args) {
		// 변수 선언
		Scanner sc = new Scanner(System.in);
		int father, mother;
		String older;
		
		// 키보드 입력
		System.out.println("아버지의 나이는? : ");
		father = sc.nextInt();
		System.out.println("어머니의 나이는? : ");
		mother = sc.nextInt();
		
		// 나이 계산
		older = (father > mother) ? "아버지":"어머니";
		
		// 출력
		System.out.println("두분 중에서 나이가 더 많으신 분은? " + older);
		
		
	}// end of main
}// end of class