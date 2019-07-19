package chapter6;

public class Subway {
	String LineNumber;
	int passengerCount;
	int money;
	// int: 초기값을 따로 주지 않더라도 0으로 시작한다.
	
	public Subway(String LineNumber) {
		this.LineNumber = LineNumber;
	}
	
	public void take(int money) {
		this.money += money;
		this.passengerCount++;
	}
	
	public void showInfo() {
		System.out.println(LineNumber + "번 버스 손님은" 
				+ passengerCount +  "명이고, 수입은" + money + "원입니다.");
	}
} // end of class Bus
