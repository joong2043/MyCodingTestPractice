import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<Integer>();


        Queue<Integer> myPro = new LinkedList<Integer>();

        for(int i = 0; i<progresses.length; i++){
            myPro.add((int) (Math.ceil((100.0-progresses[i])/speeds[i])));
        }

        // 큐의 요소 값에서 변화를 줘야 할 때 사용해야 하는 것
        // poll해서 꺼내놓고 그 뒤에 반복문 사용하는 방법도 있다

        while(!myPro.isEmpty()){
            int firstEl = myPro.poll();
            int cnt = 1;
            while(!myPro.isEmpty() && firstEl>=myPro.peek()){
                cnt++;
                myPro.poll();
            }
            answer.add(cnt);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}