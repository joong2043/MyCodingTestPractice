import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        // yellow_hat headgear
        // blue_sunglasses eyewear
        // green_turban headgear

        // 경우의 수 찾기 -> gear개수 * eyewear 개수

        // 스파이는 매일 다른 옷을 조합하여 입어 자신을 위장
        HashMap<String, Integer> maps = new HashMap<>();
        // maps에서 키값이 없다면 value 값에 0, 키값이 있다면 value 값에 +1 추가
        for(int i = 0 ; i < clothes.length ; i++){
            maps.put(clothes[i][1], maps.getOrDefault(clothes[i][1],0)+1);
        }

        // maps에서 해당 하는 value 값을 곱한다
        // +1을 더한 상태에서 곱하는 이유는 그 옷 하나만 입는 경우도 고려해야 하기 때문이다
        for(String clothKind : maps.keySet()){
            answer *= (maps.get(clothKind)+1);
        }

        System.out.println(maps);

        // answer에서 1을 빼주는 이유는 모든 옷을 벗고 있는 경우는 없기 때문
        answer -= 1;


        return answer;
    }
}