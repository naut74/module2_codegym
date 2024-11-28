package IncreasingSubstring;

public class IncreasingSubstring {
    public static String findLongestIncreasingSubstring(String input) {
        /** Nên sử dụng StringBuilder vì StringBuilder là mutable, cho hiệu suất tốt hơn**/
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (result.isEmpty() || c > result.charAt(result.length() - 1)) {
                result.append(c);
            }
        }

//        String result = "";
//        for (char c : input.toCharArray()) {
//            if (result.isEmpty() || c > result.charAt(result.length() - 1)) {
//                result += c;
//            }
//        }

        return result.toString();
    }
}
