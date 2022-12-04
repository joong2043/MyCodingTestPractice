import java.lang.*;

class Solution {

    public static int gcd(int a, int b){
        int x = Math.max(a,b);
        int y = Math.min(a,b);

        // 유클리드 호제법
        // 나머지가 0이 될 때까지 나머지를 계속해서 구한다
        // 최종적으로 남은 나머지가 최대공약수가 된다
        while((x%y)!=0){
            int r = x%y;
            x=y;
            y=r;
        }

        return y;
    }

    public int solution(int[] arr) {
        int answer = arr[0];

        // 최대공약수, 최소공배수 -> 유클리드 호제법 사용

        for(int i = 1 ; i<arr.length; i++){
            int gcd = gcd(answer,arr[i]);

            answer = answer*arr[i]/gcd;
        }

        return answer;
    }
}