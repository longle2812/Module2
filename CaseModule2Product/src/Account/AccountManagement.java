package Account;

import java.io.*;
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
                if (password.equals(user.getValue())) {
                    isValid = true;
                }
            }
        }
        return isValid;
    }

    public boolean checkNewAccount() throws IOException, ClassNotFoundException {
        readFromFile();
        boolean isValid = true;
        for (Map.Entry<String, String> user : accounts.entrySet()
        ) {
            if (username.equals(user.getKey())) {
                isValid = false;
            }
        }
        return isValid;
    }

    public void createNewAccount() throws IOException, ClassNotFoundException {
        readFromFile();
        String userRegex = "(?=.*?[A-Z])[a-zA-Z0-9]{8,15}";
        do {
            System.out.println("Enter your username (minimum 8 character with at least 1 Uppercase)");
            username = sc.nextLine();
            if (!username.matches(userRegex)) {
                System.err.println("Wrong input");
            }
        }
        while (!username.matches(userRegex));
        System.out.println("Enter your password");
        password = sc.nextLine();
        if (checkNewAccount()) {
            accounts.put(username, password);
            writeToFile();
            System.out.println("Add successful");
        } else System.err.println("Account existed");
    }

    public void writeToFile() throws IOException {
        FileOutputStream accountFile = new FileOutputStream("accountList.txt");
        ObjectOutputStream accountObject = new ObjectOutputStream(accountFile);
        accountObject.writeObject(accounts);
        accountObject.close();
    }

    public void readFromFile() throws IOException, ClassNotFoundException {
        FileInputStream accountFile = new FileInputStream("accountList.txt");
        ObjectInputStream accountObject = new ObjectInputStream(accountFile);
        accounts = (Map<String, String>) accountObject.readObject();
        accountObject.close();
    }
}
