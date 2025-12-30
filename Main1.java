import java.util.Scanner;

// User-defined exception
class WrongAge extends Exception {
    WrongAge(String msg) {
        super(msg);
    }
}

// Base class
class Father {
    int fAge;

    Father(int age) throws WrongAge {
        if (age < 0)
            throw new WrongAge("Father age cannot be negative");
        fAge = age;
    }
}

// Derived class
class Son extends Father {
    int sAge;

    Son(int fAge, int sAge) throws WrongAge {
        super(fAge);

        if (sAge >= fAge)
            throw new WrongAge("Son age must be less than Father age");

        this.sAge = sAge;
    }
}

// Main class (USER INPUT)
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Father's age: ");
            int fAge = sc.nextInt();

            System.out.print("Enter Son's age: ");
            int sAge = sc.nextInt();

            Son s = new Son(fAge, sAge);
            System.out.println("Object created successfully");

        } catch (WrongAge e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
