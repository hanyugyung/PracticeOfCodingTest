import java.util.Stack;

public class Solution24 {

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] cArr = s.toCharArray();

        if(cArr[0] == ')' || cArr[s.length()-1] == '(') return false;

        int total = s.length();

        if(total % 2 == 1) return false;

        for(int i = 0; i< total ;i++) {
            if(stack.isEmpty()) {
                if(cArr[i] == ')') return false;
                else stack.push(cArr[i]);
            }
            else {
                if(cArr[i] == ')') {
                    if (stack.peek() == '(') stack.pop();
                    else return false;
                } else stack.push(cArr[i]);
            }
        }


        return stack.isEmpty();
    }


    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        var answer = solution24.solution("(()(");
        System.out.println(answer);
    }
}
