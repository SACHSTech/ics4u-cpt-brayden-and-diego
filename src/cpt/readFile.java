package cpt;

import java.util.ArrayList;
import java.util.List;
import java.io.*;


public class readFile {
    
    /**
     * This function reads a csv file and stores the data in it in the form of an array
     * @param strPath: the path of the file
     * @return: and array of objects of the Team class, this is useful as it allows for all the stats to be bundled as a team
     */
    public static ArrayList<Team> readDataFile(String strPath) {
        //declaring variables
        ArrayList<Team> list = new ArrayList<Team>(); 
        String nextLine = "";

        //try catch exceptions
        try (BufferedReader br = new BufferedReader(new FileReader(strPath))){

            //for every new line, split it every comma, add every value on the row to a new team object and add the team to the array list
            while((nextLine = br.readLine()) != null){
               String[] arrTemp = nextLine.split(",");
               Team a = new Team(arrTemp[0].toString(), arrTemp[1].toString(), arrTemp[2].toString(), arrTemp[3].toString(), arrTemp[4].toString(), arrTemp[5].toString(), arrTemp[6].toString(), arrTemp[7].toString(), arrTemp[8].toString(), arrTemp[9].toString(), arrTemp[10].toString());
               list.add(a); 
            }
        
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

       
        
        //return array list
        return list;
    }
    
}
