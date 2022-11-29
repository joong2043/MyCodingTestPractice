import java.io.*;
import java.util.*;

// baekjoon_1978

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a;
        a = br.readLine();
        StringTokenizer st;
        int number = Integer.parseInt(a);
        int cnt = 0;
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<number; i++){
            int num = Integer.parseInt(st.nextToken());
            boolean isPrime = true;

            // num이 1인 경우 소수 조건에서 제외
            if(num==1){
                continue;
            }
            else if(num==2){
                cnt += 1;
            }
            else {
                for (int j = 2; j < num; j++) {
                    if (num % j == 0) {
                        isPrime = false;
                    }
                }
                if(isPrime==true){
                    cnt+=1;
                }
            }
        }

        bw.write(cnt+"");

        bw.flush();
        br.close();
        bw.close();
    }
}