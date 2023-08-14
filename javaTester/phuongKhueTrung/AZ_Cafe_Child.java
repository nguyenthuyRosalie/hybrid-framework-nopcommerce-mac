package phuongKhueTrung;

import phuongHoaXuan.AZ_Cafe;

public class AZ_Cafe_Child  extends AZ_Cafe{

	public static void main(String[] args) {
		AZ_Cafe_Child azChild = new AZ_Cafe_Child();
		azChild.buildRoom();
		
		azChild.shipCappucino();

	}
	
	private  void buildRoom() {
		System.out.println(espresso);
		shipEspresso();
		
	}

}
