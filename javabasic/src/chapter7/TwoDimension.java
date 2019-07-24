package chapter7;

public class TwoDimension {

	public static void main(String[] args) {
		// 2차원 배열 선언
//		int[][] arr = new int[2][3];
		int[][] arry = {{1,2,3}, {4,5,6}}; // 2행 3열
		
		for(int i=0; i<arry.length; i++) {
			for(int j=0; j<arry[i].length;j++) {
				System.out.printf("%3d", arry[i][j]);
			}
			System.out.println();// 행 출력 끝난 후 한 줄 띄움.
		}//outer loop by i
		System.out.println("2차원배열의 개념 확인!!");
	}

}

// 배열이름.length - 배열의 크기(1차원 배열에 한정)
