package cpt;

public class Sorting {
    public static void mergeSort(double[] arr)
   {
       double[] temp = new double[arr.length];
       mergeSortHelper(arr, 0, arr.length - 1, temp);
   }
  
   private static void mergeSortHelper(double[] arr, int from, int to, double[] temp)
   {
       // If the array length is greater than 1
       if(to - from >= 1)
       {
           int mid = (from + to) / 2;   // split the list in half
           mergeSortHelper(arr, from, mid, temp);  //mergesort the first half
           mergeSortHelper(arr, mid + 1, to, temp); // mergesort the second half
           merge(arr, from, mid, to, temp); //merge
       }
   }
  
   private static void merge(double[] arr, int from, int mid, int to, double[] temp)
   {
       int i = from;       // track left array position
       int j = mid + 1;    // track right array position
       int k = from;       // track temp position
      
       while(i <= mid && j <= to)
       {
           // If the element in the left subarray is less
           // than the element in the right subarray it
           // is next in the merged list
           if(arr[i] < arr[j])
           {
               temp[k] = arr[i];
               i++;
           }
           else
           {
               temp[k] = arr[j];
               j++;
           }
           k++;
       }
      
       // We may have missed elements from either list
       while(i <= mid)
       {
           temp[k] = arr[i];
           i++;
           k++;
       }
      
       while(j <= to)
       {
           temp[k] = arr[j];
           j++;
           k++;
       }
      
       // Copy over elements from temp to arr
       for(k = from; k <= to; k++)
       {
           arr[k] = temp[k];
       }
   }
}

