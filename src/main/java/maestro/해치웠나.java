package maestro;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 해치웠나 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int count1 = 0;
        int count2 = 0;

        for(int i = 0; i < input.length(); ++i){
            if(input.charAt(i) == '(') count1++;
            else count2++;
        }

        if(count1 == count2){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
