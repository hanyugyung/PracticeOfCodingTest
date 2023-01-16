import java.util.Arrays;

public class Solution15 {

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        System.out.println(
                solution15.solution(
                        new int[][]{new int[]{7}, new int[]{3, 8}, new int[]{8, 1, 0}, new int[]{2, 7, 4, 4}, new int[]{4, 5, 2, 6, 5}}));
    }

    public int solution(int[][] triangle) {
        int depth = triangle.length;

        for(int i = 0 ; i<depth; i++) {
            for(int j = 0; j<triangle[i].length; j++) {
                if(i == 0 && j == 0) continue;
                else if(j==0) triangle[i][j] += triangle[i-1][j];
                else if(j==triangle[i].length-1) triangle[i][j] += triangle[i-1][j-1];
                else triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }
        }

        return Arrays.stream(triangle[depth-1]).max().orElse(-1);
    }
}
