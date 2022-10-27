import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        // yellow를 기준으로 yellow로 가능한 직사각형 그리고
        // brown과 개수 맞는지 확인하고 맞으면 break 해서 리턴
        for(int i = yellow; i>=1; i--){
            if(yellow%i==0){
                int factor = yellow/i;
                if(brown==(factor*2 + i*2 + 4)){
                    answer[0] = i+2;
                    answer[1] = factor+2;
                    break;
                }
            }
        }

        return answer;
    }
}