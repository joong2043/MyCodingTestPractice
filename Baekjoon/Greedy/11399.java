import java.io.*;
import java.util.*;
import java.lang.*;
// baekjoon_11399

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int[] atms = new int[num];
        int k = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;

        while (st.hasMoreTokens()){
            atms[k] = Integer.parseInt(st.nextToken());
            k++;
        }

        Arrays.sort(atms);

        for (int i = 0; i<atms.length;i++){
            for (int j = 0; j<=i; j++){
                sum += atms[j];
            }
        }

        bw.write(sum+"");

        bw.flush();
        br.close();
        bw.close();
    }
}