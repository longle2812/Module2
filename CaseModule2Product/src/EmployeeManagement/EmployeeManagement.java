package EmployeeManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagement {
    List<Employee> leaderList = new ArrayList<>();
    List<Employee> workerList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    private String id;
    private String name;
    private int age;
    private String sex;
    private String hometown;
    private double wage;
    private String branch;
    private String speciality;
    private int level;

    public EmployeeManagement() {
    }

    public void addNewEmployee() {
        System.out.println("Choose type:");
        System.out.println("1. Leader");
        System.out.println("2. Worker");
        int choice;
        choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                addNewLeaderInfor();
                leaderList.add(new Leader(id, name, age, sex, hometown, wage, branch));
                break;
            case 2:
                addNewWorkerInfor();
                workerList.add(new NormalWorker(id, name, age, sex, hometown, wage, speciality, level));
                break;
        }
    }

    private void addNewWorkerInfor() {
        System.out.println("Create new Worker");
        addBasicInfor("Worker");
        System.out.println("Enter speciality");
        speciality = sc.nextLine();
        System.out.println("Enter level");
        level = sc.nextInt();
    }

    private void addNewLeaderInfor() {
        System.out.println("Create new Leader");
        addBasicInfor("Leader");
        branch = "";
        while (!branch.matches("HN") && !branch.matches("HCM")) {
            System.out.println("Enter branch (HN/HCM)");
            branch = sc.nextLine();
        }
    }

    private void addBasicInfor(String employee) {
        id = idGenerator(employee);
        name = nameGenerator();
        age = ageGenerator();
        sex = sexGenerator();
        hometown = hometownGenerator();
        wage = wageGenerator();
    }

    private String sexGenerator() {
        sex = "";
        while (!sex.equals("male") && !sex.equals("female")) {
            System.out.println("Enter sex (male/female)");
            sex = sc.nextLine();
        }
        return sex;
    }

    private int ageGenerator() {
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.println("Enter age (18-55 only)");
                age = sc.nextInt();
                isValid = true;
                if (age > 55 || age < 18) {
                    isValid = false;
                }
            } catch (InputMismatchException e) {
                System.err.println("Error!");
                sc.next();
            }
        }
        sc.nextLine();
        return age;
    }

    private double wageGenerator() {
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.println("Enter wage");
                wage = sc.nextInt();
                isValid = true;
            } catch (InputMismatchException e) {
                System.err.println("Error!");
                sc.next();
            }
        }
        sc.nextLine();
        return wage;
    }

    private String nameGenerator() {
        String nameRegex = "(([a-zA-Z]+)\\s?)+";
        do {
            System.out.println("Enter name (Word only)");
            name = sc.nextLine();
            if (!name.matches(nameRegex)) {
                System.err.println("Error!");
            }
        }
        while (!name.matches(nameRegex));
        return name;
    }

    private String hometownGenerator() {
        String hometownRegex = "(([a-zA-Z]+)\\s?)+";
        do {
            System.out.println("Enter hometown (Word only)");
            hometown = sc.nextLine();
            if (!hometown.matches(hometownRegex)) {
                System.err.println("Error!");
            }
        }
        while (!hometown.matches(hometownRegex));
        return hometown;
    }

    private String idGenerator(String employee) {
        String idRegex = "";
        if (employee.equals("Worker")) {
            idRegex = "Wk\\d{3}";
        } else if (employee.equals("Leader")) idRegex = "Ld\\d{3}";
        do {
            System.out.println("Enter ID (Worker - Wkxxx, Leader - Ldxxx with x is number)");
            id = sc.nextLine();
        }
        while (!id.matches(idRegex));
        return id;
    }

    public void showEmployeeList() {
        System.out.println("List of Worker");
        for (Employee employee :
                workerList) {
            System.out.println(employee);
        }
        System.out.println("List of Leader");
        for (Employee employee :
                leaderList) {
            System.out.println(employee);
        }
    }

    public Employee searchByID() {
        System.out.println("1. Leader");
        System.out.println("2. Worker");
        System.out.println("Enter choice");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter ID");
        String searchID = sc.nextLine();
        Employee employee = null;
        switch (choice) {
            case 1:
                employee = genericSearch(leaderList, searchID);
                if (employee != null) {
                    System.out.println(employee);
                } else System.out.println("No information");
                break;
            case 2:
                employee = genericSearch(workerList, searchID);
                if (employee != null) {
                    System.out.println(employee);
                } else System.out.println("No information");
                break;
        }
        return employee;
    }

    private <T> Employee genericSearch(List<T> list, String searchID) {
        for (T employee :
                list) {
            if (((Employee) employee).getId().equals(searchID)) {
                return (Employee) employee;
            }
        }
        return null;
    }

    public void editInformation() {
        System.out.println("1. Leader");
        System.out.println("2. Worker");
        System.out.println("Enter choice");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter ID");
        String editID = sc.nextLine();
        Employee employee;
        switch (choice) {
            case 1:
                employee = genericSearch(leaderList, editID);
                if (employee != null) {
                    addNewLeaderInfor();
                    employee.setId(id);
                    employee.setName(name);
                    employee.setAge(age);
                    employee.setHometown(hometown);
                    employee.setSex(sex);
                    employee.setWage(wage);
                    ((Leader) employee).setBranch(branch);
                } else System.out.println("No information");
                break;
            case 2:
                employee = genericSearch(workerList, editID);
                if (employee != null) {
                    addNewLeaderInfor();
                    employee.setId(id);
                    employee.setName(name);
                    employee.setAge(age);
                    employee.setHometown(hometown);
                    employee.setSex(sex);
                    employee.setWage(wage);
                    ((NormalWorker) employee).setLevel(level);
                    ((NormalWorker) employee).setSpeciality(speciality);
                } else System.out.println("No information");
                break;
        }
    }

    public void deleteEmployee() {
        Employee employee = searchByID();
        if (employee != null) {
            if (employee instanceof NormalWorker) {
                workerList.remove(employee);
            }
            if (employee instanceof Leader) {
                leaderList.remove(employee);
            }
            System.out.println("Delete employee successful");
        } else System.out.println("No information");
    }

    public void writeToFile() throws IOException {
        FileOutputStream workerFile = new FileOutputStream("workerList.txt");
        ObjectOutputStream workerObject = new ObjectOutputStream(workerFile);
        workerObject.writeObject(workerList);
        FileOutputStream leaderFile = new FileOutputStream("leaderList.txt");
        ObjectOutputStream leaderObject = new ObjectOutputStream(leaderFile);
        leaderObject.writeObject(leaderList);
        leaderObject.close();
        workerObject.close();
    }

    public void readFromFile() throws IOException, ClassNotFoundException {
        FileInputStream workerFile = new FileInputStream("workerList.txt");
        ObjectInputStream workerObject = new ObjectInputStream(workerFile);
        workerList = (List<Employee>) workerObject.readObject();
        FileInputStream leaderFile = new FileInputStream("leaderList.txt");
        ObjectInputStream leaderObject = new ObjectInputStream(leaderFile);
        leaderList = (List<Employee>) leaderObject.readObject();
        workerObject.close();
        leaderObject.close();
    }

    public void sortByWage() {
        System.out.println("1. Leader");
        System.out.println("2. Worker");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                genericSort(leaderList);
                break;
            case 2:
                genericSort(workerList);
                break;
        }
        showEmployeeList();
    }

    private <T> void genericSort(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (((List<Employee>) list).get(i).getWage() < ((List<Employee>) list).get(j).getWage()) {
                    Employee temp = (Employee) list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, (T) temp);
                }
            }
        }
    }
}
