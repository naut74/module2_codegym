package management;

import utility.ReadAndWriteFile;
import utility.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManagement {
    public static final String CONTACTS_DATA = "src\\data\\contacts.csv";
    Scanner scanner = new Scanner(System.in);
    private List<String> usersList = new ArrayList<>();

    private static UserManagement instance;

    private UserManagement() {
    }

    public static UserManagement getInstance() {
        if (instance == null) {
            instance = new UserManagement();
        }
        return instance;
    }

    public void viewList() {
        List<String> lines = ReadAndWriteFile.readFile(CONTACTS_DATA);
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public void addUser() {
        String phoneNumber, group, name, address, dayOfBirth, email;

        while (true) {
            System.out.println("Nhập số điện thoại: ");
            phoneNumber = scanner.nextLine();
            if (Validation.validatePhoneNumber(phoneNumber)) {
                break;
            }
        }

        System.out.println("Nhập nhóm: ");
        group = scanner.nextLine();

        System.out.println("Nhập tên: ");
        name = scanner.nextLine();

        System.out.println("Nhập địa chỉ: ");
        address = scanner.nextLine();

        while (true) {
            System.out.println("Nhập ngày sinh (dd/MM/yyyy): ");
            dayOfBirth = scanner.nextLine();
            if (Validation.validateDayOfBirth(dayOfBirth)) {
                break;
            }
        }

        while (true) {
            System.out.println("Nhập email: ");
            email = scanner.nextLine();
            if (Validation.validateEmail(email)) {
                break;
            }
        }

        String userInfo = String.join(",", "\"" + phoneNumber + "\"", "\"" + group + "\"", "\"" + name + "\"", "\"" + address + "\"", "\"" + dayOfBirth + "\"", "\"" + email + "\"");

        usersList.add(userInfo);
        System.out.println("Người dùng đã được thêm vào danh sách tạm thời.");
    }

    public void deleteUser() {
        System.out.println("Nhập số điện thoại bạn muốn xóa: ");
        String phoneNumber = scanner.nextLine();

        List<String> lines = ReadAndWriteFile.readFile(CONTACTS_DATA);
        List<String> updatedLines = new ArrayList<>();

        for (String line : lines) {
            String[] userData = line.split(",");
            if (!userData[0].replace("\"", "").equals(phoneNumber)) {
                updatedLines.add(line);
            }
        }

        if (updatedLines.size() < lines.size()) {
            ReadAndWriteFile.writeFile(CONTACTS_DATA, updatedLines, false);
            System.out.println("Người dùng đã được xóa.");
        } else {
            System.out.println("Không tìm thấy người dùng với số điện thoại này.");
        }
    }


    public void updateUser() {
        System.out.println("Nhập số điện thoại bạn muốn sửa: ");
        String phoneNumber = scanner.nextLine();

        List<String> lines = ReadAndWriteFile.readFile(CONTACTS_DATA);
        List<String> updatedLines = new ArrayList<>();
        boolean found = false;

        for (String line : lines) {
            String[] userData = line.split(",");
            if (userData[0].replace("\"", "").equals(phoneNumber)) {
                found = true;
                String group, name, address, dayOfBirth, email;

                System.out.println("Nhập nhóm mới: ");
                group = scanner.nextLine();
                System.out.println("Nhập tên mới: ");
                name = scanner.nextLine();
                System.out.println("Nhập địa chỉ mới: ");
                address = scanner.nextLine();
                while (true) {
                    System.out.println("Nhập ngày sinh (dd/MM/yyyy): ");
                    dayOfBirth = scanner.nextLine();
                    if (Validation.validateDayOfBirth(dayOfBirth)) {
                        break;
                    }
                }

                while (true) {
                    System.out.println("Nhập email: ");
                    email = scanner.nextLine();
                    if (Validation.validateEmail(email)) {
                        break;
                    }
                }

                String updatedUserInfo = String.join(",", "\"" + phoneNumber + "\"", "\"" + group + "\"", "\"" + name + "\"", "\"" + address + "\"", "\"" + dayOfBirth + "\"", "\"" + email + "\"");
                updatedLines.add(updatedUserInfo);
            } else {
                updatedLines.add(line);
            }
        }

        if (found) {
            ReadAndWriteFile.writeFile(CONTACTS_DATA, updatedLines, false);
            System.out.println("Thông tin người dùng đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy người dùng với số điện thoại này.");
        }
    }

    public void searchUser() {
        System.out.println("Nhập số điện thoại bạn muốn tìm kiếm: ");
        String phoneNumber = scanner.nextLine();

        List<String> lines = ReadAndWriteFile.readFile(CONTACTS_DATA);
        boolean found = false;

        for (String line : lines) {
            String[] userData = line.split(",");

            if (userData[0].replace("\"", "").equals(phoneNumber)) {
                System.out.println("Thông tin người dùng: ");
                System.out.println("Số điện thoại: " + userData[0].replace("\"", ""));
                System.out.println("Nhóm: " + userData[1].replace("\"", ""));
                System.out.println("Tên: " + userData[2].replace("\"", ""));
                System.out.println("Giới tính: " + userData[3].replace("\"", ""));
                System.out.println("Địa chỉ: " + userData[4].replace("\"", ""));
                System.out.println("Ngày sinh: " + userData[5].replace("\"", ""));
                System.out.println("Email: " + userData[6].replace("\"", ""));
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy người dùng với số điện thoại này.");
        }
    }


    public void readFileInfo() {
        if (!usersList.isEmpty()) {
            System.out.println("Bạn có chắc chắn muốn xóa toàn bộ dữ liệu và cập nhật lại file? (Có/Không): ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("Có")) {
                // Xóa toàn bộ dữ liệu trong file
                List<String> emptyList = new ArrayList<>();
                ReadAndWriteFile.writeFile(CONTACTS_DATA, emptyList, false);
                System.out.println("Dữ liệu đã được xóa khỏi file.");
            } else {
                System.out.println("Hủy xóa dữ liệu.");
            }
        } else {
            System.out.println("Danh sách người dùng trống, không có gì để xóa.");
        }
    }

    public void writeFileInfo() {
        if (!usersList.isEmpty()) {
            System.out.println("Bạn có chắc chắn muốn ghi dữ liệu vào file? (Có/Không): ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("Có")) {
                ReadAndWriteFile.writeFile(CONTACTS_DATA, usersList, true);
                System.out.println("Dữ liệu đã được ghi vào file.");
            } else {
                System.out.println("Hủy ghi dữ liệu.");
            }
        } else {
            System.out.println("Danh sách người dùng trống, không có gì để ghi.");
        }
    }
}
