import java.util.LinkedList;
import java.util.Queue;

public class Solution22 {

    class Location {
        int x;
        int y;

        int distance;

        public Location(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    // 큐를 통해 bfs 알고리즘 사용하여 문제 해결
    public int solution(int[][] map) {
        int answer = 0;

        int[][] direction = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int n = map.length;
        int m = map[0].length;

        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(0, 0, 1));

        // queue 의 remove vs poll : remove() 은 empty queue 인 경우 throw exception, poll() 은 null return
        // queue 의 add vs offer : add() 는 넣을 수 있으면 넣고 true return, 꽉찬 경우 throw exception, offer() 은 넣으면 true, 못넣으면 false
        while(queue.size() > 0) {
            Location location = queue.remove();

            if(location.x == n-1 && location.y == m-1) return location.distance;

            for(int k = 0; k<4; k++) {
                if(available(map, n, m, location.x + direction[k][0], location.y + direction[k][1])){
                    queue.add(new Location(location.x+direction[k][0], location.y+direction[k][1], location.distance+1));
                    map[location.x + direction[k][0]][location.y + direction[k][1]] = 0;
                }
            }
        }


        return -1;
    }

    public boolean available(int[][] map, int n, int m, int x, int y) {
        if(0 > x || x >= n) return false;
        if(0 > y || y >= m) return false;
        if(map[x][y] == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        var answer = solution22.solution(new int[][]{{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}});
        System.out.println(answer);
    }
}
