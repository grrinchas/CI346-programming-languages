import com.sun.org.apache.regexp.internal.RE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

@SuppressWarnings("all")
public class PhoneNumbers {

    // NB: backslashes are already "special" in java strings, so they need to be escaped twice in
    // regexes. Thus, the regex '\d' becomes '\\d' in Java. See
    // http://docs.oracle.com/javase/tutorial/essential/regex/ for details.

    private static final String LOCAL_NUMBER = "[1-9]\\d{5}";
    private static final String AREA_CODE = "((01\\d{3} ?)|(\\(01\\d{3}\\) ?))";

    private static final String HOME = AREA_CODE + LOCAL_NUMBER;
    private static final String INTERNATIONAL = "\\+441\\d{3}[1-9]\\d{5}";
    private static final String PHONE_REGEX = String.format("(%s)|(%s)", HOME, INTERNATIONAL);

    private static final String prompt = "Enter a phone number or press return to end: ";

    public static void main(String[] args) {
        System.out.print(prompt);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String phoneNumber;
        try {
            phoneNumber = bufferedReader.readLine().trim();
            while (!phoneNumber.equals("")) {
                if (phoneNumber.matches(PHONE_REGEX)) {
                    System.out.printf("%s is a valid UK landline number.\n", phoneNumber);
                } else {
                    System.out.printf("%s is not a valid UK landline number.\n", phoneNumber);
                }
                System.out.print(prompt);
                phoneNumber = bufferedReader.readLine().trim();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}