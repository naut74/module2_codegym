package ValidatePhoneNumber;

import java.security.PublicKey;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhoneNumber {
    private static final String PHONE_NUMBER_REGEX = "^[0-9]{2}-[0][0-9]{9}$";  // OR  "^\(\d{2}\)-\(0\d{9}\)$"

    public boolean validate(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
