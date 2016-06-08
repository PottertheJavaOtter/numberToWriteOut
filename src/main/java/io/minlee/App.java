package io.minlee;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by minlee on 6/8/16.
 */
public class App {

    public static void main(String[] args) {
        String myRegex = "foo";
        Pattern pattern = Pattern.compile(myRegex);


        String test = "dfasdfdsvfoobgobogledfsdafs ";

        Matcher match = pattern.matcher(test);

        while(match.find()){
            System.out.println(match.group());
        }


        System.out.println(test.matches(myRegex));
    }
}
