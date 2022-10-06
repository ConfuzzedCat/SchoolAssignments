import java.util.ArrayList;

public class Game {
    private static final int STARTING_AMOUNT = 30000;
    private static int maxPlayers = 6;
    private ArrayList<Player> players = new ArrayList<>();

    FileIO fileIO = new FileIO();
    TextUI textUI = new TextUI();

    public  void gameSetup(){
        //Check if gameData exists
        //else prompt user for data.

        ArrayList<String> data = fileIO.readGameData();
        if (data == null){
            data = textUI.getUserInput("Set players name. Type q to quit.", "Player", maxPlayers);
        }
        createPlayers(data);
        fileIO.writeGameData(players);
    }
    public void createPlayers(ArrayList<String> data){
        for (String s:data){
            String[] values = s.split(",");
            int amount = STARTING_AMOUNT;
            if(values.length > 1){
                amount = Integer.parseInt(values[1]);
            }
            Player p = new Player(values[0], amount);
            players.add(p);
        }
    }

    public void showPlayers(){
        for (Player p:players) {
            System.out.println(p);
        }
    }
}
