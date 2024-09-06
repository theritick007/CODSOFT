public class Main {
    public static void main(String[] args) {
        // Initialize bank account with an initial balance
        BankAccount account = new BankAccount(1000.00); // Example initial balance

        // Initialize ATM with the bank account
        ATM atm = new ATM(account);

        // Start the ATM
        atm.start();
    }
}
