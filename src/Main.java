import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TextFile input = new TextFile("input.txt");
        input.write(in.nextLine());
    }
}
