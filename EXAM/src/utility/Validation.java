package utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Validation {

    public static boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            System.out.println("Email không hợp lệ.");
            return false;
        }
        return true;
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        String phoneRegex = "^0\\d{9}$";
        if (!phoneNumber.matches(phoneRegex)) {
            System.out.println("Số điện thoại không hợp lệ. Nó phải có 10 chữ số và bắt đầu bằng 0.");
            return false;
        }
        return true;
    }

    public static boolean validateDayOfBirth(String dayOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate date = LocalDate.parse(dayOfBirth, formatter);
            if (date.isBefore(LocalDate.now())) {
                return true;
            } else {
                System.out.println("Ngày sinh không thể là ngày trong tương lai.");
                return false;
            }
        } catch (DateTimeParseException e) {
            System.out.println("Ngày sinh không hợp lệ. Vui lòng nhập đúng định dạng dd/MM/yyyy.");
            return false;
        }
    }
}
