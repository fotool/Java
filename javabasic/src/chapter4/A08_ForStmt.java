/*
 * 반복문 중 가장 많이 사용하는 반복문
 * 주로 조건이 횟수인 경우에 사용
 * 초기화식, 조건식, 증감식을 한번에 작성한다.
 * 
 * for(초기화식;조건식;증감식){
 *    반복 수행할 문장
 * }
 * 
 * 그외 추가 설명 및 예제
 * - for 루프를 이용한 문자(알파벳, 한글) 출력하기
 * - 무한 루프
 * - for 루프에서 다중 변수 선언하기
 * - 다중 for 루프
 * - continue, break
 */
/*package chapter4;

public class A08_ForStmt {

	public static void main(String[] args) {*/
		// num이 1에서 부터 5일때까지 하나씩 증가하면서 출력하는 for문
		//int i = 1, j=1;
		// 중첩된 반복문 while문 nested while loop
		/*
		 * while (i<=9) { System.out.println(i + "dan"); j = 1; while(j<=9) {
		 * System.out.println(i + "*" + j + "=" + i*j); j++; }// while i++;
		 * System.out.println(); }// while System.out.println("Program terminated");
		 */
		/*
		 * int num =1; while(num<=5) { System.out.println(num); num++; }
		 */
		/*
		 * System.out.println("==============="); for(int num=5;num>=1;num--) {
		 * System.out.println(num); }
		 */
		/*
		 * for(i=1; i<=9; i++) { for(j=1; j<=9; j++) { System.out.println(i + "*" + j +
		 * "=" + i*j); } }// outer for loop
		 */	
	/*for(;;) {
		System.out.println("hello");
	}
	}

}*/
/*
 * package chapter4;
 * 
 * public class A08_ForStmt {
 * 
 * public static void main(String[] args) { for(int i=1, j=1; i<=3; i++, j+=2) {
 * System.out.println(i + " : " + j); } }
 * 
 * }
 */

 package chapter4;
  
 	public class A08_ForStmt {
  
 			public static void main(String[] args) { 
 				for(int i=1; i<=10; i++) {
 				if(i==8) break;
 				if((i % 2) == 0) continue;
 					System.out.println(i); 
 				} 
 				System.out.println("terminated");
 			}
  
  }
 	
// break : 자신을 감싸고 있는 while을 벗어남
// continue : 자신을 감싸고 있는 while을 반복
 