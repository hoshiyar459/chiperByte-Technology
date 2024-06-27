import java.util.ArrayList;
import java.util.List;
import java.util.Scanner ; 

public class Bankify {
    public static void main(String[] args) {
        System.out.println("\n ): WELCOME TO BANKIFY A SIMPLE BANKING SYSTEM :)\n");
                Bank bank = new Bank();
        
  
                bank.CreateAccount(1, "John Doe", 1000.0);
                bank.CreateAccount(2, "Jane Doe", 500.0);
        
                // Deposit and withdraw
                bank.Deposite( 1, 500);
                bank.withdraw(1, 200);
        
                // Transfer
                bank.Transfer(1, 2, 300.0);
        
                // Print account balances
                Account account1 = bank.getAccount(1);
                Account account2 = bank.getAccount(2);
                System.out.println("Account 1 balance: " + account1.getBalance());
                System.out.println("Account 2 balance: " + account2.getBalance());
            }
        }


class Account {  
    private int AccountNumber ; 
    private String AccountHolder ; 
    private Double balance ; 

    public Account(int AccountNumber , String AccountHolder , double balance){
         this.AccountNumber = AccountNumber; 
         this.AccountHolder = AccountHolder ; 
         this.balance = balance ; 
    }

    public String getAccountHolder() {
        return AccountHolder;
    }
    public int getAccountNumber() {
        return AccountNumber;
    }
    public Double getBalance() {
        return balance;
    }

    public void Deposite(double deposite){
         balance += deposite ; 
    }
    public void Withdrawl(double Amount ){
         if(balance >= Amount){
             balance -= Amount ; 
         }
         else {
             System.out.println("Insufficient Balance Please Check Your Amount");
         }
    }
}

class Bank {
     List<Account> accounts ; 
     
     public Bank(){
        accounts = new ArrayList<>(); 
     }
     public boolean CreateAccount(int AccountNumber , String AccountHolder , double Balance){
         try {
         Account account = new Account(AccountNumber, AccountHolder, Balance);
         accounts.add(account); 
         return true; 
        } catch (Exception e) {
            System.out.println("Exception Occured Please Check Your Details And Try Again");
             return false ; 
         }
     }
     public Account getAccount(int AccountNumber){
         for (Account account : accounts) {
             if(account.getAccountNumber() == AccountNumber ){
                return account ; 
             }
         }
         return null; 
     }
     public void Deposite(int AccountNumber , int Amount){
          Account account  = getAccount(AccountNumber); 
             if(account != null ){
                 account.Deposite(Amount);
             }
             else { 
              System.out.println("Account Not Found");
             }
    }
    public void withdraw(int accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        if (account != null) {
            account.Withdrawl(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

     public void Transfer(int fromAccount , int toAccount  , Double balance){
         Account fromAccountNumber = getAccount(fromAccount); 
         Account toAccountNumber = getAccount(toAccount); 

         if(fromAccountNumber != null && toAccountNumber != null){
             fromAccountNumber.Withdrawl(balance);
             toAccountNumber.Deposite(balance);       
         }
         else {
             System.out.println("Account Not Found Please Check Your Account Number or Insufficient Balance");
         }
     }
    }
    
     class Transaction {
        private int transactionId;
        private String transactionType;
        private double amount;
    
        public Transaction(int transactionId, String transactionType, double amount) {
            this.transactionId = transactionId;
            this.transactionType = transactionType;
            this.amount = amount;
        }
    
        public int getTransactionId() {
            return transactionId;
        }
    
        public String getTransactionType() {
            return transactionType;
        }
    
        public double getAmount() {
            return amount;
        }
    }



