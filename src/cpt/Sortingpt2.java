package cpt;

public class Sortingpt2 {
    public static String getProperty(Team obj, String x){
        switch(x){
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
    private void getppg22sort(Team[] arr, String property){
        int currentMinIndex;
        for (int i = 0; i < arr.length - 1; i++)  // i represents front of the unsorted list
        {

            // set current min to front of unsorted list
            currentMinIndex = i;  

	     //find the index of the min of the unsorted list
            for (int j = i + 1; j < arr.length; j++)
            {
                double current = Double.parseDouble(getProperty(arr[j], property));
                double minindex = Double.parseDouble(getProperty(arr[currentMinIndex], property));
                if(current < minindex){
                    currentMinIndex = j;
                }
            }
            
            // swap numbers if needed
            if (i != currentMinIndex)
            {
                Team temp = arr[i];
                arr[i] = arr[currentMinIndex];
                arr[currentMinIndex] = temp;

            }
        }
    }

}
