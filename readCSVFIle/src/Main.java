import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        readFile("C:\\Users\\Long Le\\Desktop\\country.csv");
    }

    public static void readFile(String filePath) {
        BufferedReader br = null;
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            String line;
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                printCSV(line);
            }
            br.close();
        } catch (Exception ex) {
            System.err.println("Đường dẫn sai hoặc nội dung không đúng");
        }
    }

    private static void printCSV(String line) {
        List<String> result = new ArrayList<>();
        if (line != null) {
            String[] splitData = line.split(",");
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        System.out.println("Country[id = " + result.get(0) + ", code=" + result.get(1) + ", name " + result.get(2) + "]");
    }
}




