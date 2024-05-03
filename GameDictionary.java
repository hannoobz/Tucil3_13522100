import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;


public class GameDictionary{
    private HashSet<String> data;

    public GameDictionary(){
        this.data = new HashSet<String>();
    }

    public void read(String filename){
        try{
            this.data = new HashSet<String>();
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String stringData = myReader.nextLine();
                this.data.add(stringData);
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public HashSet<String> getData() {
        return data;
    }
}