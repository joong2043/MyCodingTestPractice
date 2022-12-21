import java.io.*;
import java.util.*;

// baekjoon_2468

public class Main{

    static int[][] arr;
    static boolean[][] dfsVisited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static ArrayList<Integer> dfsVisitedList = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        int answer = 0;
        int maxHeight = 0;
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > maxHeight){
                    maxHeight = arr[i][j];
                }
                j++;
            }
        }

        for (int height = 0; height<maxHeight+1; height++){
            int cnt = 0;
            dfsVisited = new boolean[N][N];
            for (int j = 0; j<N; j++){
                for (int k =0; k<N; k++){
                    // dfsVisited가 false이고 arr 값이 하이트보다 크면
                    // cnt가 추가됨
                    if (!dfsVisited[j][k] && arr[j][k]>height){
                        cnt ++;
                        dfs(j,k,height); // 안전영역인지 탐색하기
                    }
                }
            }
            // 만약 cnt가 answer보다 크면 answer = cnt
            if (cnt > answer){
                answer = cnt;
            }
        }
        bw.write(answer+"");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int x,int y, int height){
        dfsVisited[x][y] = true;
        for (int i =0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx<0 || ny<0 || nx > N-1 || ny > N-1){
                continue;
            }
            if (dfsVisited[nx][ny]==true){
                continue;
            }

            if (arr[nx][ny]>height){
                dfs(nx,ny,height);
            }

        }

    }
}