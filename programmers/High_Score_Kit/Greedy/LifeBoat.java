import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = people.length;
        Arrays.sort(people);
        // 20 30 50 55 60 70 80 120 140
        // 30 110 150
        int left = 0;
        int right = people.length -1;

        while(left < right){
            if((people[left] + people[right]) <= limit){
                answer -=1;
                left +=1;
                right -=1;
            }
            else{
                right -=1;
            }
        }

        return answer;
    }
}