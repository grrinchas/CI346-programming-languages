import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

@SuppressWarnings("all")
public class Dates {

    // NB: backslashes are already "special" in java strings, so they need to be escaped twice in
    // regexes. Thus, the regex '\d' becomes '\\d' in Java. See
    // http://docs.oracle.com/javase/tutorial/essential/regex/ for details.

    private static final String MONTH = "(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)";

    private static final String DAY ="(0[1-9]|[12]\\d|30|31)";
    private static final String YEAR = "(\\d{4})";
    private static final String DATE = String.format("%s\\-%s\\-%s", DAY, MONTH, YEAR);
    private static final String MONTH_NR = "(0[1-9]|10|11|12)";
    private static final String UK_DATE = String.format("%s/%s/%s", DAY, MONTH_NR, YEAR);
    private static final String US_DATE = String.format("%s/%s/%s", MONTH_NR, DAY, YEAR);

    private static final String prompt = "Enter a date or press return to end: ";

    public static void main(String[] args) {
        System.out.print(prompt);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String phoneNumber;
        try {
            phoneNumber = bufferedReader.readLine().trim();
            while (!phoneNumber.equals("")) {
                if (phoneNumber.matches(DATE)) {
                    System.out.printf("%s is a valid date.\n", phoneNumber);
                }
                else if (phoneNumber.matches(UK_DATE)) {
                    System.out.printf("%s is a valid UK date.\n", phoneNumber);
                }
                else if (phoneNumber.matches(US_DATE)) {
                    System.out.printf("%s is a valid US date.\n", phoneNumber);
                }
                else {
                    System.out.printf("%s is not a valid date.\n", phoneNumber);
                }
                System.out.print(prompt);
                phoneNumber = bufferedReader.readLine().trim();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}