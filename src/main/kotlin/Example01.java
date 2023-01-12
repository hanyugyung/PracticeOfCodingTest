import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example01 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("3D*3T#3D*"));
    }
}

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int tmp = 0;
        int preScore = 0; // 이전 점수 저장용 변수

        Pattern pattern = Pattern.compile("[0-9]+[SDT]\\W?");
        Matcher m = pattern.matcher(dartResult);
        while(m.find()) {
            String dart = m.group();

            int score = 0;
            if(dart.startsWith("10")) score = 10;
            else score = Integer.parseInt(dart.substring(0, 1));

            String area = "S";
            if(dart.contains("D")) area = "D";
            if(dart.contains("T")) area = "T";

            String bonus = "";
            if(dart.contains("*")) bonus = "*";
            if(dart.contains("#")) bonus = "#";

            // 계산
            if(area.equals("S")) {
                tmp = score;
            } else if(area.equals("D")) {
                tmp = score*score;
            } else if (area.equals("T")){
                tmp = score*score*score;
            }

            if(bonus.equals("*")) {
                tmp = tmp * 2 + preScore;
                preScore = tmp - preScore;
            } else if(bonus.equals("#")) {
                tmp *= (-1);
                preScore = tmp;
            } else {
                preScore = tmp;
            }

            answer += tmp;
        }

        return answer;
    }
}