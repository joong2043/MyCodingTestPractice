class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        // 2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수
        // 1(0,0) 4(0,1)    3(0,0) 3(0,1)      15(0,0) = a00 * b00+a01*b10 15(0,1) = a00*b01 + a01*b11
        // 3(1,0) 2(1,1)  * 3(1,0) 3(1,1) ->   15(1,0)=a10*b00 + a11*b10 15(1,1)
        // 4(2,0) 1(2,1)                       15(2,0) 15(2,1)

        for(int i = 0 ; i < arr1.length ; i++ ){

            for(int j = 0 ;j < arr2[0].length; j++){

                int sum = 0;

                for(int k = 0 ; k<arr2.length; k++){

                    sum += arr1[i][k] * arr2[k][j];

                }

                answer[i][j] = sum;
            }

        }

        return answer;
    }
}