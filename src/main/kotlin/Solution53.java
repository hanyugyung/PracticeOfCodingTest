import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Solution53 {

    List<Integer> lst = new ArrayList<>();

    public int solution(int storey) {
        int answer = 0;
        dfs(1, storey, 0, 1);

        return Collections.min(lst);
    }

    public void dfs(int n, int storey, int curr, int call) {
        if( n== String.valueOf(storey).length()) {
            int first = Integer.parseInt(String.valueOf(storey).substring(0, 1));
            lst.add(curr + Math.min(first, (10-first)+1));
        } else{
            String str = String.valueOf(storey);
            int a = Integer.parseInt(str.substring(str.length()-call));

            int first = Integer.parseInt(String.valueOf(a).substring(0, 1));

            dfs(n+1, storey+(int)(Math.pow(10, call))-a, curr + 10-first, call+1);
            dfs(n+1, storey-a, curr+first, call+1);
        }
    }

    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        var answer = solution53.solution(2554);
        System.out.println(answer);
    }
}
