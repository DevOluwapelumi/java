import java.util.Scanner;

class Car {
    public int gear;
    public boolean status;
    public String color, trafficator, owner, location;
    public Scanner scanner;

    public Car() {
        gear = 0;
        color = "Black";
        trafficator = "Straight";
        owner = "Johnson Smith";
        location = "Lagos";
        status = true;
        scanner = new Scanner(System.in);
        details();
    }

    public void details() {
        System.out.println("This is a 5 gears engine, owned by " + owner + " and located in " + location + ". It is " + color + " in color.");
        startEngine();
    }

    public void startEngine() {
        System.out.println("The car is started and ready to move. \nPlease select gear 1");
        gear = scanner.nextInt();
        if (gear == 1) {
            driveCar();
        } else {
            System.out.println("The car cannot take off. Please select gear 1.");
            startEngine();
        }
    }

    public void driveCar() {
        System.out.println("The car is moving at gear " + gear + " and is moving " + trafficator + " direction.");
        System.out.println("Press C to change gear, D to change direction, or P to park.");
        scanner.nextLine(); // Consume the newline character
        String user = scanner.nextLine();
        if (user.equalsIgnoreCase("C")) {
            changeGear();
        } else if (user.equalsIgnoreCase("D")) {
            changeDirection();
        } else if (user.equalsIgnoreCase("P")) {
            parkCar();
        } else {
            System.out.println("Invalid selection");
            driveCar();
        }
    }

    public void changeGear() {
        System.out.println("Select the new gear");
        gear = scanner.nextInt();
        driveCar();
    }

    public void changeDirection() {
        System.out.println("Select the new direction");
        scanner.nextLine(); // Consume the newline character
        trafficator = scanner.nextLine();
        driveCar();
    }

    public void parkCar() {
        System.out.println("The car is resetting your gear back to neutral...");
        System.out.println("The car has parked.");
        System.out.println("Exiting the application.");
        System.exit(0);
    }
}

public class OOP {
    public static void main(String[] args) {
        Car cr = new Car();
    }
}
