import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution21 {
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize == 0) return cities.length * 5;

        Queue<String> queue = new LinkedList<>();
        for(String s : cities) {
            if(queue.contains(s.toLowerCase())) {
                queue.remove(s.toLowerCase());
                queue.add(s.toLowerCase());
                answer += 1;
            } else {
                answer += 5;
                if(queue.size() == cacheSize) {
                    queue.poll();
                }
                queue.add(s.toLowerCase());
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        var answer = solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"});
        System.out.println(answer);
    }
}
