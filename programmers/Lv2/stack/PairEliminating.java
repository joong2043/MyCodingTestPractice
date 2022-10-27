import java.util.*;
// 짝짓기 관련 문제는 스택을 떠올립시다!
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }

        if(stack.isEmpty()){
            answer = 1;
        }
        else{
            answer = 0;
        }

        return answer;
    }
}