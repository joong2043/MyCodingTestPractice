import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        // 인풋 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 아웃풋 처리하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 인풋의 띄어쓰기에 따라 String 분리를 위한 StringTokenizer
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        String a;
        int b;
        int backNum = 0;
        Queue<Integer> queue = new LinkedList<Integer>();

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            a = st.nextToken();
            if(a.equals("push")){
                b = Integer.parseInt(st.nextToken());
                queue.offer(b);
                backNum = b;
            }
            else if(a.equals("front")){
                if(queue.isEmpty()){
                    bw.write(-1+"\n");
                }
                else{
                    bw.write(queue.peek()+"\n");
                }
            }
            else if(a.equals("back")){
                if(queue.isEmpty()){
                    bw.write(-1+"\n");
                }
                else{
                    bw.write(backNum+"\n");
                }
            }
            else if(a.equals("size")){
                bw.write(queue.size()+"\n");
            }
            else if(a.equals("empty")){
                if(queue.isEmpty()){
                    bw.write(1+"\n");
                }
                else{
                    bw.write(0+"\n");
                }
            }
            else if(a.equals("pop")){
                if(queue.isEmpty()){
                    bw.write(-1+"\n");
                }
                else{
                    bw.write(queue.remove()+"\n");

                }
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}