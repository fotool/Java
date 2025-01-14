// 은행업무 프로그램
// 선택메뉴
// 1.입금  2.출금  3.잔고조회  4.종료
// 입금 선택 시 계좌잔고 메시지 출력
// 출금 시 잔고조회로 연결
//  - 잔액 부족 시 "잔고부족" 메시지 출력
// 1~4 이외의 번호 선택 시
// - "다시 선택해 주세요" 메시지 출력
package practice;

import java.util.Scanner;

public class Practice6 {

	
	public static void main(String[] args) {
		// 변수 선언
		Scanner kbd = new Scanner(System.in);
		int num=0, balance = 100000, workMoney;
		
		// 입력 & 출력
		do {
		System.out.println("1.입금  2.출금  3.잔고조회  4.종료");
		System.out.println("번호를 입력! : ");
		num = kbd.nextInt();
		
		switch(num){
			case 1:
				System.out.println("얼마 넣으실 건가요? : ");
				workMoney = kbd.nextInt();
				System.out.println("계좌 잔액은 " + (workMoney + balance)+ "원 입니다~");
				break;
			case 2:
				System.out.println("진짜? : ");
				workMoney = kbd.nextInt();
				if(workMoney <= balance) balance -= workMoney;
				else  
					System.out.println("안 돼!");
			case 3:
				System.out.println("남은 잔액은" + balance + "원 입니다~");
				break;
			case 4:
				System.out.println("프로그램 종료~!");
				break;		
				default:
					System.out.println("다시 선택해 주세요~");				
		}// end of switch			
		}// end of do
		while(num !=4);
	}// end of main
}// end of class

// * 함수명은 소문자로 시작
