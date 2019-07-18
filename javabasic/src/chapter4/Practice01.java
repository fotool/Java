// 1. 입금
// 2. 출금
// 3. 잔고
// 4. 종료

// 작업번호를 입력해 주세요.
// 종료가 되기 전까지는 계속 실행되어야 함

// 금액, 작업번호

package chapter4;

import java.util.Scanner;

public class Practice01 {

	public static void main(String[] args) {
		// 변수 선언
		Scanner sc = new Scanner(System.in);
		int rest = 100000, money, tnum;
		
		// 입력
		System.out.println("입금 금액을 입력하세요~ :");
		money = sc.nextInt();
		
		// 계산
		tnum = money + rest;
				System.out.println("현재 통장 잔고는 " + (tnum) +"원 입니다.");
				
		
		// 입력
		
		 System.out.println("출금 금액을 입력하세요~ :"); money = sc.nextInt();
		 
		  //계산 
		 tnum = rest - money;
		  
		  if(tnum > 0) { System.out.println("통장잔고는 " + tnum + "원 입니다."); } else if(tnum
		  < 0){ System.out.println("통장 잔고가 부족합니다.");
		  
		  }
	}

}
