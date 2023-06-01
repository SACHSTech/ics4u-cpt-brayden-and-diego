package cpt;

public class Sortingpt2 {

    private void getppg22sort(Team[] arr, String property){
        int currentMinIndex;
        for (int i = 0; i < arr.length - 1; i++)  // i represents front of the unsorted list
        {

            // set current min to front of unsorted list
            currentMinIndex = i;  

	     //find the index of the min of the unsorted list
            for (int j = i + 1; j < arr.length; j++)
            {
                if(arr[j] < arr[currentMinIndex])
                {
                    currentMinIndex = j;
                }
            }
            
            // swap numbers if needed
            if (i != currentMinIndex)
            {
                int temp = b[currentMinIndex];
                arr[currentMinIndex] = arr[i];
                arr[i] = temp;
            }
        }
        
        return arr;
    }

}
