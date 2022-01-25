//remember imports
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class SongMath {
    public static void main(String[] args) {

        //remember FileReader, BufferedReader for reading
        //FileWriter, BufferedWriter for writing

        // Creating HashMap to store key for numbers to add & their values
        Hashmap<String, Integer> hasm = new Hashmap<String, Integer>();
        hasm.put("3", 3);
        hasm.put("'69", 69);
        hasm.put("skater", 8);
        hasm.put("seven", 7);
        hasm.put("eleven", 11);
        hasm.put("twenty", 20);
        hasm.put("thirty", 30);
        hasm.put("sixty", 60);
        hasm.put("forward", 1);
        hasm.put("back", -3);
        hasm.put("nine", 9);
        hasm.put("four", 4);
        hasm.put("fifteen", 15);
        hasm.put("freshman", -9);
        hasm.put("senior", -12);
        hasm.put("six", 6);
        hasm.put("dime", 10);
        hasm.put("five", 5);
        String inpFileName = " twenty.txt";
        String outFileName = "songmath.txt";
        String lline;
        String wword[];
        int X = 0;

        try {
            FileReader flrd = new FileReader(inpFileName);
            BufferedReader blrd = new BufferedReader(flrd);
            while((lline = blrd.readLine()) != null) {

// //Checking whether link is blank or not
                if(lline.isBlank())
                    continue;

// //Splitting line to extract words
                else
                    wword = lline.split(" ");

                for(int i=0; i<wword.length; ++i)
                {
                    char last = wword[i].charAt(wword[i].length()-1);

                    // //Splitting line to extract words
                    if(!(Character.isLetter(last) || Character.isDigit(last)))
                        wword[i] = wword[i].substring(0, wword[i].length()-1);

                    //Checking whether the word exists in HashMap key
                    if(hasm.containsKey(wword[i]))
                        X = X + hasm.get(wword[i]);
                }
            }
            blrd.close();
        } catch (FileNotFoundException e) {

//Displaying file not found error message
            System.out.println(inpFileName + " file not found.");
        } catch (IOException e) {
            System.out.println(inpFileName + " cannot be accessed.");
            e.printStackTrace();
        }

        try {
            FileWriter flwr = new FileWriter(outFileName);
            BufferedWriter blwr = new BufferedWriter(flwr);
            blwr.write(X + " X is an interesting number to get, huh? ");
            blwr.close();
        } catch (IOException e) {
            System.out.println(outFileName + " cannot be accessed.");
            e.printStackTrace();
        }
    }//end of main
}//end of class
