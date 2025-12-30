import java.util.Scanner;

class Student {
    String usn, name;
    int[] credits;
    int[] marks;
    int n;

    // Method to accept details
    void accept() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter USN: ");
        usn = sc.nextLine();

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter number of subjects: ");
        n = sc.nextInt();

        credits = new int[n];
        marks = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            credits[i] = sc.nextInt();

            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
    }

    // Method to calculate SGPA
    double calculateSGPA() {
        int totalCredits = 0;
        int totalPoints = 0;

        for (int i = 0; i < n; i++) {
            int gradePoint;

            if (marks[i] >= 90) gradePoint = 10;
            else if (marks[i] >= 80) gradePoint = 9;
            else if (marks[i] >= 70) gradePoint = 8;
            else if (marks[i] >= 60) gradePoint = 7;
            else if (marks[i] >= 50) gradePoint = 6;
            else gradePoint = 0;

            totalPoints += credits[i] * gradePoint;
            totalCredits += credits[i];
        }
        return (double) totalPoints / totalCredits;
    }

    // Method to display details
    void display() {
        System.out.println("\nStudent Details");
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        System.out.println("SGPA: " + calculateSGPA());
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        Student s = new Student();
        s.accept();
        s.display();
    }
}
