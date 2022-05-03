public class question5 {
    //GFG Amazon Test Series --> Track - Searching
    //Question 5/12 - Peak Element
    //Difficulty - Easy
    //Expected T.C - O(log n) , S.C - O(1)
    //Number of Approaches - 1
    //Date - 03/05/2022

    /*
    Approach - 1

   [Optimised]

   Using Binary Search
   // we need to return the index of the peek element as per question

   T.C - O(log n) , S.C- O(1)

    Approach -->    1) Take two pointers low--> pointing to 0 and high pointing to --> n-1 ;

                    2) Run Binary Search Condition (ie while low<high [as we check for arr[mid] and arr[mid+1])
                       find out the middle using standard formula;

                       If arr[mid]<arr[mid+1] we increment low = mid+1;
                       Else
                       Set high = mid;

                    3) Finally return low ;
    */
    static int peakElement(int[] arr,int n)
    {
        //Step-1
        int low=0;
        int high=n-1;

        //Step-2
        while(low<high){
            int mid=low+high>>1;
            if(arr[mid]<arr[mid+1])
                low=mid+1;
            else
                high=mid;
        }

        //Step-3
        return low;
    }

    public static void main(String[] args) {
        int arr[]={1,5,3,4,2};
        int n=arr.length;
        System.out.println(peakElement(arr,n));
    }
}
