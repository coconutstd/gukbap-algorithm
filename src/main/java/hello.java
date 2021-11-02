import java.util.*;

public class hello{
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue);

        for(Integer e : queue){
            System.out.println(e);
        }

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);

        for(Integer e : list) {
            System.out.println(e);
        }

        // hashmap 순
        HashMap<Integer, String> hashmap = new HashMap<>();
        hashmap.put(1, "hello");
        hashmap.put(2, "hello");


        System.out.println(hashmap);

        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);

        for(Integer e : stack) {
            System.out.println(e);
        }

        System.out.println(stack);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        for(Integer e : set) {
            System.out.println(e);
        }

        System.out.println(set);

        String a = "abdcde";
        char[] charArr = a.toCharArray();
        for(int i = 0; i < a.length(); ++i){
            System.out.println(a.charAt(i));
        }


        // primitive 타입 int 정렬
        int[] numArr = new int[]{
                1,23,4
        };
        for(int num : numArr){
            System.out.println(num);
        }


    }
}