import java.util.Scanner;

public class TASK_3_ATM_Interface {
    public static void main(String[] args) {
        Atm a1 = new Atm();
        a1.checkPin();
    }
}

class Atm {
    Scanner sc = new Scanner(System.in);

    double balance = 100;
    int PIN = 1111;

    double getBalance() {
        return balance;
    }

    void setBalance(double balance) {
        this.balance = balance;
    }

    void checkBalance() {
        System.out.print("-------------------------------------------------------------\n");
        System.out.println("          Available Balance:-- ₹" + getBalance());
        System.out.print("-------------------------------------------------------------\n");
    }

    void depositMoney() {
        System.out.print("-------------------------------------------------------------\n");
        System.out.print("👉Enter The Amount You Want To DEPOSIT:-- ₹");
        double depositAmount = sc.nextDouble();
        setBalance(balance + depositAmount);
        System.out.println("\n    Amount Deposited Successfully✅✅\n    Updated Balance:-- ₹" + getBalance());
        System.out.print("-------------------------------------------------------------\n");
    }

    void withdrawMoney() {
        System.out.print("-------------------------------------------------------------\n");
        System.out.print("👉Enter The Amount You Want To WITHDRAW:-- ₹");
        int withdrawAmount = sc.nextInt();

        if (withdrawAmount <= getBalance()) {
            setBalance(balance - withdrawAmount);
            System.out.println("\n    Amount Withdrawn Successfully✅✅\n    Updated Balance:-- ₹" + getBalance());
        } else {
            System.out.println("\n            ❌❌ Insufficient Funds!!");
        }
        System.out.print("-------------------------------------------------------------\n");
    }

    void checkPin() {
        System.out.println("-------------------------------------------------------------\n-------------------------------------------------------------");

        for (int i = 1; i <= 3; i++) {
            System.out.print("👉Enter Your Pin:-- ");
            int pin = sc.nextInt();

            if (pin == PIN) {
                menu();
                return; // Exit the method after successful login
            } else if (i < 3) {
                System.out.println("Enter A Valid Pin!!");
            } else {
                System.out.println("Your Card Has Been Blocked!!");
            }
        }
    }

    void menu() {
        while (true) {
            System.out.println("1. Deposit Money\n2. Withdraw Money\n3. A/C Balance\n4. Exit");
            System.out.print("-> Choose One Option, Press(1-4):-- ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    depositMoney();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.print("-------------------------------------------------------------\n");
                    System.out.println("                Exited✅✅");
                    System.out.print("-------------------------------------------------------------\n");
                    System.exit(0);
                    break;
                default:
                    System.out.print("-------------------------------------------------------------\n");
                    System.out.println("           ❌❌ Choose A Valid Option!!");
                    System.out.print("-------------------------------------------------------------\n");
            }
        }
    }
}
