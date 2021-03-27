package scofe2;

import java.util.*;
import java.io.*;

class Country{
    int from, to, cost;
    public Country(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

public class Two {

    static ArrayList<Country> graph;
    static int[] p;

    static int find(int x){
        if(x != p[x]){
            return p[x] = find(p[x]);
        } else {
            return p[x];
        }
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a < b){
            p[b] = a;
        } else {
            p[a] = b;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> inputs = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            inputs.add(br.readLine());
        }
        Set<String> country = new HashSet<>();
        for(int i = 0; i < n; ++i){
            String str = inputs.get(i);
            StringTokenizer st = new StringTokenizer(str);
            country.add(st.nextToken());
            country.add(st.nextToken());
        }

        HashMap<String, Integer> hashmap = new HashMap<>();
        int index = 0;
        for(String str : country){
            hashmap.put(str, index++);
        }
        p = new int[hashmap.size()];
        for(int i = 0; i < p.length; ++i) p[i] = i;
        graph = new ArrayList<>();
        for(int i = 0; i < inputs.size(); ++i){
            StringTokenizer st = new StringTokenizer(inputs.get(i));
            graph.add(new Country(hashmap.get(st.nextToken()), hashmap.get(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(graph, (a, b) -> {
            return a.cost - b.cost;
        });

        int answer = 0;

        for(Country city: graph){
            int cost = city.cost;
            int a = city.from;
            int b = city.to;
            if(find(a) != find(b)){
                union(a, b);
                answer += cost;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

/*
6
seoul beijing 3
beijing hawaii 10
seoul tokyo 4
seoul hawaii 6
tokyo hawaii 5
beijing tokyo 5
 */

