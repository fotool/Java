/*
 * 방정식 4x + 5y = 60의 모든 해를 구하는 프로그램을 작성하시오.
 * 단 x, y는 10이하의 자연수로 한정한다.
 */

package chapter4;

public class PRO08_Equation {

	public static void main(String[] args) {
		
		// 계산
		
		for(int x=1; x<=10; x++) {
			for(int y=1; y<=10; y++) {
				if((4*x+5*y)==60) 
				System.out.println("해 x,y :" + x +", "+y );
			}//end of inner for
			
		}//end of for
		
	}//end of main

}//end of class
