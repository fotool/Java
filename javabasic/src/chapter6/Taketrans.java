package chapter6;

public class Taketrans {

	public static void main(String[] args) {
		// student라는 이름의 생성자를 student class에서 만들었기 때문에 해당 생성자에서 매개변수를 넣지 않으면 오류표시
		                                 // 힙 메모리에 생성되는 부분
		Student studentJames = new Student("James", 5000);
		Student studentTomas = new Student("Tomas", 10000);
		Bus bus100 = new Bus(100);
		Subway subwayGreen = new Subway("2호선");
		
		                 //바로 위 줄에서 생성한 생성자의 변수명이 들어가야 함.
		studentJames.takeOnBus(bus100);
		studentJames.showInfo();
		bus100.showInfo();
		
		studentTomas.takeOnBus(bus100);
		studentTomas.showInfo();
		bus100.showInfo();
		
		studentJames.takeOffBus(bus100);
		studentJames.showInfo();
		bus100.showInfo();
		
		studentJames.takeSubway(subwayGreen);
		studentJames.showInfo();
		subwayGreen.showInfo();
		
	}

}