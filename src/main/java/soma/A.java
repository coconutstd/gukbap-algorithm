package soma;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<Character> set = new HashSet<>();
        while(st.hasMoreTokens()){
            set.add(st.nextToken().charAt(0));
        }

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        HashMap<Character, ArrayList<Character>> skills = new HashMap<>();

        Character[] list1 = new Character[n];
        Character[] list2 = new Character[n];
        for(int i = 0; i < n; ++i){
            st = new StringTokenizer(br.readLine());
            Character a = st.nextToken().charAt(0);
            Character b = st.nextToken().charAt(0);
            list1[i] = a;
            list2[i] = b;
            skills.put(a, skills.getOrDefault(a, new ArrayList<>()));
            set.remove(b);
        }

        for(int i = 0; i < n; ++i){
            skills.get(list1[i]).add(list2[i]);
        }

        for(Character ch : set){
            ArrayList<Character> answer = new ArrayList<>();
            answer.add(ch);
            Character cur = ch;
            while(true){
                if(skills.get(cur).size() == 0) break;
                for(int i = 0; i < skills.get(cur).size(); ++i){
                    answer.add(skills.get(cur).get(i));
                }

            }
            if(answer.size() == 1) continue;
            else {

            }
        }


        for(Character ch : set){
            bw.write(ch + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

/*
h g f w r
4
h g
h f
g r
g w
 */