/*
 * A08_BitOperator
 * 비트 논리 연산자 : &, |, ^, ~
 * 비트 이동 연산자(시프트연산자) : <<, >>, >>>  
 */
/*
 * package chapter3;
 * 
 * public class A08_BitOperator {
 * 
 * public static void main(String[] args) { // TODO Auto-generated method stub
 * //int number = 5; // int number = 0b101; // 이진 숫자 표현 // int number = 012; //
 * 8진수 // int number = 0xA; // 16진수 double number = 10.123;
 * //System.out.println(number); System.out.printf("%010.2f", number); // 16진수로
 * 출력 } }
 */

// %[-][0][m][.n]_
// _: d 십진정수     - 왼쪽정렬 빈칸 공백으로 채워서 출력
//    b boolean  0 오른쪽정렬 빈칸 0으로 채워서 출력
//    o 8진수         m 전체자릿수
//    x 16진수       .n 소수점이하 자릿수
//    e 지수형
//	  c 문자
//	  s 문자열
//    f 문자열
package chapter3;

public class A08_BitOperator {
	
	public static void main(String[] args) {
//		byte num1 = 0b00001101;
//		byte num2 = 0b00001010;
		
//		int result = num1 ^ num2;
//		int result = ~num1;
		
//		System.out.println(result);
		int num3 = 10;
		int result = num3 >> 3;
		System.out.println(result);
	}
}