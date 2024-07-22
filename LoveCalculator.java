import java.util.Scanner;
import java.util.Random;

public class LoveCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Love Calculator!");

        System.out.print("Enter the first person's name: ");
        String name1 = scanner.nextLine();

        System.out.print("Enter the second person's name: ");
        String name2 = scanner.nextLine();

        // Calculate "love percentage"
        int lovePercentage = random.nextInt(101);

        System.out.println("\nCalculating love compatibility...");
        System.out.println(name1 + " and " + name2 + " are " + lovePercentage + "% compatible!");

        // Provide a fun message based on the percentage
        if (lovePercentage >= 80) {
            System.out.println("Wow! You two are a perfect match!");
        } else if (lovePercentage >= 60) {
            System.out.println("There's definitely a spark between you two!");
        } else if (lovePercentage >= 40) {
            System.out.println("You might want to get to know each other better.");
        } else {
            System.out.println("Perhaps you're better off as friends.");
        }

        scanner.close();
    }
}