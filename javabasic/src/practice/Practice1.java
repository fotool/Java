// p.123 연습문제 1

package practice;

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		// 변수선언
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		String operator;
		
		// 키보드 입력
		System.out.println("숫자 1을 입력하시오 : ");
		num1 = sc.nextInt();
		System.out.println("숫자 2를 입력하시오 : ");
		num2 = sc.nextInt();
		System.out.println("연산자를 입력하시오 : ");
		operator = sc.next();
		
		// 출력
		switch(operator) {
		case ("+"):
			System.out.println(num1 + "+" + num2 + "=" + (num1+num2));
			break;
		case ("-"):
			System.out.println(num1 + "-" + num2 + "=" + (num1-num2));
			break;
		case ("*"):
			System.out.println(num1 + "*" + num2 + "=" + (num1*num2));
			break;
		case ("/"):
			System.out.println(num1 + "/" + num2 + "=" + (num1/num2));
		}// end of switch
	}// end of main
}// end of class
