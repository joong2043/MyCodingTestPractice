import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        // 체육복을 가지고 있는 학생 수 = 전체 학생수 - 잃어버린 학생 수
        answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 여벌을 가져온 학생이 도난당한 경우 -> 해당 학생은 체육복을 빌려줄 수 없으나 본인은 체육 수업을 들을 수 있음
        for(int i =0; i < reserve.length; i++){
            for(int j =0;j<lost.length; j++){
                if(reserve[i] == lost[j]){
                    reserve[i] = 100;
                    lost[j] = 100;
                    answer++;
                    break;
                }
            }
        }

        // 여벌 체육복이 있는 학생은 양옆번호 학생에게 체육복을 빌려줄 수 있음. 이미 빌려주었다면 다른 학생에게는 빌려줄 수 없다.
        for(int i =0;i<reserve.length; i++){
            for(int j =0; j<lost.length;j++){
                if(reserve[i]!=100 && lost[j]!= 100){
                    // 차이의 절대값이 1
                    if(Math.abs(reserve[i]-lost[j])==1){
                        reserve[i] = 100;
                        lost[j] = 100;
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}