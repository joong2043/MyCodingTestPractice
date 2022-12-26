import java.io.*;
import java.util.*;

// baekjoon_15649

public class Main{
    private static int[] arr;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int endNum = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        // arr 은 출력되는 배열
        arr = new int[count];
        visited = new boolean[endNum];

        dfs(endNum,count,0);

        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int N, int M, int depth){
        // 재귀 깊이가 M과 같아지면 탐색과정에서 담았던 배열을 출력
        if (depth == M){
            for(int val : arr){
                System.out.print(val+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 0 ; i < N ; i++){

            // 만약 해당 노드를 방문하지 않았다면?
            if (visited[i] == false){
                visited[i] = true; // 해당 노드를 방문 상태로 변경
                arr[depth] = i + 1; // 해당 깊이를 index로 하여 i + 1 값 저장
                dfs(N,M,depth + 1); // 다음 자식 노드 방문을 위해 depth 1 증가시키면서 재귀 호출

                // 자식노드 방문이 끝나고 돌아오면 방문 노드를 방문하지 않은 상태로 변경
                // 이 부분을 처리하지 않으면
                // 1 2
                // 1 3
                // 1 4 에서 출력이 끝나버린다
                visited[i] = false;
            }
        }
        return;
    }
}