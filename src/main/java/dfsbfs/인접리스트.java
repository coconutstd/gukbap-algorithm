package dfsbfs;

import java.util.ArrayList;

public class 인접리스트 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < 5; ++i){
            adjList.add(new ArrayList<Integer>());
        }

        adjList.get(0).add(2);
        adjList.get(0).add(3);

        for(int i = 0; i < adjList.size(); ++i){
            System.out.println("정점 " + i + "의 인접리스트");
            for(int j = 0; j <adjList.get(i).size(); ++j){
                System.out.println(" -> " + adjList.get(i).get(j));
            }
            System.out.println();
        }
    }
}
