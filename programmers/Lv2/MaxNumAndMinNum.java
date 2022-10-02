import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] sList = s.split(" ");
        int[] sIntList = new int[sList.length];
        for(int i = 0 ; i<sList.length; i++){
            sIntList[i] = Integer.parseInt(sList[i]);
        }

        int maxNum = sIntList[0];
        int minNum = sIntList[0];
        for(int i=0;i < sIntList.length;i++){
            if(sIntList[i]>maxNum){
                maxNum = sIntList[i];
            }
            if(sIntList[i]<minNum){
                minNum = sIntList[i];
            }
        }

        //for(int num : sIntList){
        //    if(num > maxNum){
        //        maxNum = num;
        //    }
        //}


        //String maxNumber = Integer.toString(maxNum);
        //String minNumber = Integer.toString(minNum);

        //answer += minNumber;
        //answer += " ";
        //answer += maxNumber;

        answer = minNum + " " + maxNum;

        return answer;
    }
}