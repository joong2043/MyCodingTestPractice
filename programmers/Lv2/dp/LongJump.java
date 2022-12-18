class Solution {
    public long solution(int n) {
        long answer = 0;
        // 총 4칸
        // 1 1 1 1
        // 1 2 1
        // 1 1 2
        // 2 1 1
        // 2 2

        // 1칸 가는 경우
        // dp[1] = 1
        // 2칸 가는 경우
        // dp[2] = 2
        // 3칸 가는 경우
        // dp[3] = 1+2, 2+1 => dp[1] + dp[2]

        // n이 1이나 2인 경우를 대비하여 미리 2001개의 배열을 만들어 놓기
        long[] dp = new long[2001];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i<n+1; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }

        answer = dp[n];

        return answer;
    }
}