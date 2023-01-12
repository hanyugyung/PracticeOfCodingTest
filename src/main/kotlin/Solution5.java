import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Solution5 {

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(
                Arrays.asList(solution5.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})));
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {

        List<String> lst1 = toStringBinary(n, arr1);
        List<String> lst2 = toStringBinary(n, arr2);

        List<String> answerLst = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String[] str1 = lst1.get(i).split("");
            String[] str2 = lst2.get(i).split("");
            StringBuilder loadBuilder = new StringBuilder();
            for(int j = 0; j < n; j++){
                if(str1[j].equals("1") || str2[j].equals("1")) {
                    loadBuilder.append("#");
                }
                else loadBuilder.append(" ");
            }
            answerLst.add(loadBuilder.toString());
        }

        return answerLst.toArray(new String[n]);
    }

    public List<String> toStringBinary(int n, int[] arr1) {
        List<String> lst = new ArrayList<>();
        for(int i : arr1) {
            StringBuilder binary = new StringBuilder();
            while(i > 0) {
                binary.insert(0, (i % 2));
                i /= 2;
            }
            if(binary.length() < n) {
                int tmp = binary.length();
                for( int j = 1; j <= (n- tmp) ; j++ ) {
                    binary.insert(0, "0");
                }
            }
            lst.add(binary.toString());
        }
        return lst;
    }
}
