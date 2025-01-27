package SoftUni.BankAccount_03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, BankAccount> bankAccounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (!input.equals("End")) {
            String[] parts = input.split("\\s+");

            switch (parts[0]) {
                case "Create":
                    createBankAccount();
                    break;
                case "Deposit":
                    depositSum(Integer.parseInt(parts[1]), Double.parseDouble(parts[2]));
                    break;
                case "SetInterest":
                    setInterest(Double.parseDouble(parts[1]));
                    break;
                case "GetInterest":
                    getInterest(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                    break;
            }


            input = sc.nextLine();
        }


    }

    private static void getInterest(int id, int years) {
        if (bankAccounts.containsKey(id)) {
            BankAccount bankAccount = bankAccounts.get(id);
            System.out.printf("%.2f\n", bankAccount.getInterest(years));
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void setInterest(double interest) {
        BankAccount.setInterestRate(interest);
    }

    private static void depositSum(int id, double amount) {
        if (bankAccounts.containsKey(id)) {
            BankAccount bankAccount = bankAccounts.get(id);
            bankAccount.deposit(amount);
            System.out.printf("Deposited %.0f to ID%d\n", amount, id);
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void createBankAccount() {
        BankAccount bankAccount = new BankAccount();
        bankAccounts.put(bankAccount.getId(), bankAccount);
        System.out.printf("Account ID%d created\n", bankAccount.getId());
    }
}
