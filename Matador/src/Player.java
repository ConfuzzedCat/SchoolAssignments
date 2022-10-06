public class Player {
    private String name;
    private BankAccount account;

    public Player(String name, int amount) {
        this.name = name;
        account = new BankAccount(amount);
    }

    public int getAmount() {
        return account.getBalance();
    }

    public void buy(int cost){
        account.setBalance(-cost);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Player: \n\tName: " + name + "\n\tBalance: " + account.getBalance();
    }
    public String toString(Boolean file) {
        if(file){
            return name + "," + account.getBalance();
        }
        return toString();
    }
}
