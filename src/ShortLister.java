import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ShortLister {
    public static void main(String[] args) {
        //Array that stores every word in the chosen file
        ArrayList<String> words = new ArrayList<>();

        ArrayList<Object> shortWords;

        //File chooser and storage for read text
        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String rec;

        //File pathing
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");

        //Chooses file
        chooser.setCurrentDirectory(target.toFile());

        //Safeguard for code errors
        try {
            //Makes sure the chooser approves
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                //Gets the file and creates a reader
                target = chooser.getSelectedFile().toPath();
                inFile = new Scanner(target);

                //Makes sure there is another line in the file
                while (inFile.hasNextLine()) {
                    //Reads the line
                    rec = inFile.nextLine();

                    //splits the text into individual words and adds it to an array
                    String[] split = rec.split(" ", 0);
                    Collections.addAll(words, split);
                }

                //Closes the reader
                inFile.close();

                ShortWordFilter wordFilter = new ShortWordFilter();
                shortWords = wordFilter.collectAll(words);

                System.out.println("Short words in file: ");

                for (Object word : shortWords) {
                    System.out.println(word);
                }

            } else {
                //If they didn't choose a file, it'll tell them and close
                System.out.println("You did not choose a file.");
                System.exit(0);
            }
        } catch (FileNotFoundException e){
            //File not found error
            System.out.println("File Not Found");
            e.printStackTrace();
        } catch (IOException e) {
            //IOException Error
            System.out.println("IOException Error");
            e.printStackTrace();
        }
    }
}