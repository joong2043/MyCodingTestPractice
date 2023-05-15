import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{
    static int len;
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 총 배열 개수
        int num = Integer.parseInt(br.readLine());

        // StringBuilder 선언
        StringBuilder sb = new StringBuilder();


        for (int q = 0 ; q < num ; q++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 이차원 배열 길이
            len = Integer.parseInt(st.nextToken());

            map = new int[len][len];

            int[][] arr = new int[len][len];

            int angle = Integer.parseInt(st.nextToken());

            // angle 45로 나눈 값 = r
            int r = angle/45;

            for (int i = 0 ; i < len; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < len; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    map[i][j] = value;
                    arr[i][j] = value;
                }
            }

            // r에 해당하는 만큼 회전 반복문 진행
            for (int i = 0; i < Math.abs(r); i++){
                if (angle > 0){
                    rotateRight();
                }
                else{
                    rotateLeft();
                }
            }

            for (int i = 0; i < len; i++){
                for (int j = 0; j < len; j++){
                    // 만약 map에 요소가 0일 경우 arr에 있는 값을 그대로 가져오기
                    if (map[i][j] == 0){
                        map[i][j] = arr[i][j];
                    }
                    sb.append(map[i][j]+" ");
                }
                sb.append("\n");
            }
        }
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    // 45도 회전
    public static void rotateRight(){
        int[][] temp = new int[len][len];

        for (int i = 0; i < len; i++){
            temp[i][len/2] = map[i][i]; // 주 대각선 요소를 중간열 요소에 대입
            temp[i][i] = map[len/2][i]; // 중간 행 요소를 주 대각선 요소에 대입
            temp[len/2][i] = map[len-i-1][i]; // 중간 행 요소를 부 대각선 요소에 대입
            temp[len-i-1][i] = map[len-i-1][len/2]; // 부 대각선 요소를 중간 열 요소에 대입
        }
        //map 배열에 회전을 완료한 temp 배열을 대입
        map = temp;
    }

    public static void rotateLeft(){
        int[][] temp = new int[len][len];

        for (int i = 0; i < len; i++){
            temp[i][len/2] = map[i][len-i-1]; // 부 대각선 요소를 중간 열 요소에  대입
            temp[i][i] = map[i][len/2]; // 중간 열 요소를 주 대각선 요소에 대입
            temp[len/2][i] = map[i][i]; // 주 대각선 요소를 중간 행 요소에 대입
            temp[len-i-1][i] = map[len/2][i]; // 중간 행 요소를 부 대각선 요소에 대입
        }
        // map 배열에 회전을 완료한 temp 배열을 대입
        map = temp;
    }


}