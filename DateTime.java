        // JAVA DateTime //

        // Four classes used for DateTime implimentation
        //     LocalDate (yyy-MM-dd)
        //     LocalTime (HH-mm-ss-ns)
        //     LocalDateTime (yyyy-MM-dd-HH-mm-ss-ns)
        //     DateTimeFormatter


import java.time.LocalDate;
import java.time.LocalTime;

public class DateTime {

    public static void main(String[] args) {
        LocalDate lDate = LocalDate.now(); // To get current date on a device.
        LocalTime lTime = LocalTime.now(); // To get current time on a device.

        System.out.println(lTime);
        System.out.println(lDate);
    }
}



