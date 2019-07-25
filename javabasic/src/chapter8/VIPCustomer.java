package chapter8;

public class VIPCustomer extends Customer {
		private int agentID;
		double saleRatio;

		@Override // 재정의한 메서드
		public int calcPrice(int price) {
			bonusPoint +=price * bonusRatio;
			return price - (int)(price*saleRatio);
		}
		
		public VIPCustomer(int customerID, String customerName, int agentID) {
			super(customerID, customerName);
			customerGrade = "VIP";
			bonusRatio = 0.05;
			saleRatio = 0.1;
			System.out.println("VIPCustomer() 생성자 호출 ");
		}
		
		
		public int getAgentID() {
			return agentID;
		}
		
		
}
