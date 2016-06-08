package io.minlee;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by minlee on 6/7/16.
 */
public class PhoneToStringTest {

    @Test
    public void phoneToStringTest(){
        String number = "800 345-5454";
        String expectedValue = "eightzerozero threefourfive fivefourfivefour";
        String actualValue = PhoneToString.phoneToString(number);
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void determineIfInputIsPhoneTest(){
        String number = "315 322 -3241";
        assertTrue(PhoneToString.determineIfInputIsPhone(number));
    }

    @Test
    public void determineIfInputIsTimeTest(){
        String number = "12:30pm";
        assertTrue(PhoneToString.determineIfInputIsTime(number));
    }
    @Test
    public void militaryTimeToStringTest(){
        String time = "12:00";
        String expectedValue = "twelve hundred";
        String actualValue = PhoneToString.militaryTimeToString(time);
        assertEquals(expectedValue,actualValue);
        time = "05:44";
        expectedValue = "ofive forty-four";
        actualValue = PhoneToString.militaryTimeToString(time);
        assertEquals(expectedValue,actualValue);
    }
    @Test
    public void ampmTimeToStringTest(){
        String time = "12:00 pm";
        String expectedValue = "twelve post meridiem";
        String actualValue = PhoneToString.ampmTimeToString(time);
        assertEquals(expectedValue,actualValue);
        time = "01:44 AM";
        expectedValue = "one forty-four ante meridiem";
        actualValue = PhoneToString.ampmTimeToString(time);
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void inputToStringTest(){
        String time = "12:00 pm";
        String number = "800 345-5454";
        String expectedValue = "eightzerozero threefourfive fivefourfivefour";
        String actualValue = PhoneToString.inputToString(number);
        assertEquals(expectedValue,actualValue);
        time = "01:44 AM";
        expectedValue = "one forty-four ante meridiem";
        actualValue = PhoneToString.ampmTimeToString(time);
        assertEquals(expectedValue,actualValue);
        time = "01:44";
        expectedValue = "one forty-four";
        actualValue = PhoneToString.ampmTimeToString(time);
        assertEquals(expectedValue,actualValue);
    }




}
