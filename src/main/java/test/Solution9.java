package test;

import java.util.*;

class Balance implements Comparable<Balance>{
    String name;
    Integer balance;
    public Balance(String name, Integer balance){
        this.name = name;
        this.balance = balance;
    }

    @Override
    public int compareTo(Balance o) {

        if(this.balance == o.balance) return this.name.toLowerCase().compareTo(o.name.toLowerCase());
        return o.balance - this.balance;
    }
}

public class Solution9 {
    public static void main(String[] args) {

    }

    public static List<String> smallestNegativeBalance(List<List<String>> debts) {
        List<String> answer = new ArrayList<>();

        Map<String, Integer> balanceInfo = new HashMap<>();
        for(List<String> item : debts){
            String borrower = item.get(0);
            String lender = item.get(1);
            Integer amount = Integer.valueOf(item.get(2));
            balanceInfo.put(borrower, balanceInfo.getOrDefault(borrower, 0) - amount);
            balanceInfo.put(lender, balanceInfo.getOrDefault(lender, 0) + amount);
        }

        List<Balance> negativeBalance = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : balanceInfo.entrySet()){
            if(entry.getValue() < 0){
                negativeBalance.add(new Balance(entry.getKey(), entry.getValue()));
            }
        }

        Collections.sort(negativeBalance);
        int minVal = 0;
        if(negativeBalance.size() != 0){
            minVal = negativeBalance.get(0).balance;
        }
        for(Balance balance : negativeBalance){
            if(minVal == balance.balance)
                answer.add(balance.name);
        }
        if(answer.size() == 0){
            answer.add("Nobody has a negative balance");
        }
        return answer;
    }
}
