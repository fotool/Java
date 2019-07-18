// p.123 연습문제 3번

package practice;

public class Practice3 {

	public static void main(String[] args) {
		
		// 변수선언
		int dan, times;
		
		// 계산, 출력
		for(dan=1; dan<=9; dan++) {
			
			for(times=1; times<=9; times++) {
				if(dan < times) break;
				System.out.println(dan + "X" + times + "=" + (dan*times));
			}// end of inner for
			System.out.println();
		}// end of for
		
	}// end of main

}// end of class


// *if구문 사용하기 전에는 기존에 선언된 변수가 반드시 먼저 나와야 한다.
