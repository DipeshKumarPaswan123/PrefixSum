package com.anonymous.p1;

/**
 * Description of the class or purpose.
 *This program implements the Prefix Sum algorithm in Java. The goal is to calculate the maximum subarray sum using an optimized approach with a prefix sum array.
 *
 * Key Features:
 * - The prefix sum array is built by storing the cumulative sum of elements up to each index.
 * - Once the prefix sum array is created, the sum of any sub-array can be calculated in constant time.
 * - This reduces the time complexity of calculating sub-array sums from O(n^3) to O(n^2).
 * - The program first calculates the prefix sum for the input array, then iterates through all possible subarrays to find and print the maximum subarray sum.
 *
 * This solution demonstrates a step toward optimizing sub-array sum calculations in competitive programming.
 * @author DIPESH
 * @date 9/19/2024
 */
public class PrefixSum {
    public static void prefixSum(int number[]){
        int maxSum = 0;
        int currSum = 0;
        int prefix[] = new int[number.length];
        prefix[0] = number[0];
        for(int i = 1; i<prefix.length;i++){
            prefix[i] = prefix[i-1] + number[i];
        }
        for(int i = 0; i<number.length;i++){
            int start = i;
            for(int j = i; j<number.length;j++){
                int end = j;
                currSum = start == 0 ? prefix[end]: prefix[end] - prefix[start-1];
                if(maxSum  < currSum){
                    maxSum = currSum;
                }
            }
        }
        System.out.println("max sum = " + maxSum);
    }
    public static void main(String[] args) {
        int number[] = {2,4,6,8,10};
        prefixSum(number);
    }
}
