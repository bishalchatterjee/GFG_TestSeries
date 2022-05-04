public class question6 {
    //GFG Amazon Test Series --> Track - Searching
    //Question 6/12 - Index Of an Extra Element
    //Difficulty - Easy
    //Expected T.C - O(log n) , S.C - O(1)
    //Number of Approaches - 2
    //Date - 04/05/2022

    /*
    Approach - 1

   [UnOptimised]

   T.C - O(n) , S.C- O(1)

    Approach -->    1) Simply run a loop from 0 to length-2

                    2) Check for equality
                       i) If True Continue iterating;
                       ii) If False return current 'i'

                    3) Return n-1 if all elements match for both the array ;


    Code     -->

    class Solution {
       public int findExtra(int a[], int b[], int n) {
           for(int i=0; i<a.length-1;i++){
              if(a[i]!=b[i]){
               return i;
              }
         }

          return n-1;
      }
   }
    */


      /*
    Approach - 2

   [Optimised]

   Using Binary Search


   T.C - O(log n) , S.C- O(1)

    Approach -->    1) Take two pointers low--> pointing to 0 and high pointing to --> n-1 ;

                    2) Run Binary Search Condition (ie while low<high )
                       find out the middle using standard formula;

                       If a[mid]>=b[mid] we increment low = mid+1;

                       Else If (a[mid]<b[mid]) we Set high = mid;

                    3) Finally return low ;
    */

    static int findExtra(int a[], int b[], int n) {
        int low=0,high=n-1;

        while (low<high){
            int mid=low+(high-low)/2;
            if(a[mid]>=b[mid])
                low=mid+1;
            else if (a[mid]<b[mid])
                high=mid;
        }
        return low;
    }

    public static void main(String[] args) {
       int a[] = {3,5,7,9,11,13};
       int b[] = {3,5,7,11,13};
       int n=6;
        System.out.println(findExtra(a,b,n));
    }
}
