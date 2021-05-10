package EmployeeManagement;

import java.io.*;
import java.util.ArrayList;
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
        addBasicInfor();
        System.out.println("Enter speciality");
        speciality = sc.nextLine();
        System.out.println("Enter level");
        level = sc.nextInt();
    }

    private void addNewLeaderInfor() {
        addBasicInfor();
        System.out.println("Enter branch");
        branch = sc.nextLine();
    }

    private void addBasicInfor() {
        System.out.println("Enter id");
        id = sc.nextLine();
        System.out.println("Enter name");
        name = sc.nextLine();
        System.out.println("Enter age");
        age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter sex");
        sex = sc.nextLine();
        System.out.println("Enter hometown");
        hometown = sc.nextLine();
        System.out.println("Enter wage");
        wage = sc.nextDouble();
        sc.nextLine();
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
