import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManagement {
    Scanner sc = new Scanner(System.in);
    List<Contact> contactList = new ArrayList<>();
    private String phoneNumber;
    private String group;
    private String name;
    private String sex;
    private String address;
    private String dob;
    private String email;

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
        System.out.println("Enter email");
        email = sc.nextLine();
    }

    private void newDOB() {
        System.out.println("Enter date of birth");
        dob = sc.nextLine();
    }

    private void newAddress() {
        System.out.println("Enter address");
        address = sc.nextLine();
    }

    private void newSex() {
        System.out.println("Enter sex");
        sex = sc.nextLine();
    }

    private void newFullName() {
        System.out.println("Enter full name");
        name = sc.nextLine();
    }

    private void newGroup() {
        System.out.println("Enter group");
        group = sc.nextLine();
    }

    private void newPhoneNumber() {
        String phoneRegex = "^(\\d{3,})-(\\d{4,}-(\\d{3,}))";
//        do {
            System.out.println("Enter phone number (xxx-xxxx-xxx)");
            phoneNumber = sc.nextLine();
//            if (!phoneNumber.matches(phoneRegex)) {
//                System.err.println("Wrong input");
//            }
//        }
//        while (!phoneNumber.matches(phoneRegex));
    }

    public void showList() {
        System.out.println("Contact List");
        for (Contact contact :
                contactList) {
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
        String phoneRegex = ""
        do {
            System.out.println("Enter phone number");
            phoneNumber = sc.nextLine();

            contact = findContactByPhone();
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
        Contact contact = findContactByPhone();
        if(contact != null) {
            contactList.remove(contact);
        }
        else System.out.println("No result with this number");
    }

    public void searchContact() {
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
}
