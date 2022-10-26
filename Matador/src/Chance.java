public class Chance extends Field {
    public Chance(int id, String label) {
        super(id, label);
    }
    @Override
    public String onLand(Player p){
        String s = super.onLand(p);
        s+= "\nTræk et kort fra bunken";

        return s;
    }
}
