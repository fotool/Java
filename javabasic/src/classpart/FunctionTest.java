// p. 138 나 혼자 코딩

package classpart;

public class FunctionTest {

	public static void main(String[] args) {
		int num1 = 30;
		int num2 = 10;
		
		int sum = add(num1, num2);
		System.out.println(num1 + "+" + num2 + "=" + sum + "입니다");
		int minus = ded(num1, num2);
		System.out.println(num1 + "-" + num2 + "=" + minus + "입니다");
		int multiple = mul(num1, num2);
		System.out.println(num1 + "*" + num2 + "=" + multiple + "입니다");
		int divide = div(num1, num2);
		System.out.println(num1 + "/" + num2 + "=" + divide + "입니다");
	}// end of main
	
	           // int: 함수 반환형  add: 함수 이름 (int n1, int n2): 매개변수 
	public static int add(int n1, int n2) {
		int result = n1 + n2;
	 // return : 예약어
		return result;
	}// end of add
	
	public static int ded(int n1, int n2) {
		int result = n1 - n2;
		return result;
	}// end of ded
	
	public static int mul(int n1, int n2) {
		int result = n1*n2;
		return result;
	}// end of mul
	
	public static int div(int n1, int n2) {
		int result = n1/n2;
		return result;
	}// end of div
	
}// end of class

/*
 * output
 * 
 * 30+10=40입니다
 * 30-10=20입니다
 * 30*10=300입니다
 * 30/10=3입니다 
*/