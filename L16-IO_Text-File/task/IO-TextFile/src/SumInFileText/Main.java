package SumInFileText;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter direction of file: ");
        String path = input.nextLine(); //  "src/SumInFileText/numbers.txt"

        ReadFileExample readFileEx = new ReadFileExample();
        readFileEx.readFileText(path);
    }
}
