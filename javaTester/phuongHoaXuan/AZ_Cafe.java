package phuongHoaXuan;

public class AZ_Cafe {
	public String espresso = "Espresso Coffee";
	
	public void shipEspresso() {
		System.out.println("ship" + espresso);
	}
	
	protected String capuccino = "Capuccino Coffe";
	
	protected void shipCappucino() {
		System.out.println("ship" + capuccino);
	}
	
	
	String hxCafe = "Hoa Xuan Coffee";
	
	void shipHXCafe() {
		System.out.println("ship" + hxCafe);
	}
	
	
	private String privateCafe = "Private  Coffee";
	
	private void shipPrivateCafe() {
		System.out.println("ship" + privateCafe);
	}

	public static void main(String[] args) {
		AZ_Cafe az= new AZ_Cafe();
		System.out.println(az.espresso);
		az.shipEspresso();	
		
		System.out.println(az.capuccino);
		az.shipCappucino();
		
		System.out.println(az.hxCafe);
		az.shipHXCafe();

		System.out.println(az.privateCafe);
		az.shipPrivateCafe();
	}
}
