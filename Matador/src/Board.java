public class Board {

    private Field[] fields = new Field[40];

    Board(String[] data){
        createFields(data);
    }

    private Field[] createFields(String[] data){
        for(int i = 0; i < fields.length; i++){
            String s = data[i];
            String[] values = s.split(",");
            int id = Integer.parseInt(values[0]);
            String fieldtype = values[1];
            String label = values[2];
            int cost = Integer.parseInt(values[3]);
            int income = Integer.parseInt(values[4]);
            int seriesID = Integer.parseInt(values[5]);
            Field f;

            switch (fieldtype.toLowerCase()){

                case "plot":
                    f = new Plot(id, label, cost, income, seriesID, null);
                    break;
                case "lykkefelt":
                    f = new Chance(id, label);
                    break;
                case "tax":
                    f = new Tax(id, label, cost);
                    break;
                case "jail":
                    f = new Jail(id, label);
                    break;
                case "start":
                    f = new Start(id, label);
                    break;
                case "parking":
                    f = new Parking(id, label);
                    break;
                case "visit":
                    f = new Visit(id, label);
                    break;
                default:
                    f = new Field(id, label);
            }
            fields[i] = f;
        }
        return fields;
    }
    public Field getField(int id) {
        id--;
        if (id < 0 || id >= fields.length) {
            return null;
        }
        return fields[id];
    }
}