import java.io.*;
import java.util.*;

// baekjoon_2156

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] wines = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i<N; i++){
            int wine = Integer.parseInt(br.readLine());
            wines[i]= wine;
        }

        dp[0] = wines[0];

        if (N>1){
            dp[1] = wines[0] + wines[1];
        }
        if (N>2){
            dp[2] = Math.max(dp[1],Math.max(wines[0] + wines[2], wines[1] + wines[2]));
        }

        // (i-2번째까지의 최대값 + i번째의 wine)과 (i-3번째까지의 최대값 + i-1번째, i번째 wine)과 (i번째 wine을 선택하지 않은 i-1번째까지의 최대값) 중 최대값을 구하면 된다
        for (int i = 3; i<N; i++){
            dp[i]=Math.max(dp[i-1], Math.max(dp[i-2]+wines[i], dp[i-3]+wines[i-1]+wines[i]));
        }

        bw.write(dp[N-1]+"");

        bw.flush();
        br.close();
        bw.close();
    }
}