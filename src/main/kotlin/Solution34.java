import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution34 {

    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();

    public int solution(int[] scoville, int K) {
        this.priorityQueue = getOrderedQueue(scoville);
        if (K == 0 || priorityQueue.peek() >= K) { // 입력값 자체에서 null 방지
            return 0;
        }
        if (this.priorityQueue.size() == 2) {
            int newScoville = makeNewScoville(this.priorityQueue.poll(), this.priorityQueue.poll());
            if (newScoville < K) {
                return -1;
            } else {
                return 1;
            }
        }

        return checkCount(K);
    }

    public PriorityQueue<Integer> getOrderedQueue(int[] scoville) {
        Arrays.stream(scoville).forEach(e -> priorityQueue.add(e));
        return this.priorityQueue;
    }

    private int makeNewScoville(int first, int second) {
        return first + second * 2;
    }

    public int checkCount(int K) {

        int count = 0;
        int first, second;

        while (this.priorityQueue.peek() < K) {

            if(this.priorityQueue.size() == 1) {
                count = -1;
                break;
            }

            count++;
            first = this.priorityQueue.poll();
            second = this.priorityQueue.poll();

            priorityQueue.add(makeNewScoville(first, second));
        }

        return count;
    }

    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        var answer = solution34.solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
        System.out.println(answer);
    }
}
