import java.io.*;
import java.util.*;

// baekjoon_2745

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();

        StringTokenizer st = new StringTokenizer(line);

        String number = st.nextToken();

        int count = Integer.parseInt(st.nextToken());
        int total = 0;
        for (int i =0; i<number.length(); i++){
            // 문자의 경우
            // 아스키코드로 접근
            // A보다 크거나 같은 문자 -> 숫자화 10 ~ 35
            if (number.charAt(i)>='A'){
                int el = (int) number.charAt(i) - 55;
                total += el * Math.pow(count,number.length()-i-1);
            }
            // 숫자의 경우
            else{
                total += Character.getNumericValue(number.charAt(i)) * Math.pow(count, number.length()-i-1);
            }
        }

        bw.write(total+"");


        bw.flush();
        br.close();
        bw.close();
    }
}