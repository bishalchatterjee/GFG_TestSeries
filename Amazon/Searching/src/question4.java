public class question4 {
    //GFG Amazon Test Series --> Track - Searching
    //Question 4/12 - Find Transition Point
    //Difficulty - Easy
    //Expected T.C - O(log n) , S.C - O(1)
    //Number of Approaches - 2
    //Date - 03/05/2022

    /*
     Approach - 1

    [Un-Optimised]
    T.C - O(n) , S.C- O(1)

     Approach -->    i) Check base case if the length is 0 then return -1
                     ii) Run a loop --> Traverse linearly each element check if it's the transition point or no [ ie switch from 0's window to 1's window ] Return the current index ie i as the transition point
                     iii) Return -1 if the transition point is not found.


     Code     -->

     class GfG {
    int transitionPoint(int arr[], int n) {

    //Step-1
        if(arr.length==0) {
			return -1;
		}

	//Step-2
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==1) {
				return i;
			}

		}

		//Step-3
		return -1;
	}
    }

     */

    /*
     Approach - 2

    [Optimised]

    Using Binary Search [Since we are given the array is sorted]

    T.C - O(log n) , S.C- O(1)

     Approach -->    1) i) Take two pointers low--> pointing to 0 and high pointing to --> n-1 ;
                        ii) Answer Variable --> initialised as -1;
                     2) Run Binary Search Condition (ie while low<=high)
                        find out the middle using standard formula;

                        If arr[mid]==1 --> So current index ie mid is the transition point
                        i) Store the current mid(transition point) in ans variable
                        ii) Set high = mid - 1;
                        Else
                        Set Low = mid - 1;

                     3) Finally return the ans;
     */

    static int findTransitionPoint(int arr[],int n){
        //Step-1
        int low=0,high=n-1;
        int ans=-1;

        //Step-2
        while(low<=high){
            int mid=(low+high)>>1;   //finding middle //Alternate int mid= low+(high-low)/2;
            if(arr[mid]==1){
                ans=mid;
                high=mid-1;
            }else
                low=mid+1;
        }

        //Step-3
        return ans;
    }

    public static void main(String[] args) {
        int arr[]={0,0,0,0,1,1};
        int n=arr.length;
        System.out.println(findTransitionPoint(arr,n));
    }
}
