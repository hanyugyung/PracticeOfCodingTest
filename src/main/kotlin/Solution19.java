import java.util.*;
import java.util.stream.Collectors;

public class Solution19 {

    public static boolean solution(String[] phone_book) {

        if(phone_book.length == 1) return true;

        // 사전순으로 정렬
        List<String> lst = Arrays.stream(phone_book).sorted().toList();

        for(int i = 0 ;i < lst.size()-1 ; i++) {
            if(lst.get(i+1).startsWith(lst.get(i))) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        var answer = solution(new String[]{"119", "97674223", "1195524421"});
        System.out.println(answer);
    }
}
