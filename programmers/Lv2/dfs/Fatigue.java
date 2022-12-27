class Solution {
    public static int answer = 0;
    public static boolean[] visit;

    public int solution(int k, int[][] dungeons) {
        // 피로도 시스템
        // 최소 필요 피로도 / 소모 피로도
        // 최소 필요 피로도 : 80
        // 소모 피로도 : 20

        // 탐험 경로
        // 1 2 3
        // 1 3 2
        // 2 1 3
        // 2 3 1
        visit = new boolean[dungeons.length];

        dfs(k, dungeons, 0);

        return answer;
    }

    public void dfs(int hp, int[][] dungeons, int depth){

        for(int i = 0; i<dungeons.length; i++){

            if(visit[i] == false && hp>=dungeons[i][0]){
                // visit[i]를 방문했다는 표시
                visit[i] = true;
                // 재귀 호출 -> hp를 깎고 depth에는 1추가 해서 호출하기
                dfs(hp-dungeons[i][1],dungeons,depth+1);
                // visit[i]를 다시 초기화 해주기 위해 false를 넣어준다.
                visit[i] = false;
            }
        }

        answer = Math.max(answer, depth);
    }
}