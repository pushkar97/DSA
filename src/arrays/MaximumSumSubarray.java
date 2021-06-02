package arrays;
//Q: find sub-array from given array with max sum
public class MaximumSumSubarray {

    //runs nested for loop and checks for all the possible sub-arrays and calculates sum for each.
    // T: O(N^2)
    // S: O(1)
    public int bruteForce(int[] a) {
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    //discards the sub-array if it does not add value to current element, that is the sub-array sum is negative
    //following code is optimized for negative elements array and will return 0 as empty array is also a sub-array
    // T: O(N)
    // S: O(1)
    public int kadanesAlgorithm(int[] a) {
        int maxSum = 0;
        int currSum = 0;
        for(int i : a){
            currSum = Math.max(i, currSum + i);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,1,-4,3,2,-5,4};
        MaximumSumSubarray p = new MaximumSumSubarray();
        System.out.println("Brute Force : "+p.bruteForce(input));
        System.out.println("Kadane's Algorithm : "+p.kadanesAlgorithm(input));
    }
}
