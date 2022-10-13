class Solution {
    public int solution(int n) {
        int answer = 1;
        for(int i = 1; i<=n; i++){
            int total = i;
            int j = i+1;
            while(n >= total){
                total = total + j;
                if(total == n){
                    answer++;
                    break;
                }
                j++;
            }
        }
        return answer;
    }
}