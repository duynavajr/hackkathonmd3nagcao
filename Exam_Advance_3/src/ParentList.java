import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ParentList {
    private static Scanner sc = new Scanner(System.in);
    private static Queue<String> queres = new LinkedList<>();
    public static void main(String[] args) {
        while (true){
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập tên phụ huynh nộp hồ sơ\n" +
                    "2. Phụ huynh tiếp theo\n" +
                    "3. Thoát");
            System.out.println("Chọn chức năng (1-3): ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    inputData();
                    break;
                case 2:
                    nextParents();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("không hợp lệ mời nhập lại!");
            }
        }
    }
    public static void inputData(){
        System.out.print("Nhập tên phụ huynh: ");
        String parentName = sc.nextLine();
        queres.offer(parentName);
        System.out.println("Tên phụ huynh đã được thêm vào danh sách.");
    }
    public static void nextParents(){
        if (!queres.isEmpty()) {
            String nextParent = queres.poll();
            System.out.println("Phụ huynh đầu tiên trong danh sách: " + nextParent);
        } else {
            System.out.println("Danh sách rỗng.");
        }
    }
}
