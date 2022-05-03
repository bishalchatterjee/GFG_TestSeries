public class question2 {
    //GFG Amazon Test Series --> Track - Searching
    //Question 2/12 - Majority Element
    //Difficulty - Medium
    //Expected T.C - O(n) , S.C - O(1)
    //Number of Approaches - 2
    //Date - 03/05/2022

    /*
     Approach - 1

    [Time Optimised]

    Using HashMap
    T.C - O(n) ,S.C- O(n)

     Approach -->    Storing Frequency of each element in HashMap as key value pair
                     Returning the element with  freq > n/2


     Code     -->
class Solution
{
    static int majorityElement(int a[], int size)
    {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<size;i++)
        map.put(a[i],map.get(a[i])==null?1:map.get(a[i])+1);  //storing frequency of each element


        for(int i=0;i<size;i++)
        if(map.get(a[i]) > size/2) return a[i];   //checking condition and returning answer

        return -1;
    }
}
     */

    /*
    Approach - 2

    [Time & Space Optimised]


    Moore's Voting Algorithm Based Solution
    T.C - O(n) ,S.C- O(1)

    Approach & Working --> youtube.com/watch?v=AoX3BPWNnoE

    (Assumption in Step-1 & 2  -->  the majority element is present)
    Step-1 --> Take two variables count and candidate ;
               Initialise both as 0;

    Step-2 --> Traverse Linearly

               check for two conditions
               i) If count of the current element is 0 --> store it in candidate variable;
               ii)If the current element == candidate increment the count by 1;
                  else
                  decrement the count by 1;

    (What if the majority element is missing or not found)
    Step-3 --> i) We reinitialize count to 0 ; //which stores the majority element
               ii) We then run a for each loop and check if the potential_candidate matches with any element in the array ;
               iii) We increment the count and if count > (n>2) return potential_candidate as our answer else -1 as majority element is not found;
     */

    static int majorityElement(int arr[],int n){
        //Step-1
        int count=0;
        int potential_candidate=0;

        //Step-2
        for(int i:arr){
            if(count == 0) potential_candidate=i;

            if(i==potential_candidate) count+=1;
            else
                count-=1;

        }

        //Step-3
        count=0;
        for(int i:arr)
            if(potential_candidate==i) count++;
        return (count>n/2)?potential_candidate:-1;
    }

    public static void main(String[] args) {
//        int arr[]={2,2,3,2,1,2,3,3,3,3,3};
        int arr[]={1,2,3};
        System.out.println(majorityElement(arr,arr.length));
    }
}
