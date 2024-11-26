package PalindromeUsingQueue;

public class PalindromeClient {
    public static void main(String[] args) {
        String testString = "A man, a plan, a canal: Panama";
        if (CheckPalindrome.isPalindrome(testString)) {
            System.out.println("\""+testString+"\" is Palindrome.");
        } else {
            System.out.println("\""+testString+"\" is not Palindrome.");
        }
    }
}
