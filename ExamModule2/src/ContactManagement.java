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
    Scanner sc = new Scanner(System.in);
    List<Contact> contactList = new ArrayList<>();
    private String phoneNumber;
    private String group;
    private String name;
    private String sex;
    private String address;
    private String dob;
    private String email;
    private String phoneRegex = "^\\d{10}$";
    private String emailRegex = "^(.*?)+@(.*?)(\\.(.*?))+$";

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

        do {
            System.out.println(ENTER_EMAIL);
            email = sc.nextLine();
            if (!email.matches(emailRegex)){
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
            System.out.println("Enter phone number (10 digit numbers)");
            phoneNumber = sc.nextLine();
            if (!phoneNumber.matches(phoneRegex)) {
                System.err.println("Wrong input");
            }
        }
        while (!phoneNumber.matches(phoneRegex));
    }

    public void showList() {
        System.out.println("Contact List");
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
    }

    public void editContact() {
        Contact contact;
        do {
            checkPhoneNumberWithEnterKey();
            contact = findContactByPhone();
            if (phoneNumber.matches("")){
                break;
            }
            if (contact != null) {
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
            } else {
                System.out.println("No result with this number");
            }
        }
        while (contact == null);
    }

    private void checkPhoneNumberWithEnterKey() {
        do {
            System.out.println("Enter phone number (press Enter to exit)");
            phoneNumber = sc.nextLine();
            if (phoneNumber.matches("")) {
                break;
            } else if (!phoneNumber.matches(phoneRegex)) {
                System.err.println("Wrong input");
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
        Contact contact = findContactByPhone();
        if(contact != null) {
            contactList.remove(contact);
        }
        else System.out.println("No result with this number");
    }

    public void searchContact() {
        checkPhoneNumberWithEnterKey();
        Contact contact = findContactByPhone();
        if(contact != null) {
            System.out.println(
                    "Phone number: " + contact.getPhoneNumber() +
                            ", Group: " + contact.getGroup() +
                            ", Full name: " + contact.getFullName() +
                            ", Sex: " + contact.getSex() +
                            ", Address: " + contact.getAddress()
            );
        }
        else System.out.println("No result with this number");
    }

    public void writeContact() throws IOException {
        FileWriter writer = new FileWriter("data/contacts.csv");
        writer.write("Số điện thoại,Nhóm,Họ tên,Giới tính,Địa chỉ,Ngày sinh,Email\n");
        for (Contact contact :
                contactList) {
            writer.write(contact.getPhoneNumber()+","+
                    contact.getGroup()+","+
                    contact.getFullName()+","+
                    contact.getSex()+","+
                    contact.getAddress()+","+
                    contact.getDob()+","+
                    contact.getEmail()+"\n");
        }
        writer.close();
    }


    public void readContact() throws IOException {
        FileReader fileReader = new FileReader("data/contacts.csv");
        BufferedReader reader = new BufferedReader(fileReader);
        String line = null;
        while ((line = reader.readLine()) != null){
            String[] result = line.split(",");
            if (result.length == 7){
            phoneNumber = result[0];
            group = result[1];
            name = result[2];
            sex = result[3];
            address = result[4];
            dob = result[5];
            email = result[6];
            contactList.add(new Contact(phoneNumber, group,name,sex,address,dob,email));}
        }
    }
}
