public class Solution20 {

    int[][] picture;

    int m, n;

    int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;

    int tmp = 0;

    int areaValue = -1;

    public int[] solution(int m, int n, int[][] pic) {

        this.picture = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.picture[i][j] = pic[i][j];
            }
        }
        this.m = m;
        this.n = n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                areaValue = picture[i][j];
                if(areaValue != -1 && areaValue == dfs(i, j)) numberOfArea++;
                if(tmp > maxSizeOfOneArea) maxSizeOfOneArea = tmp;
                tmp = 0;
            }
        }

        int[] answer = new int[2];
        answer[0] = this.numberOfArea;
        answer[1] = this.maxSizeOfOneArea;
        return answer;
    }

    public int dfs(int i, int j) {

        if(picture[i][j] == 0) return -1;
        int value = picture[i][j];
        picture[i][j] = 0;
        tmp++;

        for(int k = 0; k < 4; k++) {
            if(!isVisited(i+direction[k][0], j+direction[k][1], value)) {
                dfs(i+direction[k][0], j+direction[k][1]);
            }
        }

        return value;
    }

    public boolean isVisited(int i, int j, int value) {
        if(!(0 <= i && i < m) || !(0 <= j && j < n)) return true;
        if(picture[i][j] == 0 || picture[i][j] != value) return true;
        return false; // false 인 경우 지나갈 수 있음
    }

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        var answer = solution20.solution(3, 4, new int[][]{
                {0, 1, 1, 1}
                , {1, 2, 2, 0}
                , {1, 6, 0, 1}
//                , {0, 4, 0, 1}
//                , {0, 4, 0, 3}
//                , {0, 0, 0, 3}
                });
        System.out.println(answer[0] + " " +answer[1]);
    }

}
