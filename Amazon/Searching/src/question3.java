public class question3 {
    //GFG Amazon Test Series --> Track - Searching
    //Question 3/12 - Missing number in array
    //Difficulty - Easy
    //Expected T.C - O(n) , S.C - O(1)
    //Number of Approaches - 1
    //Date - 03/05/2022

    /*
     Approach - 1

    [Optimised]
    T.C - O(n) ,S.C- O(1)

     Approach -->    i) Since one number is missing to find the actual sum we need to increment the actual length value of array  by 1
                     ii) Count the sum of all elements in the array using stand formula [int sum=(n*(n+1))/2, where n=arr.length + 1 ]
                     iii) Run a loop --> Traverse linearly and subtract each element from the array
                     iv) Return the remaining sum as answer [ The number that is left out at the last is the missing number ]
     */

    static int missingElement(int arr[],int n){
        //Step-1
        int new_arraySize=n+1;

        //Step-2
        int sum=(new_arraySize*(new_arraySize+1))/2;

        //Step-3
        for(int i:arr)
            sum-=i;  //subtracting the array elements from the sum to find the missing element;

        //Step-4
        return sum;  //return the missing number [ the remaining number left in sum after subtracting the elements one by one ]
    }

    public static void main(String[] args) {
        int arr[]={6,1,2,8,3,4,7,10,5};
        int n=arr.length;
        System.out.println(missingElement(arr,n));
    }

}
