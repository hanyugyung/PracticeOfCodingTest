import java.util.LinkedList;
import java.util.Queue;

public class Solution65 {

    public class Location {
        int x;
        int y;
        int distance;

        public Location() {

        }

        public Location(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public int solution(String[] maps) {
        int answer = 0;
        int m = maps.length;
        int n = maps[0].length();

        int [][] dic = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        String[][] strMaps = new String[m][n];
        Location start = new Location();
        Location exit = new Location();
        Location lever = new Location();
        for (int i = 0; i < maps.length; i++) {
            strMaps[i] = maps[i].split("");
            if (maps[i].contains("S")) {
                start = new Location(i, maps[i].indexOf("S"), 0);
            }
            if (maps[i].contains("E")) {
                exit = new Location(i, maps[i].indexOf("E"), 0);
            }
            if (maps[i].contains("L")) {
                lever = new Location(i, maps[i].indexOf("L"), 0);
            }
        }

        // bfs
        Queue<Location> queue = new LinkedList<>();
        queue.add(start);

        // 레버까지
        while(!queue.isEmpty()) {
            Location loc = queue.poll();

            if(loc.x == lever.x && loc.y == lever.y) {
                answer = loc.distance;
                start.x = lever.x;
                start.y = lever.y;
                break;
            }

            for(int i = 0; i < 4; i++) {
                if(available(strMaps, m, n, loc.x+dic[i][0], loc.y+dic[i][1], "1")) {
                    queue.add(new Location(loc.x+dic[i][0], loc.y+dic[i][1], loc.distance+1));
                    strMaps[loc.x+dic[i][0]][loc.y+dic[i][1]] = "1";
                }
            }
        }

        if(answer == 0) return -1;

        queue.clear();
        queue.add(start);

        // 레버에서 출구까지
        while(!queue.isEmpty()) {
            Location loc = queue.poll();

            if(loc.x == exit.x && loc.y == exit.y) {
                answer += loc.distance;
                return answer;
            }

            for(int i = 0; i < 4; i++) {
                if(available(strMaps, m, n, loc.x+dic[i][0], loc.y+dic[i][1], "2")) {
                    queue.add(new Location(loc.x+dic[i][0], loc.y+dic[i][1], loc.distance+1));
                    strMaps[loc.x+dic[i][0]][loc.y+dic[i][1]] = "2";
                }
            }
        }


        return -1;
    }

    public boolean available(String[][] map, int m, int n, int x, int y, String passed) {
        if (0 > x || x >= m) return false;
        if (0 > y || y >= n) return false;
        if (map[x][y].equals("X")) return false;
        if (map[x][y].equals(passed)) return false;
        return true;
    }

    public static void main(String[] args) {
        Solution65 solution65 = new Solution65();
        var answer = solution65.solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"});
        System.out.println(answer);
    }
}
