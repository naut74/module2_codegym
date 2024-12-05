package CrawlSong;

import java.io.*;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlSongExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html");
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            content = content.replaceAll("\\n+", "");
            Pattern pattern = Pattern.compile("name_song\">(.*?)</a>");
            Matcher matcher = pattern.matcher(content);

            FileWriter fileWriter = new FileWriter("src/CrawlSong/BXH.txt", false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("TOP Song In Month\n");
            bufferedWriter.newLine();
            while (matcher.find()) {
                bufferedWriter.write(matcher.group(1));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            System.out.println("Completed! ");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error something");
        }
    }
}
