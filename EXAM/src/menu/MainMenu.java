package menu;

import management.UserManagement;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            System.out.println("---- CHƯƠNG TRÌNH QUẢN LÍ DANH BẠ ----");
            System.out.println("Chọn chức năng theo số (để tiếp tục):");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc ghi file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            System.out.println("Chọn chức năng: ");

            UserManagement userManagement = UserManagement.getInstance();

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Xem danh sách");
                        userManagement.viewList();
                        break;
                    case 2:
                        System.out.println("Thêm mới");
                        userManagement.addUser();
                        break;
                    case 3:
                        System.out.println("Cập nhật");
                        userManagement.updateUser();
                        break;
                    case 4:
                        System.out.println("Xóa");
                        userManagement.deleteUser();
                        break;
                    case 5:
                        System.out.println("Tìm kiếm");
                        userManagement.searchUser();
                        break;
                    case 6:
                        System.out.println("Đọc từ file");
                        userManagement.readFileInfo();
                        break;
                    case 7:
                        System.out.println("Ghi vào file");
                        userManagement.writeFileInfo();
                        break;
                    case 8:
                        System.out.println("Thoát...");
                        quit = true;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
            }
            System.out.println();
        }
    }
}
