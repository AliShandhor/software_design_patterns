package behavioralpatterns.visitor;

// Key Points of the Visitor Pattern:
// 1. Visitor: The main class that implements operations on elements of the object structure.
// 2. Concrete Visitor: A class that implements the operations defined by the Visitor interface.
// 3. Element: The interface or abstract class that defines the accept method to allow the visitor to visit it.
// 4. Concrete Element: The class that implements the accept method and accepts the visitor.
// 5. ObjectStructure (main): A collection or structure of elements that can be visited by the visitor.

import java.text.DecimalFormat;

// -----------------------------------
// 1. Element Interface
// -----------------------------------
interface Account {
    int getAccountNumber();
    float getBalance();
    void accept(AccountVisitor visitor); // Accepts the visitor
}

// -----------------------------------
// 2. Concrete Elements
// -----------------------------------

// Concrete Element: CheckingAccount
class CheckingAccount implements Account {
    private int accountNumber;
    private float currentBalance;

    public CheckingAccount(int accountNumber, float currentBalance) {
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
    }

    @Override
    public int getAccountNumber() {
        return this.accountNumber;
    }

    @Override
    public float getBalance() {
        return this.currentBalance;
    }

    @Override
    public void accept(AccountVisitor visitor) {
        visitor.visitCheckingAccount(this); // Accept the visitor and invoke the corresponding visit method
    }
}

// Concrete Element: SavingsAccount
class SavingsAccount implements Account {
    private int accountNumber;
    private float currentBalance;

    public SavingsAccount(int accountNumber, float currentBalance) {
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
    }

    @Override
    public int getAccountNumber() {
        return this.accountNumber;
    }

    @Override
    public float getBalance() {
        return this.currentBalance;
    }

    @Override
    public void accept(AccountVisitor visitor) {
        visitor.visitSavingsAccount(this); // Accept the visitor and invoke the corresponding visit method
    }
}

// -----------------------------------
// 3. Visitor Interface
// -----------------------------------
interface AccountVisitor {
    void visitCheckingAccount(CheckingAccount checkingAccount); // Method to visit CheckingAccount
    void visitSavingsAccount(SavingsAccount savingsAccount);   // Method to visit SavingsAccount
}

// -----------------------------------
// 4. Concrete Visitor
// -----------------------------------
class AccountInquiryVisitor implements AccountVisitor {
    private String checkAcctBal;
    private int checkAcctNum;
    private String saveAcctBal;
    private int saveAcctNum;
    private DecimalFormat money;

    public AccountInquiryVisitor() {
        checkAcctBal = "";
        checkAcctNum = 0;
        saveAcctBal = "";
        saveAcctNum = 0;
        money = new DecimalFormat("$0.00");
    }

    // Visit CheckingAccount and format balance
    public void visitCheckingAccount(CheckingAccount cAccount) {
        checkAcctBal = money.format(cAccount.getBalance());
        checkAcctNum = cAccount.getAccountNumber();
    }

    // Visit SavingsAccount and format balance
    public void visitSavingsAccount(SavingsAccount sAccount) {
        saveAcctBal = money.format(sAccount.getBalance());
        saveAcctNum = sAccount.getAccountNumber();
    }

    // Display inquiry results
    public void displayInquiry() {
        System.out.println("Checking Account Num: " + checkAcctNum + "\nCurrent Balance: " + checkAcctBal);
        System.out.println("Saving Account Num: " + saveAcctNum + "\nCurrent Balance: " + saveAcctBal);
    }
}

// -----------------------------------
// 5. ObjectStructure (Main)
// -----------------------------------
public class BankAccountMain {
    public static void main(String[] args) {
        // Create elements (CheckingAccount and SavingsAccount)
        CheckingAccount checkingAccount = new CheckingAccount(102352, 1000);
        SavingsAccount savingsAccount = new SavingsAccount(10334, 2000);

        // Create a visitor (AccountInquiryVisitor)
        AccountInquiryVisitor inquiry = new AccountInquiryVisitor();

        // Accept the visitor for each account type
        checkingAccount.accept(inquiry); // Visiting CheckingAccount
        savingsAccount.accept(inquiry);   // Visiting SavingsAccount

        // Display inquiry results
        inquiry.displayInquiry();
    }
}
