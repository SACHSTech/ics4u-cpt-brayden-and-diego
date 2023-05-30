package cpt;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class readFile {
    public static team[] readDataFile(String strPath) {
        //declaring variables
        team[] finalList = new team[30];

        try {
            BufferedReader br = new BufferedReader(new FileReader(strPath));
        
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
