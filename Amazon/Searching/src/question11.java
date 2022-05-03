public class question11 {
    //GFG Amazon Test Series --> Track - Searching
    //Question 11/12 - Smallest positive missing number
    //Difficulty - Medium
    //Expected T.C - O(n) ,S.C - O(1)
    //Number of Approaches - 3
    //Date - 02/05/2022

    /*
    Approach - 1

    [BruteForce]

    Using Nested loops
    T.C - O(n^2)

    Working of the Algorithm - Find all the numbers form 1 to n if any element is missing return it as answer

     */



    /*
    Approach - 2

    [Slight Optimisation Using By Sorting the array ]

    Working of the Algorithm - O(n) Using a single loop for finding the missing number but sorting takes O(n log n)

    Overall T.C - O(n log n)
     */


    /*
    Approach - 3

    [Optimised]
    Understanding [https://www.youtube.com/watch?v=QeBvfH1dpOU]
    T.C - O(n) , S.C - O(1)


    Step-1 --> Mark element which are out of range and manage presence of one

    Step-2 --> Map elements with index

    Step-3 --> Find out the smallest positive missing integer



     */

    //Approach 3 Code
    static int firstMissingPositive(int[] arr) {

        //Step-1
        boolean one = false; //to check present of 1 in the array as 1 is the smallest positive number
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1)
                one = true;

            //check the possible range [ie 1<=missing_element<=n ]
            // if invalid make the elements 1
            if (arr[i] < 1 || n < arr[i]) {
                arr[i] = 1;
            }
        }
        if (!one) return 1; //if 1 itself is not present then return 1 as it's the smallest positive missing number in this case;

        //Step-2
        for (int i = 0; i < n; i++) {
            int index = Math.abs(arr[i]);
//            System.out.println("Current Element is "+arr[i]+" Current index is "+index); // debugging statement
            arr[index - 1] = -Math.abs(arr[index - 1]); //get the index and make it negative
        }

        //Step-3
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) return i + 1;  //if element is +ve that means index+1 is the smallest positive missing number from the array;
        }
        return n + 1;  //If no such number is found return the length incremented by 1 as the number
    }

    public static void main(String[] args) {
        int arr[]={-23,-2,0,1,2,4,6};
//        int arr[]={1,2,3,4};
        System.out.println(firstMissingPositive(arr));
    }
}

