package Array1;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[] {1,2,3,4,5,6,7,8,9,10};
		int sum = 0;
		
		for(int i = 0; i<num.length; i++) {
			sum += num[i];
			System.out.println(sum);
		}
	}

}
