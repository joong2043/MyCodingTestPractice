import java.util.*;
class Solution {
    int answer = -1;
    public int solution(int N, int number) {

        if(N == number){
            return 1;
        }
        dfs(0,0,number,N);

        return answer;
    }
    // dfs answer = cnt가 되도록

    private void dfs(int cnt, int now, int number, int N){
        // 만약 cnt가 8을 초과하면 answer = -1을 리턴하도록
        if(cnt>8){
            return;
        }

        // 만약 now == number라면
        // answer == -1 혹은 answer>cnt
        if(now == number){
            if(answer == -1 || answer > cnt){
                answer = cnt;
            }
            return;
        }

        // 사칙연산 뿐 아니라 NN...N도 처리
        // 1) dfs + 연산
        // 2) dfs - 연산
        // 3) dfs / 연산
        // 4) dfs * 연산
        int nn = N;
        for(int i =0;i<8-cnt; i++){
            dfs(cnt+i+1, now+nn, number, N);
            dfs(cnt+i+1, now-nn, number, N);
            dfs(cnt+i+1, now / nn, number, N);
            dfs(cnt+i+1, now * nn, number, N);

            nn = nn * 10 +N;
        }
    }

}