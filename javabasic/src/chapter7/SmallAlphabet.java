//2행 13열의 2차원 배열에 알파벳 26글자를 저장하고 출력하시오.



package chapter7;

public class SmallAlphabet {

	public static void main(String[] args) {
		
		char[][] arr = new char[13][2];
		int ch =97;
		
		
		for(int i=0; i<13; i++) {
			for(int j = 0; j < 2; j++) {
				arr[i][j] = (char)ch;
						// 강제 형 변환
				ch++;
			}// end of inner for loop
		}
			for(int i=0; i<13; i++) {
				for(int j = 0; j < 2; j++) {
				System.out.printf("%2c", (char)arr[i][j]);
			}// end of inner for loop
			System.out.println();
		}
		}
	}

