import java.util.ArrayList;
import java.util.List;

// Bank class
class Bank {
    private String name;
    private List<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void openAccount(Customer customer, double initialBalance) {
        customer.addAccount(new Account(this, initialBalance));
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        System.out.println("Account opened for " + customer.getName() + " at " + name + " with initial balance: " + initialBalance);
    }

    public String getName() {
        return name;
    }

    public void showCustomers() {
        System.out.println("\nCustomers of " + name + ":");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}

// Customer class
class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("\n" + name + "'s Accounts:");
        for (Account account : accounts) {
            System.out.println("Bank: " + account.getBank().getName() + ", Balance: " + account.getBalance());
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (Accounts: " + accounts.size() + ")";
    }
}

// Account class
class Account {
    private Bank bank;
    private double balance;

    public Account(Bank bank, double balance) {
        this.bank = bank;
        this.balance = balance;
    }

    public Bank getBank() {
        return bank;
    }

    public double getBalance() {
        return balance;
    }
}

// Main class to demonstrate association
public class BankAssociationDemo {
    public static void main(String[] args) {
        // Creating banks
        Bank sbi = new Bank("State Bank of India");
        Bank hdfc = new Bank("HDFC Bank");

        // Creating customers
        Customer customer1 = new Customer("Amit Sharma");
        Customer customer2 = new Customer("Priya Verma");

        // Opening accounts in different banks
        sbi.openAccount(customer1, 5000);
        hdfc.openAccount(customer1, 12000);
        sbi.openAccount(customer2, 8000);

        // Viewing balance for each customer
        customer1.viewBalance();
        customer2.viewBalance();

        // Displaying customers of each bank
        sbi.showCustomers();
        hdfc.showCustomers();
    }
}
