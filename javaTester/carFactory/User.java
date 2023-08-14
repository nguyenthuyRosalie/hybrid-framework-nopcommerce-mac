package carFactory;

public class User {

	public static void main(String[] args) {
		
		getCar("Honda").viewCar();
		getCar("Honda").driveCar();

		getCar("Huyndai").viewCar();
		getCar("Huyndai").driveCar();

		getCar("Toyota").viewCar();
		getCar("Toyota").driveCar();

		getCar("Ford").viewCar();
		getCar("Ford").driveCar();

		getCar("Mercedez").viewCar();
		getCar("Mercedez").driveCar();
	}

	public static Car getCar(String carName) {
		Car car = null;
		if (carName.equals("Honda")) {
			car = new Honda();

		} else if (carName.equals("Huyndai")) {
			car = new Huyndai();
		} else if (carName.equals("Toyota")) {
			car = new Toyota();
		} else if (carName.equals("Ford")) {
			car = new Ford();
		} else {
			throw new RuntimeException("The car name is invalid");
		}

		return car;
	}

}
