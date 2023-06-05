import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N  = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][10];

        // 오르막수 2234 3678 11119
        // 0 1 2 3 4 5 6 7 8 9
        // 00 01 02 03 04 05 .. 09     10개
        // 11 12 13 14 15 16 17 18 19  9개
        // 22 23 24 25 26 27 28 29     8개
        // 33 34 35 36 37 38 39        7개
        // ...
        // 99                          1개

        // dp[1] = 10
        // dp[2] = 55
        // 10 + 9 + 8 + ... + 1


        // dp[2][7] = 2자리의 숫자 길이 중 맨 뒤의 숫자가 7 경우의 수 []7
        // dp[3][7] = 3자리의 숫자 길이 중 맨 뒤의 숫자가 7 경우의 수 [][]7

        // dp[3][7] = dp[2][7] + dp[2][6] + dp[2][5]  ..

        for (int i = 0; i < 10; i++){
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++){
            for (int j = 0; j < 10; j++){
                for (int k = 0; k <=j; k++){
                    dp[i][j] = dp[i][j] + dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 10; i++){
            sum+= dp[N][i];
        }

        bw.write(sum%10007+"");

        bw.flush();
        bw.close();
        br.close();
    }

}