package RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateNameClassroom {
    private static final String NAME_REGEX = "^[ACP][0-9]{4}[A-Z]$";

    public ValidateNameClassroom() {}

    public boolean validate(String nameClassroom) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(nameClassroom);
        return matcher.matches();
    }
}
