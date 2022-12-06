import java.io.*;
import java.util.*;

// baekjoon_11653

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for(int i = 2 ; i<=num; i++){
            while (num%i==0){
                num = num / i;
                bw.write(i +"\n");
            }

        }

        bw.flush();
        br.close();
        bw.close();
    }
}