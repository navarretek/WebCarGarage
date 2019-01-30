import java.util.List;
import java.util.Scanner;

import Controller.CarHelper;
import Model.Car;


public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static CarHelper ch = new CarHelper();
	
	public static void main(String[] args) {
		runMenu();
	}

	private static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Our Garage! ---");
		while (goAgain) {
			System.out.println("*  Select:");
			System.out.println("*  1 -- Add a car");
			System.out.println("*  2 -- Edit a car");
			System.out.println("*  3 -- Delete a car");
			System.out.println("*  4 -- View the Garage");
			System.out.println("*  5 -- Exit");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addACar();
			} else if (selection == 2) {
				editACar();
			} else if (selection == 3) {
				deleteACar();
			} else if (selection == 4) {
				viewTheGarage();
			} else {
				ch.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}
	}
	private static void deleteACar() {
		System.out.print("Enter the Make of car to delete: ");
		String make = in.nextLine();
		System.out.print("Enter the Model of car to delete: ");
		String model = in.nextLine();
		System.out.print("Enter the Year of car to delete: ");
		int year = in.nextInt();
		Car toDelete = new Car(make,model,year);
		ch.deleteCar(toDelete);		
	}

	private static void editACar() {

		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Make");
		System.out.println("2 : Search by Model");
		System.out.println("3 : Search by Year");

		int searchBy = in.nextInt();
		in.nextLine();
		List<Car> foundCars;
		if (searchBy == 1) {
			System.out.print("Enter the Make: ");
			String make = in.nextLine();
			foundCars = ch.searchForCarByMake(make);

			
		} else if(searchBy == 2) {
			System.out.print("Enter the Model: ");
			String model = in.nextLine();
			foundCars = ch.searchForCarByModel(model);

		}else {
			System.out.print("Enter the Year: ");
			String year = in.nextLine();
			foundCars = ch.searchForCarByYear(year);
			}
		

		if (!foundCars.isEmpty()) {
			System.out.println("Found Results.");
			for (Car c : foundCars) {
				System.out.println(c.getId() + " : " + c.returnCarDetails());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			Car toEdit = ch.searchForCarById(idToEdit);
			System.out.println("Retrieved " + toEdit.getMake() + " " + toEdit.getModel() + " " + toEdit.getYear());
			System.out.println("1 : Update Make");
			System.out.println("2 : Update Model");
			System.out.println("3 : Update Year");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Make: ");
				String newMake = in.nextLine();
				toEdit.setMake(newMake);
			} else if (update == 2) {
				System.out.print("New Model: ");
				String newModel = in.nextLine();
				toEdit.setModel(newModel);
			} else if (update == 3) {
				System.out.print("New Year: ");
				int newYear = in.nextInt();
				toEdit.setYear(newYear);
			}

			ch.updateCar(toEdit);

		} else {
			System.out.println("---- No results found");
		}
	}

	private static void viewTheGarage() {
		List<Car> allItems = ch.showAllCars();
		for(Car singleItem : allItems) {
			System.out.println(singleItem.returnCarDetails());
		}
	}

	private static void addACar() {
		System.out.print("Enter car make: ");
		String make = in.nextLine();
		System.out.print("Enter car model: ");
		String model = in.nextLine();
		System.out.print("Enter car year: ");
		int year = in.nextInt();
		Car toAdd = new Car(make,model,year);
		ch.insertCar(toAdd);

	}

}
