/*데이터 타입
기본 자료형, 참조 자료형
기본자료형은 정수형, 문자형, 실수형, 논리형
정수형 : byte 1byte, short 2byte, int 4byte, long 8byte
문자형 : char 1byte
실수형 : float 4byte, double 4byte
논리형 : boolean
*/

package chapter2;

public class A02_Character {

	public static void main(String[] args) {
		// byte의 유효숫자 범위는 -2^7 ~ 2^7-1		
		byte b_num1 = 127;
		System.out.println(b_num1);
		
		// short의 유효숫자 범위는 -2^15 ~ 2^15-1
		// -32768 ~ 32767	
		System.out.println(Short.MIN_VALUE);
		System.out.println(Short.MAX_VALUE);
		
		// int의 유효숫자 범위는 -2^31 ~ 2^31-1
		// -2,147,483,648 ~ 2,147,483,647		
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		
		// long의 유효숫자 범위 -2^63 ~ 2^63-1
		
		short sval = 1;
		int ival = 1;
		double fval = 1.0;
		
		// 서로 다른 data type을 혼합 연산할 때
		// 연산 결과는 범위가 큰 쪽으로 변환되어 처리된다.
		System.out.println("short형과 int형의 혼합연산" + sval + ival);
		System.out.println(ival + fval);
		
		char ch1 = 'A';
		System.out.println(ch1);
		System.out.println((int)ch1);
		
		int ch2 = 66;
		System.out.println(ch2);
		System.out.println((char)ch2);
		
		char ch3 = '\u1100';
		System.out.println(ch3);
		System.out.println((int)ch3);
		
		
		
		
	}
}
