/*
 * A01_IfStatement.java
 * if() 제어문 : 조건식이 맞으면 실행문장1을 실행 후 실행문장2를 실행한다.
 *                   아니면 바로 실행문장2를 실행한다.
 * if(조건식) {
 *   실행문장 1;
 * } 
 * 실행문장 2;
 */
package chapter4;

public class A01_IfStatement {

	public static void main(String[] args) {
		if( 10 < 5) {
			System.out.println("조건이 맞았을 때 실행한 문장");
		}
		System.out.println("조건과 관계없이 실행하는 문장");
	}
}

/*
  제어구문 
  순차적 실행 
  선택제어 
  반복제어
 */

// 1. 변수선언 [고려사항] - data type(정수형, 실수형, 문자형, 불린)
// 2. 문제를 해결하기 위한 절차(순서)대로 프로그램을 작성

// boolean - 관계 연산자, 논리 연산자
