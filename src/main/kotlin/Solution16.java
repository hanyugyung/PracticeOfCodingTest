import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.max;

public class Solution16 {

    public static void main(String[] args) throws IOException {
        var sc = new BufferedReader(new InputStreamReader(System.in));
        var count = Integer.parseInt(sc.readLine());

        var arr = new int[count + 1];

        for (int i = 1; i <= count; i++) {
            arr[i] = Integer.parseInt(sc.readLine());
        }

        Solution solution = new Solution(count, arr);
        System.out.print(solution.solution(count));
    }

    static class Solution {

        private int count;
        private int[] cache;

        private int[] arr;

        Solution(int count, int[] arr) {
            this.count = count;
            cache = new int[count + 1];
            cache[0] = 0;

            this.arr = arr;
        }

        public int solution(int count) {

            if (count == 1) cache[1] = arr[1];
            else if (count == 2) cache[2] = arr[1] + arr[2];
            else if (count == 3) cache[3] = max(arr[1], arr[2]) +arr[3];
            else {
                if(cache[count] == 0) {
                    cache[count] = max(solution(count - 2), solution(count - 3) + arr[count-1]) + arr[count];
                }
            }

            return cache[count];
        }
    }
}
