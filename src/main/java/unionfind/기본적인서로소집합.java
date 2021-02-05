package unionfind;

import java.util.Scanner;

public class 기본적인서로소집합 {

    static int v, e;
    static int[] parent;

    static int findParent(int x){
        if(parent[x] != x){
            // findParent(2) 는 findParent(1)의 리턴값을 받아 parent[2] = 1 로 대입(상관없지만, 중간 경로들을 항상 루트 노드로 갱신한다는 보장), parent[3] = findParent(2)의 리턴값 1을 받아 1로 갱신
            return parent[x] = findParent(parent[x]);
        }
        // findParent(1) 호출시 리턴
        return parent[x];
    }

    static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a < b){
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        parent = new int[v + 1];
        for(int i = 1; i < v + 1; ++i){
            parent[i] = i;
        }

        for(int i = 0; i < e; ++i){
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionParent(a, b);
            for(int j = 1; j < v + 1; ++j){
                System.out.print(parent[j] + " ");
            }
        }

        System.out.print("각 원소가 속한 집합: ");
        for(int i = 1; i < v + 1; ++i){
            // 결국 마지막에 findParent 한 번씩 해줘야
            System.out.print(findParent(i) + " ");
        }
        System.out.println();

        System.out.print("부모 테이블: ");
        for(int i = 1; i < v + 1; ++i){
            System.out.print(parent[i] + " ");
        }
    }
}
