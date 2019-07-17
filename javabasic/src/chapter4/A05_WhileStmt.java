/*
 *	while 반복 구문
 *	while(조건식) {
 *      반복수행할 문장;
 *  } 
 *  
 *  조건식이 참인 동안 블록내 문장을 반복실행한다.
 */
package chapter4;

public class A05_WhileStmt {

	public static void main(String[] args) {
		// 1 ~ 10까지의 합계를 구하는 프로그램을 while문을 이용하여 작성해보자.
		// 먼저, 필요한 변수를 선언하고
		
		
		// 숫자가 1부터 10까지 변하는 동안 숫자의 누계를 구한 후
		
		// 결과를 출력한다.
		
		// 1부터 5까지의 수를 출력하는 프로그램을 작성하시오.
		/*
		 * int num =1;
		 * 
		 * System.out.println(num); num++; System.out.println(num); num++;
		 * System.out.println(num); num++; System.out.println(num); num++;
		 * System.out.println(num); num++;
		 */
		// 위 프로그램을 반복문을 사용하여 작성하면....
		/*
		 * int num = 1; while(num<=10000) { System.out.println(num); num++; }
		 */
		
		// 1-100까지의 수에서 홀수, 짝수의 합을 구하시오.
		//Pseudo code
		// 1. 필요한 변수 선언
		// 2. 숫자가 100보다 작은지 확인
		//   2.1 숫자가 홀수이면 홀수의 합
		//   2.2 짝수이면 짝수의 합이
		//   2.3 숫자를 증가시킨다.
		// 3. 홀수의 합계 출력
		// 4. 짝수의 합계 출력
		
		// 변수 선언
		/*
		 * int num =1 , oddsum = 0, evensum = 0; while(num<=100) { if((num % 2) == 0)
		 * evensum += num; else oddsum += num; num ++; }// end of while
		 * 
		 * System.out.println("oddsum :" + oddsum); System.out.println("evensum :" +
		 * evensum);
		 */
		
	}

}