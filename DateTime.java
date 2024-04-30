        // JAVA DateTime //

        // Four classes used for DateTime implimentation
        //     LocalDate (yyy-MM-dd)
        //     LocalTime (HH-mm-ss-ns)
        //     LocalDateTime (yyyy-MM-dd-HH-mm-ss-ns)
        //     DateTimeFormatter


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DateTime {

    public static void main(String[] args) {
        LocalDate lDate = LocalDate.now(); // To get current date on a device.
        LocalTime lTime = LocalTime.now(); // To get current time on a device.
        LocalDateTime lDateTime = LocalDateTime.now(); // To get current time on a device and format it to normal.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println(lTime);
        System.out.println(lDate);
        System.out.println(lDateTime);
        System.out.println(formatter);
    }
}

