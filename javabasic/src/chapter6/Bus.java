package chapter6;

public class Bus {
	int busNumber;
	int passengerCount;
	int money;
	// int: 초기값을 따로 주지 않더라도 0으로 시작한다.
	
	public Bus(int busNumber) {
		this.busNumber = busNumber;
	}
	
	public void takeOn(int money) {
		this.money += money;
		this.passengerCount++;
	}
	
	public void takeOff(int money) {
		this.passengerCount--;
	}
	
	public void showInfo() {
		System.out.println(busNumber + "번 버스 손님은" 
				+ passengerCount +  "명이고, 수입은" + money + "원입니다.");
	}
} // end of class Bus
