/*
 *  사용자가 단을 입력하면 해당 단의 구구단을 출력하는 프로그램을 작성하시오.
 *  단, 0을 입력하면 프로그램을 종료하시오.
 */
package practice;

import java.util.Scanner;

public class Practice7 {

	public static void main(String[] args) {
		// 변수 선언
		Scanner kbd = new Scanner(System.in);
		int dan=1, times;
		
		// 계산 & 출력
		while (dan !=0) {
			// 단 입력
			System.out.println("단을 입력하삼~ : ");
			dan = kbd.nextInt();
			if(dan == 0) break; 
			for(times=1; times<=9; times++)
			System.out.println(dan + "X" + times + "=" + (dan*times));
			
		}// end of while
		System.out.println("Bye bye~");
	}// end of main

}// end of class
