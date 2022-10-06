import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {
    static Scanner scan = new Scanner(System.in);

    //receives a message and displays it to the user
    //prompts the user for a response

    public ArrayList<String> getUserInput(String msg, String elementName, int amount){

        ArrayList<String> values = new ArrayList<>();
        int i = 0;
        System.out.println(msg);
        while(i < amount){
            System.out.print("\n"+elementName + " " + (i+1) + ": ");
            String input = scan.nextLine();
            if(input.equalsIgnoreCase("q")){
                break;
            }
            values.add(input);
            i++;

        }
        return values;
    }

    public String getUserInput(String msg){
        System.out.println(msg);
        return scan.nextLine();
    }


    public int getUserChoice(ArrayList<String> arr){
        String msg =  "Choose a number between the following choices.";
        System.out.println(msg);

        for(int i = 0; i<arr.size(); i++) {

            System.out.println("[" + (i + 1) + "] " + arr.get(i));
        }
        return scan.nextInt();
    }
}