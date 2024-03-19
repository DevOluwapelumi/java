 public class FirstAssign{

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Ask for name and class courses
        System.out.println("Enter your name:");
        String name = scanner.nextLine();

        System.out.println("Enter your class:");
        String className = scanner.nextLine();

        // Ask for 5 course scores
        double[] courseScores = new double[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter score for Course " + (i + 1) + ":");
            courseScores[i] = scanner.nextDouble();
        }

        // Calculate CGPA
        double cgpa = calculateCGPA(courseScores);

        // Display CGPA
        System.out.println("Hello " + name + "!");
        System.out.println("Class: " + className);
        System.out.println("Your CGPA is: " + cgpa);

        scanner.close();
    }

    // Method to calculate CGPA
    public static double calculateCGPA(double[] scores) {
        // Convert scores to grade points
        double totalGradePoints = 0;
        for (double score : scores) {
            totalGradePoints += convertToGradePoint(score);
        }

        // Calculate CGPA (average grade points)
        double cgpa = totalGradePoints / scores.length;
        return cgpa;
    }

    // Method to convert score to grade point
    public static double convertToGradePoint(double score) {
        if (score >= 70) {
            return 5.0;
        } else if (score >= 60) {
            return 4.0;
        } else if (score >= 50) {
            return 3.0;
        } else if (score >= 45) {
            return 2.0;
        } else if (score >= 40) {
            return 1.0;
        } else {
            return 0.0;
        }
    }
}