package cpt;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
public class ppgSort {
    Team[] b = readFile.readDataFile("src/cpt/Comp Sci CPT spreadsheet - Points Per Game.csv");
    
    public static double[] ppg22sort{
    List<Double> list = new ArrayList<>(); 

    for (Team team : b) {
        double a = Double.parseDouble(team.getPpg22());
        list.add(a);
    }
    
    Double [] ppg22array =  new Double[list.size()];
    list.toArray(ppg22array);
    Sorting.mergeSort(ppg22array);
    }
}    
