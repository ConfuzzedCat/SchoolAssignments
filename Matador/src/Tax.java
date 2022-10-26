public class Tax extends Field{
    public int getTaxAmount() {
        return taxAmount;
    }

    private int taxAmount;
    public Tax(int ID, String label, int taxAmount) {
        super(ID, label);
        this.taxAmount = taxAmount;
    }

    @Override
    public String onLand(Player p) {
        return super.onLand(p);
    }

    @Override
    protected String onAccept(Player p) {
        return super.onAccept(p);
    }

    @Override
    protected String onReject(Player p) {
        return super.onReject(p);
    }
}
