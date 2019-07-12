/*
 * A02_IncrementOperator.java
 * 1. 증가연산자와 감소연산자
 * ++ 항의 값에 1을 더한다.
 * -- 항의 값에서 1을 뺀다.
 * 
 * 2. 위치에 따른 의미 차이를 분명히 알아야 한다.
 * int val = 10 일 때
 * int num = ++value 문장과    
 * int num = value++ 문장은 다른 결과를 가진다. 
 */
package chapter3;

public class A02_IncrementOperator {

	public static void main(String[] args) {
		int A = 10;
		int B = ++A;
		System.out.println("A: " + A);
		System.out.println("B: " + B);

	}

}

// 증감 연산자는 단항 연산자.
// B = A++;
// '=' 먼저 계산 (1)
// 'A' (2)
// '++' 그 다음 계산(3)

// B = ++A;
// '=' 먼저 계산 (1)
// '++' (2)
// 'A'(3)
