import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

public class CopyAndPaste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CopyAndPaste copyAndPaste = new CopyAndPaste();
        System.out.println("Nhập đường dẫn");
        String filePath = sc.nextLine();
        copyAndPaste.pasteFile(copyAndPaste.copyFile(filePath), "C:\\Users\\Long Le\\Desktop\\result1.txt");
        System.out.println("Đã sao chép xong");
    }

    public String copyFile(String filePath) {
        String line = "";
        String result = "";
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));

            while ((line = br.readLine()) != null) {
                result += line;
            }
            br.close();
        } catch (Exception ex) {
            System.err.println("Địa chỉ không tồn tại");
        }
        return result;
    }

    public void pasteFile(String content, String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
