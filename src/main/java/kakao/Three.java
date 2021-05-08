package kakao;

import java.util.*;

import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < n; ++i) list.add(i);

        int cur = k;
        Stack<Node> memory = new Stack<>();
        for(int i = 0; i < cmd.length; ++i){
            String input = cmd[i];
            char key = input.charAt(0);
            if(key == 'D'){
                cur += Integer.parseInt(String.valueOf(input.substring(2, input.length())));
            } else if(key == 'U'){
                cur -= Integer.parseInt(String.valueOf(input.substring(2, input.length())));
            } else if(key == 'C'){
                memory.push(new Node(cur-1, cur+1, list.get(cur)));
                if(cur == list.size() - 1){
                    list.remove(cur);
                    cur = list.size() - 1;
                } else cur = list.remove(cur);
            } else {
                Node temp = memory.pop();
                if(temp.prev <= cur) cur += 1;
                list.add(temp.prev + 1, temp.value);
            }
        }
        boolean[] check = new boolean[n];
        for(int i = 0; i < list.size(); ++i) check[list.get(i)] = true;

        String answer = "";
        for(int i = 0 ; i < n; ++i) {
            if(check[i] == true){
                answer += "O";
            } else {
                answer += "X";
            }
        }
        return answer;
    }

    class Node {
        int prev, next, value;

        public Node(int prev, int next, int value){
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }
}