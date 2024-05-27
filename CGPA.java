public class CGPA {

    public static void main(String[] args) {
        System.out.println("WELCOME TO MY CGPA CALCULATOR APPLICATION USING JAVA");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("KINDLY ENTER YOUR NAME :=>");
        String name = scanner.nextLine();
        System.out.println("KINDLY ENTER YOUR DEPARTMENT :=>");
        String className = scanner.nextLine();

        // Define the number of courses
        System.out.println("Enter the number of courses:");
        int numCourses = scanner.nextInt();
        double[] courseScores = new double[numCourses];
        for (int i = 0; i < numCourses; i++) {
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