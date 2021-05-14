import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManagement {
    public static final String ENTER_EMAIL = "Enter email";
    public static final String WRONG_INPUT = "Wrong input";
    public static final String ENTER_DATE_OF_BIRTH = "Enter date of birth";
    public static final String ENTER_ADDRESS = "Enter address";
    public static final String ENTER_SEX = "Enter sex";
    public static final String ENTER_FULL_NAME = "Enter full name";
    public static final String ENTER_GROUP = "Enter group";
    public static final String ENTER_PHONE_NUMBER_10_DIGIT_NUMBERS = "Enter phone number (10 digit numbers)";
    public static final String CONTACT_LIST = "Contact List";
    public static final String NO_RESULT_WITH_THIS_NUMBER = "No result with this number";
    public static final String ENTER_PHONE_NUMBER_PRESS_ENTER_TO_EXIT = "Enter phone number (press Enter to exit)";
    public static final String DATA_CONTACTS_CSV = "data/contacts.csv";
    public static final String EDIT_SUCCESSFUL_PRESS_ENTER_TO_CONTINUE = "Edit successful! Press Enter to continue";
    public static final String DELETE_CONTACT_SUCCESSFUL = "Delete contact successful";
    public static final String PRESS_ENTER_TO_CONTINUE = "Press Enter to continue";
    public static final String SEARCH_SUCCESSFUL = "Search Successful";
    public static final String BACK_TO_MAIN_MENU = "Back to main menu";
    public static final String CONTACT_FOUND = "Contact Found";
    public static final String DELETE_FAILED = "Delete Failed";
    public static final String DELETE_THIS_NUMBER_ENTER_Y_TO_DELETE = "Delete this number? (Enter Y to delete)";
    public static final String DO_YOU_WANT_TO_UPDATE_FILE = "Do you want to override file?";
    public static final String UPDATE_FILE_SUCCESSFUL = "Update file successful";
    public static final String EXPORT_FAILED = "Export failed";
    Scanner sc = new Scanner(System.in);
    List<Contact> contactList = new ArrayList<>();
    private String phoneNumber;
    private String group;
    private String name;
    private String sex;
    private String address;
    private String dob;
    private String email;
    private final String phoneRegex = "^\\d{10}$";

    public void addNewContact() {
        newPhoneNumber();
        newGroup();
        newFullName();
        newSex();
        newAddress();
        newDOB();
        newEmail();
        contactList.add(new Contact(phoneNumber, group, name, sex, address, dob, email));
    }

    private void newEmail() {
        String emailRegex = "^(.*?)+@(.*?)(\\.(.*?))+$";
        do {
            System.out.println(ENTER_EMAIL);
            email = sc.nextLine();
            if (!email.matches(emailRegex)) {
                System.err.println(WRONG_INPUT);
            }
        }
        while (!email.matches(emailRegex));
    }

    private void newDOB() {
        System.out.println(ENTER_DATE_OF_BIRTH);
        dob = sc.nextLine();
    }

    private void newAddress() {
        System.out.println(ENTER_ADDRESS);
        address = sc.nextLine();
    }

    private void newSex() {
        System.out.println(ENTER_SEX);
        sex = sc.nextLine();
    }

    private void newFullName() {
        System.out.println(ENTER_FULL_NAME);
        name = sc.nextLine();
    }

    private void newGroup() {
        System.out.println(ENTER_GROUP);
        group = sc.nextLine();
    }

    private void newPhoneNumber() {
        do {
            System.out.println(ENTER_PHONE_NUMBER_10_DIGIT_NUMBERS);
            phoneNumber = sc.nextLine();
            if (!phoneNumber.matches(phoneRegex)) {
                System.err.println(WRONG_INPUT);
            }
        }
        while (!phoneNumber.matches(phoneRegex));
    }

    public void showList() {
        System.out.println(CONTACT_LIST);
        for (Contact contact :
                contactList) {
            if (contact.getPhoneNumber().equals("Số điện thoại")) continue;
            System.out.println(
                    "Phone number: " + contact.getPhoneNumber() +
                            ", Group: " + contact.getGroup() +
                            ", Full name: " + contact.getFullName() +
                            ", Sex: " + contact.getSex() +
                            ", Address: " + contact.getAddress()
            );
        }
        System.out.println(PRESS_ENTER_TO_CONTINUE);
        sc.nextLine();
    }

    public void editContact() {
        Contact contact;
        do {
            checkPhoneNumberWithEnterKey();
            if (!phoneNumber.equals("")) {
                contact = findContactByPhone();
                if (contact != null) {
                    editContact(contact);
                } else {
                    System.out.println(NO_RESULT_WITH_THIS_NUMBER);
                }
            } else {
                System.out.println(BACK_TO_MAIN_MENU);
                break;
            }
        }
        while (contact == null);
        System.out.println(PRESS_ENTER_TO_CONTINUE);
        sc.nextLine();
    }

    private void editContact(Contact contact) {
        System.out.println(CONTACT_FOUND);
        newGroup();
        newFullName();
        newSex();
        newAddress();
        newDOB();
        newEmail();
        contact.setGroup(group);
        contact.setFullName(name);
        contact.setSex(sex);
        contact.setAddress(address);
        contact.setDob(dob);
        contact.setEmail(email);
        System.out.println(EDIT_SUCCESSFUL_PRESS_ENTER_TO_CONTINUE);
        sc.nextLine();
    }

    private void checkPhoneNumberWithEnterKey() {
        do {
            System.out.println(ENTER_PHONE_NUMBER_PRESS_ENTER_TO_EXIT);
            phoneNumber = sc.nextLine();
            if (phoneNumber.matches("")) {
                break;
            } else if (!phoneNumber.matches(phoneRegex)) {
                System.err.println(WRONG_INPUT);
            }
        }
        while (!phoneNumber.matches(phoneRegex));
    }

    private Contact findContactByPhone() {
        for (Contact contact :
                contactList) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }

    public void deleteContact() {
        checkPhoneNumberWithEnterKey();
        if (!phoneNumber.equals("")) {
            Contact contact = findContactByPhone();
            if (contact != null) {
                System.out.println(DELETE_THIS_NUMBER_ENTER_Y_TO_DELETE);
                String choice = sc.nextLine();
                if (choice.equals("Y")) {
                    contactList.remove(contact);
                    System.out.println(DELETE_CONTACT_SUCCESSFUL);
                } else System.out.println(DELETE_FAILED);
            } else System.out.println(WRONG_INPUT);
        } else {
            System.out.println(BACK_TO_MAIN_MENU);
        }
        System.out.println(PRESS_ENTER_TO_CONTINUE);
        sc.nextLine();
    }

    public void searchContact() {
        checkPhoneNumberWithEnterKey();
        if (!phoneNumber.equals("")) {
            Contact contact = findContactByPhone();
            if (contact != null) {
                displaySearchResult(contact);
            } else System.out.println(NO_RESULT_WITH_THIS_NUMBER);
        } else System.out.println(BACK_TO_MAIN_MENU);
        System.out.println(PRESS_ENTER_TO_CONTINUE);
        sc.nextLine();
    }

    private void displaySearchResult(Contact contact) {
        System.out.println(SEARCH_SUCCESSFUL);
        System.out.println(
                "Phone number: " + contact.getPhoneNumber() +
                        ", Group: " + contact.getGroup() +
                        ", Full name: " + contact.getFullName() +
                        ", Sex: " + contact.getSex() +
                        ", Address: " + contact.getAddress()
        );
    }

    public void writeContact() throws IOException {
        FileWriter writer = new FileWriter(DATA_CONTACTS_CSV);
        System.out.println(DO_YOU_WANT_TO_UPDATE_FILE);
        String choice = sc.nextLine();
        if (choice.equals("Y")) {
            for (Contact contact :
                    contactList) {
                writer.write(contact.getPhoneNumber() + "," +
                        contact.getGroup() + "," +
                        contact.getFullName() + "," +
                        contact.getSex() + "," +
                        contact.getAddress() + "," +
                        contact.getDob() + "," +
                        contact.getEmail() + "\n");
            }
            System.out.println(UPDATE_FILE_SUCCESSFUL);
            writer.close();
        } else {
            System.out.println(EXPORT_FAILED);
            System.out.println(PRESS_ENTER_TO_CONTINUE);
            sc.nextLine();
        }
    }


    public void readContact() throws IOException {
        FileReader fileReader = new FileReader(DATA_CONTACTS_CSV);
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        contactList = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            String[] result = line.split(",");
            if (result.length == 7) {
                phoneNumber = result[0];
                group = result[1];
                name = result[2];
                sex = result[3];
                address = result[4];
                dob = result[5];
                email = result[6];
                contactList.add(new Contact(phoneNumber, group, name, sex, address, dob, email));
            }
        }
    }
}
