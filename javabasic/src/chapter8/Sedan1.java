package chapter8;

public class Sedan1 extends Car1 {
	//field
	//color, speed 는 Car1에서 상속된 것....
	
	public void setSpeed(int speed) {
//		super.speed = speed;
	}
	
	public void setColor(String color) {
		super.setColor(color);
	}
	
	public void getColor(String color) {
//		super.getColor(color);
	}
}
