package io.minlee;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class PhoneToString {

    static String[] decoder = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight"," nine", "ten",
                        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
                        "twenty-one", "twenty-two", "twenty-three","twenty-four", "twenty-five", "twenty-six", "twenty-seven", "twenty-eight", "twenty-nine", "thirty",
                        "thirty-one", "thirty-two", "thirty-three", "thirty-four", "thirty-five", "thirty-six", "thirty-seven", "thirty-eight", "thirty-nine", "forty",
                        "forty-one", "forty-two", "forty-three", "forty-four", "forty-five", "forty-six", "forty-seven", "forty-eight", "forty-nine", "fifty",
                        "fifty-one", "fifty-two", "fifty-three", "fifty-four", "fifty-five", "fifty-six", "fifty-seven", "fifty-eight", "fifty-nine", "sixty"};

    public static String phoneToString(String input){
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("\\d");
        Matcher match = p.matcher(input);
        int countSpacing = 0;
        while(match.find()){
            sb.append(decodeString(match.group()));
            countSpacing++;
            if((countSpacing == 3) || (countSpacing == 6)){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static boolean determineIfInputIsPhone(String input){
        Pattern p = Pattern.compile("(\\d){3,4}");
        Matcher match = p.matcher(input);
        int hit = 0;
        while (match.find()) {
            hit++;
        }
        if(hit == 3){
            return true;
        }
        return false;
    }

    public static boolean determineIfInputIsTime(String input){
        Pattern p = Pattern.compile("((?:(?:[0-1][0-9])|(?:[2][0-3])|(?:[0-9])):(?:[0-5][0-9])(?::[0-5][0-9])?(?:\\s?(?:am|AM|pm|PM))?)");
        Matcher match = p.matcher(input);
        while (match.find()) {
            return true;
        }
        return false;
    }

    public static String militaryTimeToString(String input){
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("(\\d){2}");
        Matcher match = p.matcher(input);
        int countSpacing = 0;
        while(match.find()){
            sb.append(decodeString(match.group()));
            countSpacing++;
            if(countSpacing == 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    public static String ampmTimeToString(String input){
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("(\\d){2}");
        Matcher match = p.matcher(input);
        int counter = 0;
        while(match.find()){

            if(counter == 0){
                if(match.group().charAt(0) == '0')
                    sb.append(decodeString(match.group().substring(1,2)));
                else
                    sb.append(decodeString(match.group()));
                sb.append(" ");

            }
            else if(!match.group().equals("00")) {
                sb.append(decodeString(match.group()));
                sb.append(" ");
            }
            counter++;
        }
        p = Pattern.compile("(?:am|AM|pm|PM)");
        match = p.matcher(input);
        while(match.find()){
           sb.append(decodeString(match.group()));
        }
        return sb.toString();
    }

    private static String decodeString(String input) {
        if((input.charAt(0) == '0') && (input.length() > 1)){
            if(input.charAt(1) != '0')
                return "o" + decoder[Integer.parseInt(input.substring(1,2))];
        }
        if(input.equals("00")){
            return "hundred";
        }
        if(input.toLowerCase().equals("am"))
            return "ante meridiem";
        if(input.toLowerCase().equals("pm"))
            return "post meridiem";
        return decoder[Integer.parseInt(input)];
    }

    public static String inputToString(String input){
        if(determineIfInputIsPhone(input)){
            return phoneToString(input);
        }
        if(determineIfInputIsTime(input)){
            return ampmTimeToString(input);
        }
        else
            return militaryTimeToString(input);
    }

}
