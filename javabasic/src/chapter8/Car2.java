package chapter8;

public class Car2 {
	String color;
	int speed;
	
	public void upSpeed(int speed) {
		this.speed += speed;
	}
	
	public void showInfo() {
		System.out.println(this.color + " , " + this.speed);
	}
}
