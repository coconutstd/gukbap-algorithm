package greedy;

public class 조이스틱 {

    static int solution(String name){
        int answer = 0;
        String tmp = "";
        int index = 0;
        for(int i = 0; i < name.length(); ++i) tmp += "A";
        while(true){
            int left = 1;
            int right = 1;
            if(name.equals(tmp)) break;
            answer += Math.min(name.charAt(index) - 'A', 'Z' - name.charAt(index) + 1);
            name = name.substring(0, index) + 'A' + name.substring(index + 1);
            for(int i = 1; index + i < name.length(); ++i){
                if(name.charAt(index + i) == 'A') right += 1;
                else break;
            }
            for(int i = 1; i < name.length(); ++i) {
                int minusIndex = index - i < 0 ? name.length() - i : index - i;
                if(name.charAt(minusIndex) == 'A') left += 1;
                else break;
            }
            if(right > left){
                answer += left;
                index = index - left < 0 ? name.length() - left : index - left;
            } else {
                answer += right;
                index = index + right >= name.length() ? index + right - name.length() : index + right;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("AABAAAAAAABBB"));
    }
}
