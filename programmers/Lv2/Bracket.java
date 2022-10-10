class Solution {
    boolean solution(String s) {
        boolean answer = true;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        String str = s;

        int cnt = 0;
        if(str.charAt(0)==')'){
            answer = false;
        }
        else{
            for(int i =0; i<str.length(); i++){
                if(str.charAt(i)=='('){
                    cnt += 1;
                }
                else if(str.charAt(i)==')'){
                    cnt -= 1;
                }

                if(cnt<0){
                    answer = false;
                    break;
                }
            }
        }

        if(cnt!=0){
            answer = false;
        }

        return answer;
    }
}