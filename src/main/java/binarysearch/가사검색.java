package binarysearch;

public class 가사검색 {
    public static void main(String[] args) {
        String[] words = new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] quires = new String[]{"fro??", "????o", "fr???", "fro???", "pro?"};
        solution(words, quires);
    }

    public static boolean check(String word, String query){
        for(int i = 0; i < query.length(); ++i){
            if(query.charAt(i) != '?' && query.charAt(i) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        int count = 0;
        for(int i = 0; i < queries.length; ++i){
            for(int j = 0; j < words.length; ++j){
                if(words[j].length() != queries[i].length()) continue;
                if(check(words[j], queries[i])) count++;
            }
            answer[i] = count;
            count = 0;
        }
        return answer;
    }
}


/*
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (0.28ms, 52.9MB)
테스트 2 〉	통과 (0.17ms, 52.2MB)
테스트 3 〉	통과 (0.20ms, 52.2MB)
테스트 4 〉	통과 (0.18ms, 52.3MB)
테스트 5 〉	통과 (0.11ms, 52.6MB)
테스트 6 〉	통과 (0.17ms, 51.9MB)
테스트 7 〉	통과 (8.48ms, 53MB)
테스트 8 〉	통과 (9.75ms, 52.1MB)
테스트 9 〉	통과 (7.54ms, 53MB)
테스트 10 〉	통과 (5.93ms, 54.5MB)
테스트 11 〉	통과 (5.79ms, 52.3MB)
테스트 12 〉	통과 (10.12ms, 52.8MB)
테스트 13 〉	통과 (35.43ms, 53.6MB)
테스트 14 〉	통과 (32.62ms, 54MB)
테스트 15 〉	통과 (37.86ms, 53.6MB)
테스트 16 〉	통과 (33.28ms, 55MB)
테스트 17 〉	통과 (31.07ms, 56MB)
테스트 18 〉	통과 (26.98ms, 54MB)
효율성  테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	실패 (시간 초과)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	통과 (22.78ms, 59.8MB)
테스트 5 〉	통과 (28.59ms, 59.7MB)
채점 결과
정확성: 25.0
효율성: 30.0
합계: 55.0 / 100.0
 */