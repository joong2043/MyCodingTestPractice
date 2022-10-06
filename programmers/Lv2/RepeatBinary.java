class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while(s.length() > 1) {

            int cntOne = 0;
            String[] str = s.split("");

            for(int i=0; i<s.length(); i++) {

                if(s.charAt(i) == '0'){
                    answer[1]++;
                }
                else cntOne++;
            }

            s = Integer.toBinaryString(cntOne);
            answer[0]+=1;
        }

        return answer;
    }

}