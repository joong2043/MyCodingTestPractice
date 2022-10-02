import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";

//        모든 글자+공백을 배열화
        String[] str = s.toLowerCase().split("");

//        전 글자가 공백이였는지 확인하기 위함
        boolean space = true;

//        전 글자가 공백이면 현재 글자는 대문자로
        for(String ss : str){
            answer += space ? ss.toUpperCase() : ss;

            space = ss.equals(" ")?true:false;
        }

        return answer;
    }
}