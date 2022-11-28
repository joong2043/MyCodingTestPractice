import java.io.*;
import java.util.*;

// baekjoon_1918

public class Main{
    public static int precedence(char c){
        if(c == ')' || c== '('){
            return 0;
        }
        else if(c == '+' || c =='-'){
            return 1;
        }
        else{
            return 2;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a;
        // 태그 안 문자인지 태그 밖 문자인지 구분하기 위한 boolean 변수
        Stack<Character> stacks = new Stack<>();
        a = br.readLine();

        for(int i = 0;i < a.length(); i++){
            if(a.charAt(i)>='A' && a.charAt(i)<='Z'){
                bw.write(a.charAt(i));

            }
            else if(a.charAt(i)==')'){

                while(!stacks.empty()){
                    char temp = stacks.pop();
                    if(temp == '('){
                        break;
                    }
                    bw.write(temp);
                }
            }
            else if(a.charAt(i)=='('){
                stacks.push(a.charAt(i));
            }
            else{
                while (!stacks.empty() && precedence(stacks.peek())>=precedence(a.charAt(i))){
                    bw.write(stacks.pop());
                }
                stacks.push(a.charAt(i));

            }

        }
        while (!stacks.empty()){
            bw.write(stacks.pop());
        }

        bw.flush();
        br.close();
        bw.close();
    }
}