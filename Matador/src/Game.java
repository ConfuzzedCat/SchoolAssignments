import java.util.ArrayList;

public class Game {
    private FileIO fileIO = new FileIO();
    private TextUI textUI = new TextUI();
    private ArrayList<Player> players = new ArrayList();
    private Board board;
    private Player currentPlayer;

    public void gameSetup() {
        //**********************
        // Load af spiller data
        // **********************
        ArrayList<String> data =  fileIO.readGameData();
        if(data == null){
            data = textUI.getUserInput("Skriv spillernavn. Tast Q for at quitte",6);
        }
        this.createPlayers(data);

        //**********************
        // Load af felt data og bygge boardet
        // **********************
        String[] fieldData = fileIO.readBoardData();
        board = new Board(fieldData);
        runGame();

    }
    public void saveGameData(){
        fileIO.writeGameData(players);
    }

    private void throwAndMove(){
        System.out.println("Det er " + currentPlayer.getName() + "'s tur.\n" + currentPlayer.getName() + "står på " + board.getField(currentPlayer.getPosition()));
        int result = Dice.rollDiceSum();
        int newPos = currentPlayer.updatePos(result);
        //System.out.println("Current player NEW position: "+currentPlayer.getPosition());
        Field f = board.getField(newPos);
        landAndAct(f);
    }
    private void landAndAct(Field f){
        String msg = f.onLand(currentPlayer);
        String choice = textUI.getUserInput(msg);
        f.processChoice(choice, currentPlayer);
    }

    private void runGame(){
        String input = "";
        int currentPlayerNumber = 0;
        while (!input.equalsIgnoreCase("q")){
            currentPlayer = players.get(currentPlayerNumber);
            throwAndMove();
            input = textUI.getUserInput("Forsætte (C) eller Afslutte (Q) ?");
            currentPlayerNumber++;
            if(currentPlayerNumber == players.size()){
                currentPlayerNumber = 0;
            }
        }

    }

    private void createPlayers(ArrayList<String> data){
        for (String s : data) {
            String[] values = s.replaceAll(" ","").split(","); //split arrayet så vi får adskildt de to værdier
            int balance;

            if (values.length > 1) {
                balance = Integer.parseInt(values[1]);
            } else {
                balance = Integer.parseInt("30000");
            }
            Player p = new Player(values[0], balance); // brug de to værdier til at lave en ny Player instans

            players.add(p);                            // tilføj Player instansen til array'et af spillere

        }

    }

    public void displayPlayers() {
        for (Player p:players) {
            System.out.println(p);
        }
    }
}
