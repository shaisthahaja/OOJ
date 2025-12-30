import java.util.*;

class Account {
    String name, accNo, type;
    double bal = 0;

    Account(String n, String a, String t) {
        name = n; accNo = a; type = t;
    }

    void deposit(double amt) {
        bal += amt;
        System.out.println("Balance = " + bal);
    }

    void show() {
        System.out.println("Balance = " + bal);
    }
}

class Sav_acct extends Account {
    Sav_acct(String n, String a) {
        super(n, a, "Savings");
    }

    void interest() {
        bal += bal * 0.05;
        System.out.println("Interest added. Balance = " + bal);
    }

    void withdraw(double amt) {
        if (amt <= bal) bal -= amt;
        else System.out.println("Insufficient balance");
        show();
    }
}

class Cur_acct extends Account {
    Cur_acct(String n, String a) {
        super(n, a, "Current");
    }

    void withdraw(double amt) {
        bal -= amt;
        if (bal < 500) {
            System.out.println("Penalty imposed");
            bal -= 100;
        }
        show();
    }
}

public class BankBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Name: ");
        String n = sc.nextLine();
        System.out.print("Acc No: ");
        String a = sc.nextLine();
        System.out.print("Type (s/c): ");
        char t = sc.next().charAt(0);

        Account acc = (t == 's') ? new Sav_acct(n, a) : new Cur_acct(n, a);

        System.out.print("Deposit amount: ");
        acc.deposit(sc.nextDouble());

        System.out.print("Withdraw amount: ");
        double w = sc.nextDouble();

        if (acc instanceof Sav_acct)
            ((Sav_acct) acc).withdraw(w);
        else
            ((Cur_acct) acc).withdraw(w);

        if (acc instanceof Sav_acct)
            ((Sav_acct) acc).interest();
    }
}
