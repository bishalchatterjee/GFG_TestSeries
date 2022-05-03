public class question1 {
    //GFG Amazon Test Series --> Track - Searching
    //Question 1/12 - Square root of a number (without using Math.sqrt())
    //Difficulty - Medium
    //Expected T.C - O(log n) , S.C - O(1)
    //Number of Approaches - 2
    //Date - 02/05/2022

    /*
     Approach - 1

    [Optimised] [Unnecessary traversal]

    Using Optimised loop traversal [ traversing only the perfect squares less than x ; while skipping non-perfect square numbers]
    T.C - O(n) ,S.C- O(1)

     Approach -->    i) Check if the number is 1 then return 1 as answer
                     ii) Run a loop from 2 and traverse all perfect squares until the last perfect square which is <= x is found then store it in ans variable;
                     iii) Finally return answer
     Code     -->
class Solution
{
 long floorSqrt(long x)
 {
  if(x==1) //base case
      return x;
      long ans = 1;
      for(int i=2; i*i<=x; i++){
          ans = i;
      }
      return ans;
 }
}
     */

    /*
    Approach - 2

    [Optimised]

    Binary Search based searching
    T.C - O(log n) ,S.C- O(1)

    Approach & Working --> (we have to return the floor of n if n itself is not a perfect square [e.g- if n=5 then Output is 2 ]
    Step-1 --> Take two pointers low and high ;
               Low points to 0 and high points to n+1

    Step-2 --> Apply Binary Search Condition ( ie while low<high )
               Find the middle using standard formula

               check if the mid * mid > than given number or not
               i) if true reduce the high window and let it point to mid as new high;
               ii)if false increment the low window and let it point to mid + 1;

               A point comes while low and high becomes equal and tend to cross each other
               while loop breaks

    Step-3 --> Finally return low-1 [ low was incremented by 1 just before termination condition of while loop turned true so low-1 is out answer ]

     */

    static long floorSquareRoot(long n){
        //If n is not a perfect square, floor of square_root of n is to be returned as answer.
        long low=0;  //initialise low as 0
        long high=n+1; //high as n+1

        while(low<high){  //binary search condition
            long mid=low+(high-low)/2;  //find middle
            if(mid*mid>n)  //if square of middle is greater than given n then we reduce high to mid
                high=mid; //new high is mid while low is still 0
            else
                low=mid+1; // otherwise,if square of mid is less than n then we increment low to mid + 1
        }
        return low-1;  //finally, return low-1
    }

    public static void main(String[] args) {
        long n=5;
        System.out.println(floorSquareRoot(n));

    }
}
