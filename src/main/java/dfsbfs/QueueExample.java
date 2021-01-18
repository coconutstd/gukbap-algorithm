package dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
