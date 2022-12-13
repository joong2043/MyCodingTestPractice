import java.io.*;
import java.util.*;

// baekjoon_16194

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 4
        // 1 5 6 7 -> 1*4 = 4가 최소
        // 5
        // 10 9 8 7 6 -> 6*1 = 6이 최소

        int[] cardPacks = new int[N+1];
        int[] dp = new int[N+1];
        // dp[N] -> N개의 카드를 구매하기 위한 최소 비용
        // N개의 카드 구매를 위해서는 i개의 카드를 가진 카드팩을 구매하고 N-i개의 카드를 추가로 구매하면 된다
        // -> dp[N] = dp[i] + dp[N-i]

        for(int i = 1; i <= N; i++){
            cardPacks[i] = Integer.parseInt(st.nextToken());
            // dp의 값이 0이면 최소값 비교가 부정확해지므로 큰 수를 임의로 집어넣기
            dp[i] = 10000000;
        }

        for (int i = 1; i<=N; i++){
            for (int j =1; j<=i; j++){
                dp[i] = Math.min(dp[i], dp[i-j] + cardPacks[j]);
            }
            System.out.println(dp[i]);

        }

        bw.write(dp[N]+"");


        bw.flush();
        br.close();
        bw.close();
    }
}