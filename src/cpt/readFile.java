package cpt;

import java.util.ArrayList;
import java.util.List;
import java.io.*;


public class readFile {
    public static Team[] readDataFile(String strPath) {
        //declaring variables
        List<Team> list = new ArrayList<Team>(); 
        String nextLine = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(strPath));

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

        Team [] finalArray =  new Team[list.size()];
        list.toArray(finalArray);
        
        return finalArray;
    }
}
