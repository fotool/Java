/*
 * do {
 *   반복실행할 문장
 * }while(조건식)
 * 
 * 반복 조건 체크를 뒤에서 한다. 수행문을 반드시 한번을 실행해야 할 경우 사용한다.
 */
package chapter4;

public class A06_DoWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 6;
		do {
			System.out.println(num);
			num++;
		}
		while (num <=5); {
			System.out.println("Program end....");
			num++;
		}
		
	}

}