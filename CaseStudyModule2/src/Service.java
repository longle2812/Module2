import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Service {
    Map<String, String> wordList = new LinkedHashMap<>();

    public Service() {
        start();
    }

    private void start() {
    }

    public void writeToFile(String keyword) {
        try {
            FileOutputStream fos = new FileOutputStream("dictionary.csv");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Entities input = new Entities();
            input.setValue(keyword);
            wordList.put(input.getValue(), input.getValue());
            oos.writeObject(wordList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void lookup(String keyword) {
        readFile();
        writeToFile(keyword);
    }

    private void readFile() {
        try {
            FileInputStream fis = new FileInputStream("dictionary.csv");
            ObjectInputStream ois = new ObjectInputStream(fis);
            wordList = (Map<String, String>) ois.readObject();
            System.out.println(wordList);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
