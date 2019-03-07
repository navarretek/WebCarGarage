import Controller.CarHelper;
import Model.Car;

public class carTester {
	public static void main(String[] args) {
		Car l = new Car("lamb","x",2019);
		CarHelper ch= new CarHelper();
		ch.insertCar(l);
		for (Car c : ch.showAllCars()) {
			System.out.println(c.toString());
		}
	}
}
