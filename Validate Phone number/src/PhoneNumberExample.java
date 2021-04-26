import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberExample {
        public final String PHONE_REGEX ="^\\(\\d{2}\\)\\-\\([0]+\\d{9}\\)$";
    public PhoneNumberExample() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
