// �� ȥ�� �ڵ� p.152
// ���� :40, �̸�: James, ��ȥ, �ڳ�:3��
// ��°�� - ����, �̸�, ��ȥ����, �ڳ��


package classpart;

public class Person {
	String name;
	
	
	public String getPersonName() {
		return name;
	}
	
	public static void main(String[] args) {
		// ������ ����
		Person person = new Person(); //Person class ����
		person.name = "James";
		int age = 40;
		int children = 3;
		boolean isMarried = true;
		// �̸� ���
		System.out.println(person.getPersonName());
		System.out.println("���̴� " + age + "©");
		System.out.println("�ڳ�� " + children + "��");
		if(isMarried)
		System.out.println("��ȥ ���� : " + isMarried);
		
	}// end of main
	
	
}// end of class
