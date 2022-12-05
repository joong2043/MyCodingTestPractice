import java.io.*;
import java.util.*;

// baekjoon_9613

public class Main{
    public static long gcd(int a, int b){
        long x = Math.max(a,b);
        long y = Math.min(a,b);

        while (x%y!=0){
            long r = x%y;
            x = y;
            y = r;
        }

        return y;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int lines = Integer.parseInt(br.readLine());

        for (int i = 0 ;i<lines; i++){
            String cases = br.readLine();
            StringTokenizer st = new StringTokenizer(cases);

            int num = Integer.parseInt(st.nextToken());
            int[] numbers = new int[num];
            long gcdTotal = 0;
            for (int j = 0; j<num; j++){
                numbers[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j<num; j++){
                for(int k =j+1; k<num; k++){
                    long gcd = gcd(numbers[j],numbers[k]);
                    gcdTotal += gcd;
                }
            }

            bw.write(gcdTotal+"\n");
        }


        bw.flush();
        br.close();
        bw.close();
    }
}