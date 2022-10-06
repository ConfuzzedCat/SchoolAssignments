import java.util.ArrayList;

public class BankAccount {
    private int balance;
    private ArrayList<String> transaction;


    public BankAccount(int startAmount){
        balance = startAmount;
        transaction = new ArrayList<>();
        transaction.add("Initialized account:"+balance);

    }
    //Kunne lige så godt hedde, "changeBalance" eller "setBalance".
    public void setBalance(int amount){
        balance += amount;
        transaction.add("Add/Minus:"+amount);
    }
    public void setBalance(int amount, String reason){
        balance += amount;
        transaction.add(reason+":"+amount);
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                '}';
    }
}
