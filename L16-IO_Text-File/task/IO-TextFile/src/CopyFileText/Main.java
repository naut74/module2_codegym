package CopyFileText;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CreateCopyFile createCopyFile = new CreateCopyFile();
        String filePathIn = "src/CopyFileText/Copyright.txt";
        String filePathOut = "src/CopyFileText/Copyright(copy).txt";
        createCopyFile.copyToNewFile(filePathIn, filePathOut);
    }
}
