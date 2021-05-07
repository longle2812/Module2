import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AccountManagement {
    static Map<String, String> accounts = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    private String username;
    private String password;

    public AccountManagement() {
    }


    public boolean login() {
        boolean isValid = false;
        System.out.println("Enter username");
        username = sc.nextLine();
        System.out.println("Enter password");
        password = sc.nextLine();
        for (Map.Entry<String, String> user : accounts.entrySet()
        ) {
            if (username.equals(user.getKey())) {
                if(password.equals(user.getValue())) {
                    isValid = true;
                }
            }
        }
        return isValid;
    }

    public boolean checkNewAccount() {
        boolean isValid = true;
        for (Map.Entry<String, String> user : accounts.entrySet()
        ) {
            if (username.equals(user.getKey())) {
                    isValid = false;
            }
        }
        return isValid;
    }

    public void createNewAccount() {
            System.out.println("Enter username");
            username = sc.nextLine();
            System.out.println("Enter password");
            password = sc.nextLine();
            if (checkNewAccount()) {
                accounts.put(username, password);
                System.out.println("Add successful");
            }
            else System.out.println("Account existed");
    }
}
