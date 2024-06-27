import java.util.ArrayList;
import java.util.List;
import java.util.Scanner ; 

public class Bankify {
    public static void main(String[] args) {
        System.out.println("\n ): WELCOME TO BANKIFY A SIMPLE BANKING SYSTEM :)\n");

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
     
     public void Bank(){
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

