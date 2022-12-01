import java.io.*;
import java.util.*;
import java.lang.*;
// baekjoon_6588

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] isPrime = new boolean[1000001];
        isPrime[0] = true; // 소수를 false로 함
        isPrime[1] = true;
        // 처음엔 다 prime(false)으로 세팅
        // 배수는 prime이 아니므로 true
        for (int i = 2; i <= (int) Math.sqrt(1000000); i++) {
            for (int j = 2; i * j < 1000001; j++) {
                isPrime[i * j] = true; // 소수가 아님
            }
        }

        // n = a + b
        while (true){
            int a = Integer.parseInt(br.readLine());
            if(a==0){
                break;
            }
            List<Integer> oddList = new ArrayList<>();

            // a보다 작은 소수를 찾는 법
            // 16 -> 2,3,5,7,11,13
            // 42 -> 2(x),3,5,7,11,13,17,19,23,29,31,37,41
//            for (int i = 2; i<= a; i++){
//                boolean isPrime = false;
//
//                for (int j = 2; j< Math.sqrt(i); j++) {
//                    if (i % j == 0) {
//                        isPrime = true;
//                        break;
//                    }
//
//                }
//
//                if (!isPrime && i % 2 == 1) {
//                    oddList.add(i);
//                }
//            }

            boolean[] prime = new boolean[a+1];

            // 소수 배열
            // prime : [true, true, true, .... , true]
            for (int i = 2; i <= a; i++){
                prime[i] = false;
            }

            // i가 제곱근 이하일 경우 계산
            for (int i = 2; i*i<=a; i++){
                // prime[i] 가 소수라면
                if (!prime[i]){
                    // prime[j]가 소수가 아닌걸 표시
                    for(int j = i*i; j<=a; j+=i){
                        prime[j] = true;
                    }
                }
            }

            // 소수 출력
            for (int i =3; i<=a; i++){
                if (!prime[i]){
                    oddList.add(i);
                }
            }

            int endIdx = oddList.size()-1;
            int startIdx = 0;
            while (true){
                int sum = oddList.get(startIdx) + oddList.get(endIdx);
                if (sum==a){
                    bw.write(a+" = "+oddList.get(startIdx)+" + "+oddList.get(endIdx)+"\n");
                    break;
                }
                else if(sum > a){
                    endIdx--;
                }
                else if(sum < a){
                    startIdx++;
                }

            }

        }


        bw.flush();
        br.close();
        bw.close();
    }
}