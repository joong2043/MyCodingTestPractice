class Solution {
    // 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인즈를 return
    // [1 2 3 2 3]
    // 1초 시점의 1은 끝까지 가격이 떨어지지 않는다
    // 2초 시점의 2는 끝까지 가격이 떨어지지 않는다
    // 3초 시점의 3은 1초 뒤에 가격이 떨어진다
    // 4초 시점의 2는 1초간 가격이 떨어지지 않는다
    // 5초 시점의 3은 0초간 가격이 떨어지지 않는다

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0; i<prices.length; i++){
            // i가 prices.length-1인 경우에는 어차피 0이므로 continue 진행
            if(i==prices.length-1){
                continue;
            }

            // i가 prices.length-1보다 작은 경우 우측 요소들과 비교를 해야함
            for(int j = i+1; j<prices.length; j++){
                if(prices[i]<=prices[j]){
                    answer[i] += 1;
                }
                else{
                    // 바로 다음 주식 가격이 작이지더라도 1초는 추가해야 함
                    answer[i]+=1;
                    break;
                }
            }

        }

        return answer;
    }
}