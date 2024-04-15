import java.util.Scanner;

class Car {
    public int gear;
    public String color, trafficator, owner, location;
    public boolean status;
    public Scanner scan;

    public Car() {
        gear = 0;
        color = "Black";
        trafficator = "Straight";
        owner = "John Smith";
        location = "Lagos";
        status = true;
        scan = new Scanner(System.in);
        details();
    }

    public Car(int gear) {

    }

    public void details() {
        System.out.println("This is a 5 gear engine, it is owned by " + owner + "and located in " + location
                + ". It is " + color + " in color.");
        startEngine();
    }

    public void startEngine() {
        System.out.println("The car has started and ready to move. \n Please select gear 1 to take off.");
        gear = scan.nextInt();

        if (gear == 1) {
            driveCar();
        } else {
            System.out.println("The car can not take off with the selected gear. Please select gear 1");
            startEngine();
        }
    }

    public void driveCar() {

        System.out.println("The car is moving at gear " + gear + " and is moving at " + trafficator
                + " direction. \n Press \n C. To change gear  \n D. To change direction \n P. To pack the car");
        String user = scan.nextLine();

        if (user.toUpperCase().equals("C")) {
            changeGear();
        } else if (user.toUpperCase().equals("D")) {
            changeDirection();
        } else if (user.toUpperCase().equals("P")) {
            packCar();
        } else {
            System.out.println("Invalid Selection.");
            driveCar();
        }
    }

    public void changeGear() {
        System.out.println("Select the new gear.");
        gear = scan.nextInt();

        driveCar();
    }

    public void changeDirection() {
        System.out.println("Select the new direction.");
        trafficator = scan.nextLine();
        driveCar();
    }

    public void packCar() {
        System.out.println(
                "The car is resetting your gear back to neutral... \n The car has packed \n The application has exited.");
        System.exit(0);
    }

}

public class OOP2 {
    public static void main(String[] args) {
        Car cr = new Car();
        // cr();
};

}