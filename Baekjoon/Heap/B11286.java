import java.io.*;
import java.util.*;

// baekjoon_11286

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        //최대힙
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) > Math.abs(o2)){
                    return Math.abs(o1) - Math.abs(o2);
                }
                else if(Math.abs(o1)==Math.abs(o2)){
                    return o1 - o2;
                }
                else {
                    return -1;
                }

            }
        });
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                if (queue.isEmpty()) {
                    bw.write(0+"\n");
                } else {
                    bw.write(queue.poll()+"\n");
                }
            } else {
                queue.offer(n);
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}