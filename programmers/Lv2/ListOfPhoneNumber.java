import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        // phone_book
        // 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려고 한다
        // 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사
        // 구조대 : 119
        // 지영석 : 1195524421

        // 12
        // 123
        // 1235
        // 567
        // 88

        // 효율성 테스트 때문에 추가
        Arrays.sort(phone_book);

        for(int i = 0 ; i < phone_book.length; i++){
            String str = phone_book[i];
            int strLength = phone_book[i].length();

            if(i==phone_book.length-1){
                continue;
            }

            int j=i+1;

            if(strLength<=phone_book[j].length()){
                // substring으로 접두어 비교하기 맞으면 바로 false 리턴
                if(str.equals(phone_book[j].substring(0,strLength))){
                    answer = false;
                    return answer;
                }
            }

        }

        return answer;
    }
}