/*
 * A03_IfElseIfElse.java
 * if~else if~else 문
 * if(조건식1){
 * 	 조건식1일 참일 때 실행하는 문장;
 * }else if(조건식2) {
 *   조건식2가 참일 때 실행하는 문장;
 * }else if(조건식n) {
 *   조건식n가 참일 때 싫애하는 문장;
 * }else {
 *   위의 조건이 모두 해당하지 않을 때 수행할 문장
 * }
 */
//가장 빈번한 예 (성적 처리)
package chapter4;

import java.util.Scanner;

public class A03_IfElseIfElse {

	public static void main(String[] args) {
		// 연령에 따른 공원 입장료 계산의 예
		// 점수에 따른 성적 등급 결정의 예
		// 10살이하 1,000
		// 11~20살이하 2,000
		// 21 이상 3,000
		/*
		 * Scanner sc = new Scanner(System.in); int age, fee;
		 * 
		 * System.out.println("나이를 입력하시오. : "); age = sc.nextInt();
		 * 
		 * if(age<=10) { fee = 1000; System.out.println("요금은 "+fee+"원 입니다.");} else
		 * if(age<=20) { fee = 2000; System.out.println("요금은 "+fee+"원 입니다."); } else {
		 * fee = 3000; System.out.println("요금은 "+fee+"원 입니다."); }
		 */
		// 변수 선언
				Scanner sc = new Scanner(System.in);
				int  money1, money2, money3, max;
				
				// 키보드 입력
				System.out.println("숫자를 입력하시오1 :");
				money1 = sc.nextInt();
				System.out.println("숫자를 입력하시오2 :");
				money2 = sc.nextInt();
				System.out.println("숫자를 입력하시오3 :");
				money3 = sc.nextInt();
				
				max = money1;
				if(money2 > max) max = money2;
				if(money3 > max) max = money3;
				
				// 출력
				System.out.println("가장 큰 수는" + max);
	}
}

// 변수는 무조건 왼쪽, 값은 오른쪽