package cooperation;

public class Taxi {
	String kind;
	int passengerCount;
	int money;
	
	public Taxi(String kind) {
		this.kind = kind;
	}
	
	public void take(int money){
		this.money += money;
		passengerCount++;
	}
	
	public void showInfo() {
		System.out.println(kind + "의 승객은 " + passengerCount + "명이고, 수입은 " + money + "입니다.");
}
}
