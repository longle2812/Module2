import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AccountManagement {
    public final AccountManagement INSTANCE = new AccountManagement();
    static Map<String, String> accounts = new HashMap<>();

    public AccountManagement() {
    }

    public AccountManagement getInstance() {
        return INSTANCE;
    }

    public boolean checkAccount() {
        boolean isValid = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Username");
        String user = sc.nextLine();
        System.out.println("Enter Password");
        String password = sc.nextLine();
        for (Map.Entry<String, String> username : accounts.entrySet()
        ) {
            if (user.equals(username.getKey())) {
                if (password.equals(username.getValue())) {
                    isValid = true;
                }
            }
        }
        return isValid;
    }
}
