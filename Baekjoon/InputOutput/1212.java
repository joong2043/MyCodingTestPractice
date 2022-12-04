import java.io.*;
import java.util.*;

import static java.lang.Character.getNumericValue;
// baekjoon_1212

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String st = br.readLine();
        // 10진수로 변환한 뒤 2진수로 변환하면 틀렸습니다로 나옴
//        long totalNum = 0;
//        // 323 -> 3 * 8^2 + 2 * 8^1 + 3 * 8^0
//        // 8진수를 10진수로 변환하기
//        for (int i = 0 ; i<st.length(); i++){
//            char c = st.charAt(i);
//            long eightNum = Character.getNumericValue(c);
//            totalNum += eightNum * (long) Math.pow(8 ,(double) st.length()-i-1);
//
//        }
//
//        // 10진수를 2진수로 변환
//        // 127 ->
//        String numStr = "";
//
//        while (totalNum>0){
//            numStr = String.valueOf(totalNum%2)+numStr;
//            totalNum = totalNum/2;
//        }

        for (int i = 0; i<st.length(); i++){
            char c = st.charAt(i);
            int eightNum = Character.getNumericValue(c);
            String s = Integer.toBinaryString(eightNum);

            if (s.length()==3){
                sb.append(s);
            }
            else if(s.length()==2 && i!=0){
                sb.append("0"+s);
            }
            else if(s.length()==1 && i!=0){
                sb.append("00"+s);
            }
            else {
                sb.append(s);
            }

        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}