import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        int curPos = n;
        // 목적지를 정해놓고 목적지에서 출발지로 간다는 생각으로 접근 : top-down 방식
        // 짝수의 경우 무조건 순간이동이 유리, 홀수의 경우 -1을 하여 앞으로 가는 것이 유리

        while(curPos!=0){
            if(curPos%2==0){
                curPos = curPos/2;
            }
            else{
                curPos = curPos - 1;
                ans++;
            }
        }

        return ans;
    }
}