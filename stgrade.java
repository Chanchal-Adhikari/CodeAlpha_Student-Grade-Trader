import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class stgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> grades = new ArrayList<>();

        System.out.println("--- Student Grade Tracker ---");
        System.out.println("Enter student grades (enter -1 to finish):");

        // Input loop
        while (true) {
            System.out.print("Enter grade: ");
            
            // Basic validation to ensure the user enters a number
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid number.");
                System.out.print("Enter grade: ");
                scanner.next(); 
            }
            
            double grade = scanner.nextDouble();

            if (grade == -1) {
                break;
            } else if (grade < 0 || grade > 100) {
                System.out.println("Please enter a valid grade between 0 and 100.");
            } else {
                grades.add(grade);
            }
        }

        // Generate summary report
        if (grades.isEmpty()) {
            System.out.println("\nNo grades were entered.");
        } else {
            double sum = 0;
            for (double g : grades) {
                sum += g;
            }
            
            double average = sum / grades.size();
            double highest = Collections.max(grades);
            double lowest = Collections.min(grades);

            System.out.println("\n========== SUMMARY REPORT ==========");
            System.out.println("Total Students: " + grades.size());
            
            System.out.print("All Grades: ");
            for (int i = 0; i < grades.size(); i++) {
                System.out.print(grades.get(i) + (i < grades.size() - 1 ? ", " : ""));
            }
            System.out.println();
            
            System.out.printf("Average Score: %.2f\n", average);
            System.out.println("Highest Score: " + highest);
            System.out.println("Lowest Score: " + lowest);
            System.out.println("====================================");
        }

        scanner.close();
    }
}