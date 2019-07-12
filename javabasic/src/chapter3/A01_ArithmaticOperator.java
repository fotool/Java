/*
 * A01_ArithmaticOperator.java
 * 1. 산술연산자 종류
 * + : 두 합을 더한다.
 * - : 앞에 있는 항에서 뒤에 있는 항을 뺀다.
 * * : 두 항을 곱한다.
 *  / : 앞에 있는 항을 뒤에 있는 항으로 나누어 몫을 구한다.
 *  % : 앞에 있는 항을 뒤에 있는 항으로 나누어 나머지를 구한다.
 *  
 *  2. 우선순위 
 *  일반 수학의 산술 연산과 같다. 
 *  즉  *, /,%   >  +, -
 */

//산술 연산자를 사용하여 수학, 영어 점수의 합계와 평균을 구하는 프로그램의 예제.
package chapter3;

import java.util.Scanner;

public class A01_ArithmaticOperator {

	public static void main(String[] args) {
		// 필요한 변수를 선언한다.
		// 국어, 수학, 영어, 총점, 평균을 위한 변수
		Scanner kbd = new Scanner(System.in);
		int kor, math, eng, tot;
		double avg;
		String name;
		
		// 입력 받는다.
		System.out.println("이름 : ");
		name = kbd.next();
		System.out.println("국어 : ");
		kor = kbd.nextInt();
		System.out.println("수학 : ");
		math = kbd.nextInt();
		System.out.println("영어 : ");
		eng = kbd.nextInt();
		
		// 총점을 계산한다.
		tot = kor + eng + math;
		
		// 평균을 계산한다.
		avg = tot / 3.0;
		
		
		// 계산된 총점과 평균을 출력한다.
		System.out.println(tot + ", " + avg);
		
	}// end of main()
}// end of class

// 클래스의 이름과 파일명이 같아야 함.
/*
// 변수 선언
Scanner sc = new Scanner(System.in);
Double sum, avg, p1, p2, p3;
String name;

// 키보드 입력
// 출력구문
System.out.println("이름 : ");
// 입력구문
name = sc.next();
// 출력구문
System.out.println("국어 점수 : ");
// 입력구문
p1 = sc.nextDouble();
// 출력구문
System.out.println("수학 점수 : ");
// 입력구문
p2 = sc.nextDouble();
// 출력구문
System.out.println("영어 점수 : ");
// 입력구문
p3 = sc.nextDouble();

// 계산
sum =  p1 + p2 + p3;
avg = (p1 + p2 + p3)/3;

// 출력
System.out.println(name + "님의 국어, 수학, 영어의 총점은 " + sum + "점이고, 평균은 " + avg + "점입니다.");
*/

// 파일명(class 명) 변경
// 파일위에 커서 두고 오른쪽 버튼 클릭 -> refactor -> rename



