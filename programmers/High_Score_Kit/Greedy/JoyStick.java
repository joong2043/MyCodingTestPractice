import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        // 조이스틱 방향
        // 시작이 AAA
        // JAZ
        // 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성
        // 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동
        // 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성

        // 첫번째 문자를 목표하는 값으로 셋팅 -> 다음 두번째 문자로 이동
        // 알파벳 이동 -> 쉬움
        // 커서 이동 -> 어려움

        int next;
        // 만약 AAA 이면 move는 2
        int move = name.length() - 1 ;

        for(int i =0 ;i<name.length(); i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            // 현재 문자열 내 문자의 위치 = i
            // 다음 문자 위치 = index
            next = i + 1;

            // 다음 문자의 위치가 문자열 안이고 다음 문자가 A이면
            // 또 다음 문자로 이동하기
            while(next<name.length() && name.charAt(next)=='A'){
                next++;
            }

            // 순서대로 가는 것과 뒤로 돌아가는 것 중 이동수가 적은 것
            move = Math.min(move, i*2+name.length()-next);

            // BBBBAAAAAAB와 같이 처음부터 뒷 부분을 먼저 입력하는 것이 더 빠른 경우
            move = Math.min(move, (name.length()-next)*2+i);

        }

        return answer+move;
    }
}