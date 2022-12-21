import java.io.*;
import java.util.*;

// baekjoon_2468

public class Main{

    static int[][] arr;
    static int[] cnt;
    static int N;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        cnt = new int[3];

        for (int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j=0;
            while (st.hasMoreTokens()){
                arr[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        divide(0,0,N);

        bw.write(cnt[0]+"\n"+cnt[1]+"\n"+cnt[2]);
        bw.flush();
        br.close();
        bw.close();
    }

    // 해당 사각형 안에 모두 같은 수로 이뤄져있는지 확인
    private static boolean check(int row, int col, int len) {
        int tmp = arr[row][col];
        for (int i = row; i < row + len; i++) {
            for (int j = col; j < col + len; j++) {
                if (tmp != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // 가로와 세로를 3등분하여 총 9개의 조각으로 나누는 함수 + 같은 수들로 이뤄졌을 때를 체크
    private static void divide(int row, int col, int len) {
        if (check(row, col, len)) { // 같은 수로 되어 있을 때
            cnt[arr[row][col] + 1]++;
        } else {    // 같은 수로 되어있지 않을 때
            int newLen = len / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    divide(row + newLen * i, col + newLen * j, newLen);
                }
            }
        }
    }

}