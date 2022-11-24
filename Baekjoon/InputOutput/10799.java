import java.io.*;
import java.util.*;

// baekjoon_10799

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        char[] a =str.toCharArray();

        int line = 0;
        int branch = 0;
        char prevChar = ' ';

        for(int i =0; i<a.length; i++){
            if(a[i] == '('){
                if(prevChar == '('){
                    line++;
                    branch++;
                }
            }
            else if(a[i] == ')'){
                if(prevChar == '('){
                    branch = branch + line;
                }
                else if(prevChar == ')'){
                    line-- ;
                }

            }
            prevChar = a[i];

        }

        bw.write(branch+ "");

        bw.flush();
        br.close();
        bw.close();
    }
}