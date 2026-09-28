package solutions5;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] weights = {3,2,2,4,1,4};
        int days = 3;
        Solution solution = new Solution();
        System.out.println(solution.shipWithinDays(weights, days));
    }

    public int shipWithinDays(int[] weights, int days) {
       int maxWeight = findMaxWeight(weights);
       int totalWeight = Arrays.stream(weights).sum();
    //   System.out.println("maxWeight "+maxWeight+" totalWeight "+totalWeight);
       return findMinWeight(weights, days, maxWeight, totalWeight);
    }

    private int findMinWeight(int[] weights, int days, int min, int max) {

        while(min < max){

            int mid = (min + max)/2;

           System.out.println("min "+min +" mid "+mid+" max "+max);
            Feasibility feasibility = isFeasible(weights, mid, days);
            if(!feasibility.feasibility){
                 min = mid+1;
            } else {
                 max =mid;
            }

        }
        return min;
    }
    private int findMaxWeight(int[] weights) {
        int maxWeight = 0;
        for (int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
        }
        return maxWeight;
    }

    private Feasibility isFeasible(int[] weights, int capacity, int days) {
        int currentDays = 1;
        int currWeight = 0;
        for(int i = 0; i < weights.length; i++){
            if(currWeight + weights[i] <= capacity){
                currWeight += weights[i];

            } else {
                currentDays++;
                currWeight = weights[i];
            }

            if(currentDays > days) {
                return new Feasibility();
            }


        }
        Feasibility feasibility = new Feasibility();
        feasibility.days = currentDays;
        feasibility.feasibility = true;
        return feasibility;
    }
}

class Feasibility {
    int days = -1;
   boolean feasibility = false;
}
