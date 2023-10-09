import java.util.Scanner;
import java.util.Stack;

public class ReverseString {
    private static Stack<String> stacks = new Stack<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************");
            System.out.println("1. Nhập câu");
            System.out.println("2. Đảo ngược câu");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng (1-3): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    ScannerString();
                    break;
                case 2:
                    reverseStringAll();
                    break;
                case 3:
                    System.out.println("Chương trình kết thúc.");
                    System.exit(0);
                default:
                    System.out.println("Chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }
    }

    private static void ScannerString() {
        System.out.print("Nhập câu: ");
        String inputSentence = scanner.nextLine();
        String[] words = inputSentence.split(" ");
        for (String word : words) {
            stacks.push(word);
        }
    }

    private static void reverseStringAll() {
        System.out.print("Câu đảo ngược: ");
        while (!stacks.isEmpty()) {
            System.out.print(stacks.pop() + " ");
        }
        System.out.println();
    }
}
