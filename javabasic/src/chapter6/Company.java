package chapter6;

public class Company {
	// private 생성자를 만든다.
	private static Company instance = new Company();
	private Company() {		
	}
	
	public static Company getInstance() {
		if(instance == null) {
			instance = new Company();
		}
		return instance;
	}
}
