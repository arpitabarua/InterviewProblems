package solutions14;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.goodBinaryStrings(4,9,2,1);

        System.out.println(result);


    }


    public int goodBinaryStrings(int minLength, int maxLength, int oneGroup, int zeroGroup) {

        return calculateInt(minLength, maxLength, oneGroup, zeroGroup, 0, new HashMap<Integer, Integer>());


    }

    public int calculateInt(int minLength, int maxLength, int oneGroup, int zeroGroup, int length, HashMap<Integer, Integer> map) {

        if (length >= maxLength) {
            return 0;
        }
        if(map.containsKey(length)) {
            return map.get(length);
        }

        int finalResult = 0;
        int newLength  = length + oneGroup;
        int add = newLength>=minLength && newLength<=maxLength ? 1 : 0;

            finalResult = (calculateInt(minLength, maxLength, oneGroup, zeroGroup, newLength, map) + add) % (1000000000 + 7);




        int zeroResult = length + zeroGroup;


        add = zeroResult>=minLength && zeroResult<=maxLength ? 1 : 0;

            int tempResult = (calculateInt(minLength, maxLength, oneGroup, zeroGroup, zeroResult, map) + add) % (1000000000 + 7) ;

            finalResult = (finalResult +tempResult) % (1000000000 + 7);



        map.put(length, finalResult);


        return finalResult;
    }
    
}
