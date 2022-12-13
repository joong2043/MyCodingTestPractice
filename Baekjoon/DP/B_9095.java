import java.io.*;
import java.util.*;

// baekjoon_16194

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 4
//        3+1 -> 3을 만드는 경우의 수에서 1을 더함 -> 경우의 수는 3을 만드는 경우의 수와 동일
//        2+2 -> 2를 만드는 경우의 수에서 2를 더함 -> 경우의 수는 2를 만드는 경우의 수와 동일
//        1+3 -> 1을 만드는 경우의 수에서 3을 더함 -> 경우의 수는 1을 만드는 경우의 수와 동일

        //5
//        4+1 -> 4를 만드는 경우의 수에서 1을 더함 -> 경우의 수는 4를 만드는 경우의 수와 동일
//        3+2 -> 3을 만드는 경우의 수에서 2를 더함 -> 경우의 수는 3을 만드는 경우의 수와 동일
//        2+3 -> 2를 만드는 경우의 수에서 3을 더함 -> 경우의 수는 2를 만드는 경우의 수와 동일
        int[] dp = new int[12];
        // 1
        dp[1] = 1;
        // 1+1, 2
        dp[2] = 2;
        // 1+1+1, 1+2, 2+1, 3
        dp[3] = 4;

        for (int i = 4 ; i < 12; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for (int i = 0 ; i < N; i++){
            int num = Integer.parseInt(br.readLine());

            bw.write(dp[num]+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}