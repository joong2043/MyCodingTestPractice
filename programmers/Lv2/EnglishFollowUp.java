import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        //번호
        int num = 0;
        // 순번
        int turn = 0;

        // 마지막 글자 저장을 위한 전역 변수
        String lastWord = "";

        HashMap<String,Integer> hashMap = new HashMap<>();

        for(int i = 0; i < words.length ; i++){

            // 해당 단어의 길이
            int len = words[i].length();

            if(i==0){
                lastWord=words[i].substring(len-1,len);
                hashMap.put(words[i],0);
                continue;
            }

            String firstWord = words[i].substring(0,1);

            if((!firstWord.equals(lastWord)) || hashMap.containsKey(words[i])){
                num = (i+1) % n;
                turn = ((i+1) / n) + 1;

                // 나머지가 0인 경우 num = 사람수 , turn은 하나를 빼기
                if(num == 0){
                    num = n;
                    turn = turn - 1;
                }
                // 5 / 2 -> 2
                break;
            }
            else{
                hashMap.put(words[i],0);
            }

            lastWord = words[i].substring(len-1,len);
            System.out.println(lastWord);

        }

        answer[0] = num;
        answer[1] = turn;
        return answer;
    }
}
