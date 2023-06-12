package cpt;

import java.util.ArrayList;

/**
 * this function gets a specific property from a team object using a string that specifies the wanted property
 * @param obj: team object from which you want to get the property
 * @param x: string that specifies the property thats wanted
 * @return the wanted property from the objcet
 */
public class Sortingpt2 {
    public static String getProperty(Team obj, String x){
        //switch case running through all the possibilites (all the numerical properties of team)
        switch(x){
        case "teamname":
            return obj.getTeamName();
        case "ppg22":
            return obj.getPpg22();
        case "ppg21":
            return obj.getPpg21();
        case "pct22":
            return obj.getPct22();
        case "pct21":
            return obj.getPct21();
        case "assists22":
            return obj.getAssists22();
        case "assists21":
            return obj.getAssists21();
         case "tpg22":
            return obj.getTpg22();
         case "tpg21":
            return obj.getTpg21();
        case "trg22":
            return obj.getTrg22();
        case "trg21":
            return obj.getTrg21();
        // Add cases for other properties as needed
        default:
            return "";
        }
    }
    
    /**
     * This is an adaptation of selection sort that will sort an array of objects by one of their properties
     * @param arr: the array of teams that wil be sorted
     * @param property: the property that it will be sorted by
     */
    public static void sort(ArrayList<Team> arr, String property){
        int currentMinIndex;
        for (int i = 1; i < arr.size() - 1; i++)  // i represents front of the unsorted list, start at one to skip the first row
        {

            // set current min to front of unsorted list
            currentMinIndex = i;  

	     //find the index of the min of the unsorted list
            for (int j = i + 1; j < arr.size(); j++)
            {
                if (property.equals("teamname")) {
                    double current = getProperty(arr.get(j), property).charAt(0);
                    double minindex = getProperty(arr.get(currentMinIndex), property).charAt(0);

                    if(current < minindex){
                        currentMinIndex = j;
                    }
                } else {
                    //create variables to be compared, it uses the the get property function in order to return the asked property using the string paramter
                    double current = Double.parseDouble(getProperty(arr.get(j), property));
                    double minindex = Double.parseDouble(getProperty(arr.get(currentMinIndex), property));
                
                    //compare value of specific property of the object
                    if(current < minindex){
                    currentMinIndex = j;
                    }
                }
            }
            
            // swap numbers if needed
            if (i != currentMinIndex)
            {
                Team temp = arr.get(currentMinIndex);
                arr.set(currentMinIndex, arr.get(i));
                arr.set(i, temp);

            }
        }
    }

}
