// public class FirstExample{

//     public static void main(String[] args) {

//         System.out.println("You are welcome to java class. This class promise to be exciting");
//     }
// }

// import java.util.Scanner;

// public class FirstExample{
//   public static void main(String[] args){
//     int score = 50;
//     long newScore = score;
//     int anotherScore = (int)newScore;
//     System.out.println(newScore);
//   }
// }



//  public class FirstExample{
//    public static void main(String[] args){
//     String name = "Oluwapelumi";
//     int age = 60;
//     String status = "false";
//     String balance = "500.45";
//     String comment = "This is a Java class. it start from 8am to 10am Monday to Tuesday. There is no wasting of time.";
//     System.out.println("Total length of comment is "+ comment.length());
//     System.out.println(comment.toUpperCase());
//     System.out.println(comment.toLowerCase());
//     System.out.println(comment.indexOf("Monday"));
//     System.out.println(comment.codePointAt(56));
//     System.out.println(comment.codePointBefore(56));
//     System.out.println(comment.codePointCount(45, 67));
//     System.out.println(name.compareTo(status));
//     System.out.println(name.compareToIgnoreCase(status));
//     System.out.println(name.concat(status));
//     System.out.println(name.contentEquals(status));
//     System.out.println(name.startsWith("Y"));
//     System.out.println(name.endsWith("e"));
//     System.out.println(name.equals(status));
//     System.out.println(name.equalsIgnoreCase(status));
//     System.out.println(name.getBytes());
//     System.out.println(name.intern());
//     System.out.println(comment.replace("java", "javascript"));
//     System.out.println(comment.split(" "));

//         Scanner userInput = new Scanner (System.in);
//         System.out.println("Enter your first name");
//         System.out.println("Your first name is "+fname);
//    }}



//     public class FirstExample{
//    public static void main(String[] args){
//         System.out.println(Math.abs(-50.0));
//         System.out.println(Math.min(70, 30));
//         System.out.println(Math.max(70.5, 30));
//         System.out.println(Math.sqrt(25));
//         System.out.println(Math.pow(50.0, 3.0));
//         System.out.println(Math.E);
//         System.out.println(Math.PI);
//         System.out.println(Math.TAU);
//         System.out.println(Math.addExact(40, 34));
//         System.out.println(Math.round(56.435334343));
//         System.out.println(Math.floorDiv(45, 21));
//    }}


//    JAVA ARRAY CLASSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS   //

//      public class FirstExample{
//           public static void main(String[] args){
//      String[] name;
//      String[] name2 = new String[5];
//      String[] name3 = {"Oluwapelumi", "Victor", "Sunday"};
//      name2[0] = "Oluwapelumi";
//      name2[2] = "Victor";
//      name2[4] = "Sunday";
//      System.out.println(name2[0]);
//      name3[1] = "Jimoh";
//  }}

     // public class FirstExample{
     //      public static void main(String[] args){
     // String[][] values = new String[3][3];
     // values[1][2] = "Micheal";
     // values[0][0] = "John";
     // int[][] val = {{1, 2, 3, 4, 5}, {3, 5, 7, 8, 9}, {4, 0, 2,7, 3}};
     // System.out.println(val[1][2]);
     // }}

     // JAVA SWITCH CASE STATEMENTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
import java.util.Scanner;

// public class FirstExample {
//     public static void main(String[] args) {
//         int day = 3;
//         String dayString;

//         switch (day) {
//             case 1:
//                 dayString = "Monday";
//                 break;
//             case 2:
//                 dayString = "Tuesday";
//                 break;
//             case 3:
//                 dayString = "Wednesday";
//                 break;
//             case 4:
//                 dayString = "Thursday";
//                 break;
//             case 5:
//                 dayString = "Friday";
//                 break;
//             case 6:
//                 dayString = "Saturday";
//                 break;
//             case 7:
//                 dayString = "Sunday";
//                 break;
//             default:
//                 dayString = "Invalid day";
//                 break;
//         }

//         System.out.println("The day is: " + dayString);
//     }
// }


//     public class FirstExample {
//     static Scanner na = new Scanner(System.in);

//     public static void main(String[] args) {
//         char option;
//         System.out.print("The current president of Nigeria is ___ (a) Buhari (b) Tinubu (c) Jonathan (d) Obasanjo: ");
//         option = na.next().charAt(0);

//         switch (option) {
//             case 'a':
//                 System.out.println("You missed, it's not Buhari");
//                 break;
//             case 'b':
//                 System.out.println("Congratulations, you are correct");
//                 break;
//             case 'c':
//                 System.out.println("You missed, it's not Jonathan");
//                 break;
//             case 'd':
//                 System.out.println("You missed, it's not Obasanjo");
//                 break;
//             default:
//                 System.out.println("Invalid option entered");
//                 break;
//         }
//     }
// }


    
        // JAVA METHODSsasssssssssssssssssssssssssssssssssssss

    // Method Definition e.g public ststic void myMethod(){} or public int myMethod(int a){}
    // Method Declaration e.g. {System.out.println("This is a Java class")}
    // Method Invocation e.g. myMethod() of myMethod(5)

    //  Parametized Method

    // import java.util.Scanner;
    // public class FirstExample {
    //     static Scanner na = new Scanner(System.in);

    //     public static void displayName(){
    //         System.out.println("Please enter your name");
    //         String name = na.nextLine();
    //         System.out.println("My name is "+name);
    //     }

    //     public static void main(String[] args){
    //         displayName();
    //     }
    // }


    import java.util.Scanner;
    public class FirstExample {
        static Scanner na = new Scanner(System.in);

        public static void startApp(){
            System.out.println("Press \n 1. Start application\n 2. quit application");
        }

        public static void algebra(){
            double result = 45.3 + subtract();
            System.out.println("Welcome "+ myName()+" your total value is "+result);
        }

        public static String myName(){
            System.out.println("Enter your name>");
            String name = na.nextLine();
            return name;
        }

        public static int addition(int a, int b){
            int result = a + b;
            return result;
        }

        public static double subtract(){
            double va = 50;
            double va2 = 20;
            int add = addition(5, 10);
            double result = va - va2 * add;
            return result;
        }

        public static void main(String[] args){
            startApp();
        }
        }
