package CrawlNews;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlNews {

    public static final String URL_REGEX = "<a[^>]*href=\"([^\"]+)\"[^>]*>(.*?)</a>";
    public static final String FILE_PATH_OUT = "src/CrawlNews/NewsToday.txt";

    public static void main(String[] args) {
        try {
            URL url = new URL("http://dantri.com.vn/the-gioi.htm");

            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();

            validateAndWrite(content);

        } catch (IOException e) {
            System.err.println("Error reading the webpage: " + e.getMessage());
        }
    }

    private static String getDay() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return currentDate.format(formatter);
    }

    private static void validateAndWrite(String content) {
        content = content.replaceAll("\\n+", "");
        Pattern pattern = Pattern.compile(URL_REGEX);
        Matcher matcher = pattern.matcher(content);

        // Use try-with-resources to ensure proper closing of BufferedWriter
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH_OUT, false))) {
            bufferedWriter.write("NEWS " + getDay());
            bufferedWriter.newLine();
            while (matcher.find()) {
                String href = matcher.group(1);
                String contentLink = matcher.group(2);
                bufferedWriter.write(href);
                bufferedWriter.newLine();
            }
            bufferedWriter.newLine();
            bufferedWriter.write(getTime());
            bufferedWriter.newLine();
            bufferedWriter.write("__________________________________");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        System.out.println("Completed!");
    }

    public static String getTime() {
        LocalTime currentTime = LocalTime.now();

        int hour = currentTime.getHour();
        int minute = currentTime.getMinute();
        int second = currentTime.getSecond();

        return "Update at: " + hour + ":" + minute + ":" + second;
    }
}
