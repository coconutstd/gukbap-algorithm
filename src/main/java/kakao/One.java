package kakao;

class One {
    public int solution(String s) {
        String answer = "";
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                answer += ch;
                continue;
            } else {
                if(ch == 'z'){
                    answer += 0;
                    i += 3;
                } else if(ch == 'o') {
                    answer += 1;
                    i += 2;
                } else if(ch == 'e') {
                    answer += 8;
                    i += 4;
                } else if(ch == 'n') {
                    answer += 9;
                    i += 3;
                } else if(ch == 't' && s.charAt(i + 1) == 'w'){
                    answer += 2;
                    i += 2;
                } else if(ch == 't' && s.charAt(i + 1) == 'h'){
                    answer += 3;
                    i += 4;
                } else if(ch == 'f' && s.charAt(i + 1) == 'o'){
                    answer += 4;
                    i += 3;
                } else if(ch == 'f' && s.charAt(i + 1) == 'i'){
                    answer += 5;
                    i += 3;
                } else if(ch == 's' && s.charAt(i + 1) == 'i'){
                    answer += 6;
                    i += 2;
                } else {
                    answer += 7;
                    i += 4;
                }
            }
        }
        return Integer.parseInt(answer);
    }
}