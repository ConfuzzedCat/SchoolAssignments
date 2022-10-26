public class Plot extends Property{
    private String option;

    public Plot(int ID, String label, int cost, int income, int seriesID, Player owner) {
        super(ID, label, cost, income, seriesID, owner);
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
    @Override
    public String toString() {
        String s = super.toString();
        return s+" tilhører serie: "+this.seriesID;
    }
    @Override
    public String onLand(Player p){
        String s = super.onLand(p);
        if (this.owner == null){
            option = "buy";
            s += "\n Vil du købe "+this.getLabel()+" . Tast J for ja N for nej.";

        }
        return s;
    }
    @Override
    protected String onAccept(Player p){
        String s="";

        if(option.equals("buy")){
            s = "Grunden er din!";

            p.buy(this.cost);

        }
        return "";
    }
    @Override
    protected String onReject(Player p){
        return "";
    }
}
