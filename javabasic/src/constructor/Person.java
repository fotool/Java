// p. 153 ������ �����
// p. 157 �� ȥ�� �ڵ�

package constructor;

public class Person {
		String name;
		float height;
		float weight;
		
		// default ������ ���� �߰�
		public Person() {}
		
		// ��� �̸��� �Ű������� �Է¹޾Ƽ� PersonŬ������ �����ϴ� ������
		public Person(String pname) {
			name = pname;
		}
		// Ű, �����Ը� �Ű������� �Է¹޴� ������
		public Person(float pheight, float pweight) {
			height = pheight;
			weight = pweight;
		}
		
}// end of class
