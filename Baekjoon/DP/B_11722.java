import java.io.*;
import java.util.*;

// baekjoon_2156

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        6
//        10 30 10 20 20 10
        // n-1보다 작으면?, n-2보다 작으면
        // 0 0 1 1 1 3
        // 30 20 10

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i<= N; i++){
            int number = Integer.parseInt(st.nextToken());
            arr[i] = number;
        }

        dp[1] = 1;

        for (int i = 2; i<=N; i++){
            dp[i] = 1;
            for(int j=1;j<i;j++){
                // dp값이 나보다 크거나 같고 arr값이 나보다 큰 경우
                if (arr[i]<arr[j] && dp[i]<=dp[j]){
                    dp[i] = dp[j]+1;
                }
                else if(arr[i]==arr[j]){
                    dp[i] = dp[j];
                }
            }
        }

        bw.write(Arrays.stream(dp).max().getAsInt()+"");

        bw.flush();
        br.close();
        bw.close();
    }
}