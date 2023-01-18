import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.max;

public class Solution17 {

    public static int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m+1][n+1];
        // dp[x][y] => (x,y) 좌표까지 가는 최단 경로 경우의 수
        for(int i = 1; i<= m ; i++) {
            for(int j = 1; j<=n ; j++) {
                // 시작점
                if(i==1 && j ==1) {
                    dp[1][1] = 1;
                    continue;
                }

                if(puddly(i, j, puddles)) dp[i][j] = 0;
                else if(i == 1) { // 위쪽에서 옴
                    dp[i][j] = dp[i][j-1] % 1000000007;
                }
                else if(j==1) { // 왼쪽에서 옴
                    dp[i][j] = dp[i-1][j] % 1000000007;
                }else {
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
                }
            }
        }

        return dp[m][n];
    }

    public static boolean puddly(int x, int y, int[][] puddles){
        for(int [] puddle : puddles) {
            if(puddle[0] == x && puddle[1] == y) return true;
        }

        return false;
    }

    public static void main(String[] args)  {
        var answer = solution(4, 3, new int[][]{{2, 2}});
        System.out.println(answer);
    }
}
