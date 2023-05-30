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
                for(int i = 0; i < 11; i++){
                    String[] arrTemp = nextLine.split(",");
                    Team a = new Team(arrTemp[0], arrTemp[1], arrTemp[2], arrTemp[3], arrTemp[4], arrTemp[5], arrTemp[6], arrTemp[7], arrTemp[8], arrTemp[9], arrTemp[10]);
                    list.add(a); 
                }
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
