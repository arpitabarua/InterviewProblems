package solutions10;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args){
      int[] nums = new int[]{1,2,5,9};
      int threshold = 6;
      Solution solution = new Solution();
      System.out.println(solution.smallestDivisor(nums, threshold));
    }

    public int smallestDivisor(int[] nums, int threshold) {
      int max = Arrays.stream(nums).max().getAsInt();

      Arrays.sort(nums);


    return findDivisor(nums, threshold, max);
    }

    private int findDivisor(int[] nums, int threshold, int max){
       int[] divisorArray = IntStream.range(0, max+1).toArray();

        int i =1, j= divisorArray[divisorArray.length-1];
        int minDivisor = Integer.MAX_VALUE;
        while(i <= j){
            int mid = (divisorArray[i]+divisorArray[j])/2;
            int result = getResult(nums, mid);
            if(result > threshold){
                i = mid+1;
                continue;
            } else {
                minDivisor = Math.min(minDivisor, mid);
                j = mid-1;
            }
        }

        return minDivisor;

    }

    private int getResult(int[] nums,  int divisor){
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            result += (int) Math.ceil((double) nums[i]/divisor);
        }
        return result;
    }


}
