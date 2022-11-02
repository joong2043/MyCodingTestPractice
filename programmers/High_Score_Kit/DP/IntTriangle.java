import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        // len = 5
        int len = triangle.length;

        int[][] dp = new int[len][len];
        dp[0][0] = triangle[0][0];

        for(int i =1; i<len; i++){
            dp[i][0] = dp[i-1][0]+triangle[i][0];

            for(int j =1; j<=i; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1])+triangle[i][j];
            }

            dp[i][i] = dp[i-1][i-1] +triangle[i][i];
        }

        for(int i = 1; i<len; i++){
            answer = Math.max(answer, dp[len-1][i]);
        }

        return answer;
    }
}