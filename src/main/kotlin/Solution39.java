public class Solution39 {
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int m = arr1.length;
        int n = arr2[0].length;
        int k = arr1[0].length; // == arr2.length

        int[][] answer = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                for (int s = 0; s < k; s++) {
                    answer[i][j] += arr1[i][s] * arr2[s][j];
                }

            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        var answer = solution39.solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}});
    }
}
