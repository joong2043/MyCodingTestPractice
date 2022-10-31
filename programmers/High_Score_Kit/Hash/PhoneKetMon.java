import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length/2;
        HashSet<Integer> hSet = new HashSet<Integer>();

        for(Integer number : nums){
            hSet.add(number);
        }

        if(hSet.size()>len){
            answer = len;
        }
        else{
            answer = hSet.size();
        }

        return answer;
    }
}
