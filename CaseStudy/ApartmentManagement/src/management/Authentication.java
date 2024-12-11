package management;

import entities.User;
import utility.FileManagement;
import utility.UserFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Authentication {
    private static Authentication instance; // Singleton instance
    private Map<String, String[]> loginData; // [username -> [password, role, additionalInfo]]

    private Authentication() {
        loginData = new HashMap<>();
        loadLoginData();
    }

    public static Authentication getInstance() {
        if (instance == null) {
            instance = new Authentication();
        }
        return instance;
    }

    // Đọc dữ liệu từ file và lưu vào loginData
    private void loadLoginData() {
        String filePath = "src/data/loginData.txt";
        List<String> lines = FileManagement.readFile(filePath);

        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String username = parts[0].trim();
                String password = parts[1].trim();
                String role = parts[2].trim();
                loginData.put(username, new String[]{password, role, ""}); // additionalInfo có thể rỗng
            } else if (parts.length == 4) {
                String username = parts[0].trim();
                String password = parts[1].trim();
                String role = parts[2].trim();
                String additionalInfo = parts[3].trim();
                loginData.put(username, new String[]{password, role, additionalInfo});
            }
        }
    }

    public User login(String username, String password) {
        if (loginData.containsKey(username)) {
            String[] data = loginData.get(username);
            if (data[0].equals(password)) {
                return UserFactory.createUser(username, password, data[1], data[2]);
            }
        }
        return null;
    }
}
