package ValidatePhoneNumber;

public class ValidatePhoneNumberTest {
    private static final String[] validPhoneNumber = {"45-0536273646", "84-0190034536", "19-0355555696"};
    private static final String[] inValidPhoneNumber = {"a5-0536273646", "84@0190034536", "19-03855553566"};

    public static void main(String[] args) {
        ValidatePhoneNumber validatePhoneNumber = new ValidatePhoneNumber();

        for (String phoneNumber : validPhoneNumber) {
            System.out.println("Phone Number " + phoneNumber + " is valid " + validatePhoneNumber.validate(phoneNumber));
        }
        for (String phoneNumber : inValidPhoneNumber) {
            System.out.println("Phone Number " + phoneNumber + " is valid " + validatePhoneNumber.validate(phoneNumber));
        }

    }
}
