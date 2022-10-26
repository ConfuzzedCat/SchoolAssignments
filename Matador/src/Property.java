public class Property extends Field{
    protected int cost;
    protected int income;
    protected int seriesID;
    protected Player owner;
    public Property(int ID, String label, int cost, int income, int seriesID, Player owner) {
        super(ID, label);
        this.cost = cost;
        this.income = income;
        this.seriesID = seriesID;
        this.owner = owner;
    }
}
