//
//import java.io.*;
//import java.util.*;
//public class 토마토 {
//
//    static int M,N;
//
//    static int[][] arr;
//
//    static boolean[][] visit;
//
//    static int[] dx = { -1, 1, 0, 0};
//    static int[] dy = {0, 0, -1, 1};
//
//    static Queue<Dot> queue = new LinkedList<>();
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        // 토마토는 격자 모양 상자
//        // 토마토 잘 익
//
//        // M, N
//        // M은 상자의 가로 칸 수, N은 상자의 세로 칸 수
//        // 2 <= M, N <= 1000
//        // 둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어짐
//        // 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다
//        // 하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다
//
//        // 토마토가 모두 익을 때까지의 최소 날짜 출력하기
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        M = Integer.parseInt(st.nextToken());
//        N = Integer.parseInt(st.nextToken());
//
//        arr = new int[N][M];
//        visit = new boolean[N][M];
//
//        // 6 , 4
//        for (int i = 0; i < N ; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < M ;j++) {
//                arr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                if (arr[i][j] == 1) {
//                    queue.add(new Dot(i, j , 0));
//                }
//            }
//        }
//
//        int result = bfs();
//        boolean ans = true;
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                if (arr[i][j] == 0) {
//                    ans = false;
//                    break;
//                }
//            }
//        }
//
//        if (!ans) {
//            bw.write(-1+"");
//        } else {
//            bw.write(result+"");
//        }
//
//        bw.flush();
//        br.close();
//        bw.close();
//    }
//
//    // bfs queue visit dx, dy
//
//
//    public static int bfs() {
//
//        int max = 0;
//
//        while (!queue.isEmpty()) {
//
//            Dot pollDot = queue.poll();
//
//            max = Math.max(pollDot.cnt, max);
//
//            for (int i = 0; i < 4; i++) {
//                int nx = pollDot.x + dx[i];
//                int ny = pollDot.y + dy[i];
//                int ncnt = pollDot.cnt;
//
//                if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[0].length) {
//                    continue;
//                }
//
//                if (!visit[nx][ny] && arr[nx][ny] == 0) {
//                    visit[nx][ny] = true;
//                    arr[nx][ny] = 1;
//                    queue.add(new Dot(nx,ny,ncnt+1));
//                }
//            }
//        }
//        return max;
//    }
//
//}
//class Dot {
//    int x;
//    int y;
//    int cnt;
//
//    Dot(int x, int y, int cnt) {
//        this.x = x;
//        this.y = y;
//        this.cnt = cnt;
//    }
//}
