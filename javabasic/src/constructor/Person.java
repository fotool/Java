// p. 153 생성자 만들기
// p. 157 나 혼자 코딩

package constructor;

public class Person {
		String name;
		float height;
		float weight;
		
		// default 생성자 직접 추가
		public Person() {}
		
		// 사람 이름을 매개변수로 입력받아서 Person클래스를 생성하는 생성자
		public Person(String pname) {
			name = pname;
		}
		// 키, 몸무게를 매개변수로 입력받는 생성자
		public Person(float pheight, float pweight) {
			height = pheight;
			weight = pweight;
		}
		
}// end of class
