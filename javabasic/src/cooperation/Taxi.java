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
		System.out.println(kind + "�� �°��� " + passengerCount + "���̰�, ������ " + money + "�Դϴ�.");
}
}
