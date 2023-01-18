import java.util.Arrays;

public class Solution18 {

    public static int solution(int[] nums) {
        int count = (int) Arrays.stream(nums).distinct().count();
        return Math.min(count, nums.length / 2);
    }

    public static void main(String[] args)  {
        var answer = solution(new int[]{3,1,2,3});
        System.out.println(answer);
    }
}
