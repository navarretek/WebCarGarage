import java.util.ArrayList;
import java.util.List;

import Controller.CarHelper;
import Controller.GarageHelper;
//import Controller.carsInGarageHelper;
import Model.Car;
import Model.Garage;

public class GarageTester {

	public static void main(String[] args) {
		
		Garage topNotch = new Garage("garage 5000");

		
		
//		CarHelper ch = new CarHelper();
		
		Car lambo = new Car("Lamboghini", "L", 2015);
		Car bugati = new Car("Bugati", "X", 2016);
		
		List<Car> cars = new ArrayList<Car>();
		cars.add(lambo);
		cars.add(bugati);
		
		topNotch.setListOfCars(cars);
		
		GarageHelper gh = new GarageHelper();
		gh.insertGarage(topNotch);
		
//		carsInGarageHelper cigh = new carsInGarageHelper();
//		carsInGarages carsInTopNotch = new carsInGarages(topNotch);
//		carsInTopNotch.setListOfCars(ch.showAllCars());
//		
//		
//		cigh.insertCarsInGarage(carsInTopNotch);
		
		
//		List<Cars> allGarages = gh.showAllGarages();
//		for(carsInGarages g: allGarages) {
//			System.out.println(g.toString());
//		}
	}

}
