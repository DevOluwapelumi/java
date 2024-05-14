import java.util.Scanner;

public class Exception{
    public static void main(String[] args){
        for(int i=0; i<5; i++){

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter value 1");
            int val1 = scanner.nextInt();
            System.out.println("Enter value 2");
            int val2 = scanner.nextInt();
            try{
                int result = val1/val2;
                System.out.println(result);
            }
            catch(Exception e){
                System.out.println("Value 2 must not be Zero");
            }
        }
    }
}