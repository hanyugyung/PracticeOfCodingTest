import java.util.Stack;

public class Solution23 {

    public int[] solution(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        for (int i : arr) {
            if (stack.isEmpty()) stack.push(i);
            else {
                if (!stack.peek().equals(i)) stack.push(i);
            }
        }


        return stack.stream().mapToInt(i -> i).toArray();
    }


    public static void main(String[] args) {
        Solution23 solution23 = new Solution23();
        var answer = solution23.solution(new int[]{1, 1, 3, 3, 0, 1, 1});
        System.out.println(answer);
    }
}
