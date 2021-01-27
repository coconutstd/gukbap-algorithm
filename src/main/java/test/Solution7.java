package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/*
26th May 1960  1960-05-26
20th Sep 1958
16th Mar 2068
25th May 1912
16th Dec 2018
26th Dec 2061
 */


public class Solution7 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("26th May 1960");
        preprocessDate(list);
    }
    public static List<String> preprocessDate(List<String> dates) {
        // Write your code here
        List<String> answer = new ArrayList<>();

        for(String beforeString : dates){
            String[] splitedString = beforeString.split(" ");

            String day = "";
            for(int i = 0; i < splitedString[0].length(); ++i){
                if(Character.isDigit(splitedString[0].charAt(i))){
                    day += splitedString[0].charAt(i);
                }
            }
            day = day.length() == 1 ? "0" + day : day;

            String month = "";
            switch (splitedString[1]){
                case "Jan":
                    month += "01";
                    break;
                case "Feb":
                    month += "02";
                    break;
                case "Mar":
                    month += "03";
                    break;
                case "Apr":
                    month += "04";
                    break;
                case "May":
                    month += "05";
                    break;
                case "Jun":
                    month += "06";
                    break;
                case "Jul":
                    month += "07";
                    break;
                case "Aug":
                    month += "08";
                    break;
                case "Sep":
                    month += "09";
                    break;
                case "Oct":
                    month += "10";
                    break;
                case "Nov":
                    month += "11";
                    break;
                case "Dec":
                    month += "12";
                    break;
                default:
                    break;
            }
            String year = splitedString[2];
            String strDate = year + "-" + month + "-" + day;
            answer.add(strDate);
        }
        return answer;
    }
}
