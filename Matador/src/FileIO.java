import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
    public ArrayList<String> readGameData() {
        ArrayList<String> values = new ArrayList<>();
        String header;
        try {
            Scanner scan = new Scanner(new File("data/gamedata.csv"));
            header = scan.nextLine();
            while (scan.hasNextLine()){
                String s = scan.nextLine();
                values.add(s);
            }
        } catch (FileNotFoundException e){
            System.out.println(e);
        }
        return values;
    }

    public String[] readBoardData(){
        String[] values = new String[40];
        String header;
        try {
            Scanner scan = new Scanner(new File("data/boarddata.csv"));
            header = scan.nextLine();
            for (int i = 0; i < values.length; i++){
                String s = scan.nextLine();
                values[i] = s;
            }
        } catch (FileNotFoundException e){
            System.out.println(e);
        }
        return values;
    }

    public void writeGameData(ArrayList<Player> data){
        String out = "name,balance\n";
        for (Player p: data) {
            out += p.toString(true) + "\n";
        }
        out = out.trim();
        try {
            FileWriter writer = new FileWriter("data/gamedata.csv");
            writer.write(out);
        } catch (Exception e){
            System.out.println(e);
        }
    }
}