// p.123 연습문제 1

package practice;

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		int num1 ,num2;
		String operator;
		Scanner kbd = new Scanner(System.in);
		
		System.out.println("숫자 1을 입력 하시오 : ");
		num1 = kbd.nextInt();
		System.out.println("숫자 2를 입력 하시오 : ");
		num2 = kbd.nextInt();
		System.out.println("연산의 종류");
		operator = kbd.next();
		
		switch(operator) {
		case "+":
			System.out.println(num1 + "+" + num2 + "=" + (num1+num2) );
			break;
		case "-":
			System.out.println(num1 + "-" + num2 + "=" + (num1-num2));
			break;
		case "*":
			System.out.println(num1 + "*" + num2 + "=" + (num1*num2));
			break;
		case "/":
			System.out.println(num1 + "/" + num2 + "=" + (num1/num2));
		}
		
	}

}