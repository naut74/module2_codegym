package EmailRegularExpression;

public class Main {
    private static EmailExample emailExample;
    private static final String[] validEmail = new String[]{"aasd@gmail.com"};
    private static final String[] invalidEmail = new String[]{"asd#@gmail.com"};

    public static void main(String[] args) {
        emailExample = new EmailExample();
        for (String email : validEmail) {
            boolean isValid = emailExample.validate(email);
            System.out.println("Email is "+email+" is valid: "+isValid);
        }
        for (String email : invalidEmail) {
            boolean isValid = emailExample.validate(email);
            System.out.println("Email is "+email+" is valid: "+isValid);
        }

    }
}
