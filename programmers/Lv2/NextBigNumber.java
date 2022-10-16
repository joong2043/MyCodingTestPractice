import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int num = n+1;
        int cnt1 = 0;
        int cnt2 = 0;
        String binaryString = Integer.toBinaryString(n);
        for(int i =0;i<binaryString.length();i++){
            if(binaryString.charAt(i)=='1'){
                cnt1 += 1;
            }
        }
        while(true){
            cnt2 = 0;
            String binaryStringNum = Integer.toBinaryString(num);
            for(int i=0; i<binaryStringNum.length(); i++){
                if(binaryStringNum.charAt(i)=='1'){
                    cnt2+=1;
                }
            }
            if(cnt1==cnt2){
                break;
            }

            num += 1;
        }

        answer = num;
        return answer;
    }
}