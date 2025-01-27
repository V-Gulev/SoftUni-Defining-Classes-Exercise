package SoftUni.BankAccount_03;

public class BankAccount {
    private int id;
    private double balance;
    private static double interestRate = 0.02;
    private static int counter = 0;

    public BankAccount(){
        counter++;
        this.id = counter;
    }

    public int getId() {
        return id;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterest(int years) {
        return this.balance * interestRate * years;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }


}
