package 테스트;

import java.util.*;

public class Two {
    public String solution(String[] research, int n, int k) {
        String answer = "";

        Set<Character> searchWord = new HashSet<>();
        for(String rsh : research){
            for(int i = 0; i < rsh.length(); ++i){
                searchWord.add(rsh.charAt(i));
            }
        }
        int cols = research.length;

        HashMap<Character, Integer> perDayRate = new HashMap<>();
        HashMap<Character, ArrayList<Integer>> keywordRate = new HashMap<>();
        for(Character ch : searchWord) {
            keywordRate.put(ch, new ArrayList<>());
        }

        for(String rsh : research){
            for(int i = 0; i < rsh.length(); ++i){
                Character ch = rsh.charAt(i);
                perDayRate.put(ch, perDayRate.getOrDefault(ch, 0) + 1);
            }
            for(Character ch : searchWord){
                if(!perDayRate.containsKey(ch)){
                    perDayRate.put(ch, 0);
                }
            }
            for(Map.Entry<Character, Integer> entry : perDayRate.entrySet()){
                Character key = entry.getKey();
                Integer value = entry.getValue();
                keywordRate.get(key).add(value);
                perDayRate.put(key, 0);
            }
        }

        HashMap<Character, Integer> issueCount = new HashMap<>();
        int minCnt = 2 * n * k;
        for(Map.Entry<Character, ArrayList<Integer>> entry : keywordRate.entrySet()){
            int cnt = 0;
            for(int i = 0; i < cols; ++i){
                int sum = 0;
                boolean isIssue = true;
                for(int j = i; j < i + n && j < cols; ++j){
                    int val = entry.getValue().get(j);
                    if(val < k) {
                        isIssue = false;
                        break;
                    }
                    sum += val;
                }
                if(isIssue && sum >= minCnt){
                    cnt++;
                }
            }
            issueCount.put(entry.getKey(), cnt);
        }

        List<HashMap.Entry<Character, Integer>> entryList = new LinkedList<>(issueCount.entrySet());
        entryList.sort(new Comparator<HashMap.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        boolean isNone = true;
        for(Map.Entry<Character, Integer> entry : entryList){
            if(entry.getValue() != 0){
                isNone = false;
                answer = entry.getKey().toString();
                break;
            }
        }

        if(isNone) answer = "None";

        return answer;
    }
}
