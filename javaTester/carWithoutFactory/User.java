package carWithoutFactory;

public class User {

	public static void main(String[] args) {

		// Saturday's morning
		Honda honda = new Honda();
		honda.viewCar();
		honda.driveCar();

		// Saturday's afternoon
		Toyota toyota = new Toyota();
		toyota.viewCar();
		toyota.driveCar();

		// Sunday's morning
		Huyndai huyndai = new Huyndai();
		huyndai.viewCar();
		huyndai.driveCar();

		// Sunday's afternoon
		Ford ford = new Ford();
		ford.viewCar();
		ford.driveCar();	
	}

}
