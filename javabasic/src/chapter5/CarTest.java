package chapter5;

public class CarTest {

	public static void main(String[] args) {
		Car eungiCar = new Car();
		System.out.println(eungiCar);
		
		Car c = eungiCar.returnItself();
		System.out.println(c);
		
		
		
		//Car ellenCar = new Car();
		/*
		 * eungiCar.showInfo();
		 * 
		 * Car ellenCar = new Car("핑크", "디젤", "인조가죽"); ellenCar.showInfo();
		 * 
		 * ellenCar.setColor("빨강"); ellenCar.showInfo();
		 */
		//eungiCar.color = "실버";
		// eungiCar.speed=0;
		/*
		 * eungiCar.setSpeed(0); eungiCar.showInfo();
		 * 
		 * eungiCar.upSpeed(60); eungiCar.showInfo();
		 * 
		 * eungiCar.upSpeed(500); eungiCar.showInfo();
		 * 
		 * eungiCar.downSpeed(200); eungiCar.showInfo();
		 * 
		 * eungiCar.downSpeed(30); eungiCar.showInfo();
		 */
		
		
		// System.out.println(eungiCar); // 생성주소 확인 
		// System.out.println(ellenCar); // 생성주소 확인
				
	}// end of main

}// end of class CarTest
