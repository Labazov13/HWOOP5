package personal.views;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateData {
    String patternName = "([A-Z])\\w+";
    String patternLastName = "([A-Z])\\w+";
    String patternPhone = "^(\\+)?((\\d{2,3}) ?\\d|\\d)(([ -]?\\d)|( ?(\\d{2,3}) ?)){5,12}\\d$";
    Pattern pattern1 = Pattern.compile(patternName, Pattern.MULTILINE);
    Pattern pattern2 = Pattern.compile(patternLastName, Pattern.MULTILINE);
    Pattern pattern3 = Pattern.compile(patternPhone, Pattern.MULTILINE);

    public boolean checkFirstName(String firstname){
        Matcher matcher = pattern1.matcher(firstname);
        return !matcher.find();
    }
    public boolean checkLastName(String lastname){
        Matcher matcher = pattern2.matcher(lastname);
        return !matcher.find();
    }
    public boolean checkPhone(String phone){
        Matcher matcher = pattern3.matcher(phone);
        return !matcher.find();
    }
}
