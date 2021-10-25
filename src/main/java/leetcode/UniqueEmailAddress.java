package leetcode;

import java.util.*;

public class UniqueEmailAddress {

    public static void main(String[] args) {
           UniqueEmailAddress uem = new UniqueEmailAddress();
           solution(new String[]{
                   "test.email+alex@leetcode.com",
                   "test.e.mail+bob.cathy@leetcode.com",
                   "testemail+david@lee.tcode.com"
           });

    }

    private static int solution(String[] emails){
        Set<String> set = new HashSet<>();

        for(String email : emails) {
            System.out.println(email);
        }

        return set.size();
    }
}
