package queue;

import java.util.*;

class Node {
    int index;
    int value;
    public Node(int index, int value){
        this.index = index;
        this.value = value;
    }
}

public class 프린터큐 {
    public static void main(String[] args){
        solve();
    }
    public static void solve(){
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int test = 0; test < testCase; ++test){
            int n = sc.nextInt();
            int k = sc.nextInt();

            Queue<Node> q = new LinkedList<>();
            for(int i = 0; i < n; ++i){
                int p = sc.nextInt();
                q.offer(new Node(i, p));
            }

            int cnt = 0;
            while(!q.isEmpty()){
                Node cur = q.poll();
                boolean check = false;
                int size = q.size();
                for(int i = 0; i < size; ++i){
                    Node temp = q.poll();
                    if(cur.value < temp.value) check = true;
                    q.offer(temp);
                }
                if(check){
                    q.offer(cur);
                } else {
                    cnt++;
                    if(k == cur.index) {
                        System.out.println(cnt);
                    }
                }
            }
        }
    }
}
