package Account;

import java.io.*;
import java.util.*;

public class AccountManagement {
    static List<User> accounts = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    private String username;
    private String password;
    private String role;

    public AccountManagement() {
    }


    public User login() throws IOException, ClassNotFoundException {
        readFromFile();
        User user = new User("null","null","null");
        System.out.println("Enter username");
        username = sc.nextLine();
        System.out.println("Enter password");
        password = sc.nextLine();
        for (User account :
                accounts) {
            if (username.equals(account.getUsername())) {
                if (password.equals(account.getPassword())) {
                    user = account;
                }
            }
        }
        return user;
    }

    public boolean checkNewAccount() throws IOException, ClassNotFoundException {
        readFromFile();
        boolean isValid = true;
        for (User account :
                accounts) {
            if (account.getUsername().equals(username)) {
                isValid = false;
            }
        }
        return isValid;
    }

    public void createNewAccount() throws IOException, ClassNotFoundException, InterruptedException {
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
        role = "";
        while (!role.equals("admin") && !role.equals("vipMember") && !role.equals("member")) {
            System.out.println("Enter role (admin//vipMember//member)");
            role = sc.nextLine();
        }
        if (checkNewAccount()) {
            accounts.add(new User(username, password, role));
            writeToFile();
            System.out.println("Add successful");
        } else {
            System.err.println("Account existed");
            Thread.sleep(100);
        }
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
        accounts = (List<User>) accountObject.readObject();
        accountObject.close();
    }

    public void showList() throws IOException, ClassNotFoundException {
        readFromFile();
        for (User account :
                accounts) {
            System.out.println(account);
        }
    }
}
