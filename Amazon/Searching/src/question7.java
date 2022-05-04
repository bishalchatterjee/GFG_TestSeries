import java.util.ArrayList;
import java.util.Arrays;

public class question7 {
    //GFG Amazon Test Series --> Track - Searching
    //Question 7/12 - Counting elements in two array
    //Difficulty - Easy
    //Expected T.C - O((M+N)*log n) , S.C - O(1)  //where M & N are  length's of first and second array respectively
    //Number of Approaches - 1
    //Date - 04/05/2022

    /*
    Approach - 1

   [Optimised]

   Using Binary Search
   T.C - O(log n) , S.C- O(1)

    Approach -->     ----//Main Function----
                    1) Make a new arraylist for answer

                    2) Sort the second array
                       Run a loop from 0 to length of fist array
                       int x = Call the helperBinarySearch Function with the array 2 & arr1[i] as parameters

                       If (x==-1) then add n to the arraylist
                       Else
                       Add x to the array list

                    3) Finally return the arraylist



                    ----//HelperBinarySearch (Celling Function)----

                       Takes two arguments --> an array and an integer

                       i) Initialise res as -1;
                          low=0, high= array.length-1;

                       ii) While(low<=high)
                           Find the middle
                           check if the array[middle] is > x or <= x
                           i) If > x , then store mid in res;
                                       and set high = mid - 1;
                           ii) If <= x , then set low = mid + 1;

                       iii) Return the res

    */

    //main function
    static ArrayList<Integer> countElementsInTwoArray(int arr1[],int arr2[], int m , int n){
        //Step-1
        ArrayList<Integer> result = new ArrayList<>();

        //Step-2
        Arrays.sort(arr2);

        for (int i = 0; i < m ; i++) {
            int x=helperBinarySearch(arr2,arr1[i]);
            if(x==-1) result.add(n);
            else result.add(x);
        }

        //Step-3
        return result;
    }

    //helper function
    static int helperBinarySearch(int arr[],int n){
        //step-i
        int ans=-1;
        int low=0;
        int high=arr.length-1;

        //step-ii
        while (low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid] > n){
                ans=mid;
                high=mid-1;
            }else if(arr[mid] <= n) low = mid + 1;
        }
       //step-iii
        return ans;
    }

    public static void main(String[] args) {
        int arr1[] = {1,2,3,4,7,9};
        int arr2[] = {0,1,2,1,1,4};
        int m = arr1.length, n = arr2.length;
        System.out.println(countElementsInTwoArray(arr1,arr2,m,n));
    }
}
