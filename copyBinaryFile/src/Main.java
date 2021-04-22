import java.io.*;
import java.util.Scanner;

public class Main {
     static String result;
     static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        readSourceFile();
        writeTargetFile();
    }

    private static void writeTargetFile() {
        try {
            System.out.println("Enter target file");
            String targetPath = sc.nextLine();
            File file = new File(targetPath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileOutputStream fos = new FileOutputStream(targetPath);
            char[] bytes = new char[result.length()];
            for (int i = 0; i < result.length(); i++) {
                char b = result.charAt(i);
                fos.write(b);
            }
            fos.close();
        }
        catch(Exception e) {
            System.err.println("File is not exist or content is not correct");
        }

    }

    private static void readSourceFile() {
        try {
            System.out.println("Enter source path");
            String sourcePath = sc.nextLine();
            File file = new File(sourcePath);
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            FileInputStream fis = new FileInputStream(sourcePath);
            int i = -1;
            byte[] bytes = new byte[1024];
            while ((i = fis.read(bytes)) != -1){
               result = new String(bytes, 0, i);
            }
            fis.close();
        }
        catch(Exception e) {
            System.err.println("File is not exist or content is not correct");
        }
    }
}
