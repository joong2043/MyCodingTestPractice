import java.io.*;
import java.util.*;
import java.lang.*;
// baekjoon_6588

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] meetings = new int[num][2];
        int cnt = 0;

        int endTime = 0;
        for (int i = 0 ; i < num; i++){
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if (o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });


        for(int i = 0 ; i< num ; i++){
            //만약 미팅의 시작시간이 기존 끝나는 시간보다 클 경우
            if (endTime <= meetings[i][0]){
                endTime = meetings[i][1];
                cnt++;
            }
        }

        bw.write(cnt+"");

        bw.flush();
        br.close();
        bw.close();
    }
}