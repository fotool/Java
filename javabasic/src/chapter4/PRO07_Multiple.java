/*
 *  사용자가 단을 입력하면 해당 단의 구구단을 출력하는 프로그램을 작성하시오.
 *  단, 0을 입력하면 프로그램을 종료하시오.
 */
package chapter4;

import java.util.Scanner;

public class PRO07_Multiple {

	public static void main(String[] args) {
		/*
		 * // 변수 선언 Scanner sc = new Scanner(System.in); int dan; int times;
		 * 
		 * do { // 키보드 입력 System.out.println("단을 입력하시오 : "); dan = sc.nextInt(); if( dan
		 * ==0) { break; } for(times =1; times <=10; times++) { { System.out.println(dan
		 * + "*" + times + "=" + dan*times); continue; }
		 * 
		 * } }// end of do while (dan != 0); { System.out.println("프로그램을 종료합니다."); }
		 */
		
		// 필요 변수 선언
		int dan = 3;
		Scanner kbd = new Scanner(System.in);
		
		while (dan !=0) {
			System.out.println("몇 단?? >> ");
			dan = kbd.nextInt();
			if(dan ==0) break;
			for(int times=1; times<=9; times++) {
				System.out.println(dan + "*" + times + "=" + (dan*times));
			}// end of for
		}// end of while
		
		System.out.println("프로그램 종료");
	}

}
