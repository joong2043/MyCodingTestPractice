import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        // 선행 스킬
        // 스파크 -> 라이트닝 볼트 -> 썬더 일때, 썬더를 배우려면 먼저 라이트닝 볼트를 배워야하고 라이트닝 볼트를 배우려면 먼저 스파크를 배워야함
        // 스파크 -> 힐링 -> 라이트닝볼트 -> 썬더
        // 썬더 -> 스파크나 라이트닝볼트 ->스파크->힐링->썬더와 같은 스킬트리는 불가능한다

        // "CBD" STACK D > B > C
        // "BACDE"
        // Map.put("C",1), Map.put("B",2), Map.put("D",3)

        String[] array = skill.split("");



        HashMap<String,Integer> hashMap = new HashMap<>();

        for(int i = 0; i<array.length; i++){
            hashMap.put(array[i],i+1);
        }

        for(int i = 0 ; i<skill_trees.length ; i++){
            int value = 1;
            String[] tree = skill_trees[i].split("");
            for(int j = 0; j<tree.length; j++){
                if(!hashMap.containsKey(tree[j])){
                    continue;
                }
                if(hashMap.get(tree[j]) == value){
                    value++;

                    System.out.println(value);
                }
                else{
                    answer--;
                    break;
                }
            }
            System.out.println();
            answer++;
        }

        return answer;
    }
}