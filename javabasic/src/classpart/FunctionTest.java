// p. 138 �� ȥ�� �ڵ�

package classpart;

public class FunctionTest {

	public static void main(String[] args) {
		int num1 = 30;
		int num2 = 10;
		
		int sum = add(num1, num2);
		System.out.println(num1 + "+" + num2 + "=" + sum + "�Դϴ�");
		int minus = ded(num1, num2);
		System.out.println(num1 + "-" + num2 + "=" + minus + "�Դϴ�");
		int multiple = mul(num1, num2);
		System.out.println(num1 + "*" + num2 + "=" + multiple + "�Դϴ�");
		int divide = div(num1, num2);
		System.out.println(num1 + "/" + num2 + "=" + divide + "�Դϴ�");
	}// end of main
	
	           // int: �Լ� ��ȯ��  add: �Լ� �̸� (int n1, int n2): �Ű����� 
	public static int add(int n1, int n2) {
		int result = n1 + n2;
	 // return : �����
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
 * 30+10=40�Դϴ�
 * 30-10=20�Դϴ�
 * 30*10=300�Դϴ�
 * 30/10=3�Դϴ� 
*/