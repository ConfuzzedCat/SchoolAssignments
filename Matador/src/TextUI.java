import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {
    static Scanner scan = new Scanner(System.in);

    public String getUserInput(String msg){
        displayMessage(msg);
        String input = scan.nextLine();
        return input;
    }

    public ArrayList<String> getUserInput(String msg, int iterations ){
        ArrayList<String> values = new ArrayList<>();


        int i = 0;
        String input="";
        while(i < iterations ){
            displayMessage(msg);
            input = scan.nextLine();
            if(input.equalsIgnoreCase("Q")){
                break;
            }
            values.add(input);
            i++;
        }
        return values;
    }

    public int getUserInput(String msg, ArrayList<String> options){

        displayMessage(msg);

        for(int i = 0; i<options.size(); i++){

            System.out.println(i+1+". "+options.get(i));
        }
        int choice = scan.nextInt();
        return choice;
    }
    public void displayMessage(String msg){
        System.out.println(msg);
    }
}

