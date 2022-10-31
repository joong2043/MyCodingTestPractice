import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int number : scoville){
            queue.add(number);
        }

        while(queue.peek()<K){
            queue.add(queue.poll()+queue.poll()*2);
            answer++;

            if(queue.peek()<K&&queue.size()==1){
                answer = -1;
                break;
            }
        }

        return answer;
    }
}
