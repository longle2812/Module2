import java.io.*;
import java.util.*;

public class Service {
    Map<String, Entities> wordList = new LinkedHashMap<>();
    Scanner sc = new Scanner(System.in);

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
//            input.setValue(keyword);
//            wordList.put(input.getValue(), input.getValue());
            oos.writeObject(wordList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void lookup(String keyword) {
        readFile();

    }

    public void readFile() {
        try {
            FileInputStream fis = new FileInputStream("dictionary.csv");
            ObjectInputStream ois = new ObjectInputStream(fis);
            wordList = (Map<String, Entities>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void define(String params, String keyword) {
        boolean isWordExist = false;
        for (Map.Entry<String, Entities> entry : wordList.entrySet()
        ) {
            if (keyword.equals(entry.getKey())) {
                isWordExist = true;
                System.out.println("This word is exist");
                String sentence="";
                Entities type = new Entities();
                List<Example> pronounce = new LinkedList<>();
                List<Example> noun = new LinkedList<>();
                List<Example> verb = new LinkedList<>();
                List<Example> synonym = new LinkedList<>();
                List<Example> adjective = new LinkedList<>();
                Example newExample = new Example();
                switch (params) {
                    case "-p":
                        System.out.print("Pronoun definition:");
                        String pronounDefinition = sc.nextLine();
                        System.out.print("Sentence: ");
                        sentence = sc.nextLine();
                        System.out.println("Sentence's meaning: ");
                        String sentenceMeaning = sc.nextLine();
                        newExample.setDefinition(pronounDefinition);
                        newExample.setSentences(sentence+"\n"+sentenceMeaning+"\n");
                        entry.getValue().getPronoun().add(newExample);
                        for (Map.Entry<String, Entities> value: wordList.entrySet()
                             ) {
                            System.out.println(value);
                        }
                        break;
                    case "-n":
                        System.out.print("Noun definition:");
                        String nounAdjective = sc.nextLine();
                        System.out.print("Sentence: ");
                        sentence = sc.nextLine();
                        System.out.println("Sentence's meaning: ");
                        sentenceMeaning = sc.nextLine();
                        newExample.setDefinition(nounAdjective);
                        newExample.setSentences(sentence+"\n"+sentenceMeaning);
                        entry.getValue().getNoun().add(newExample);
                        for (Map.Entry<String, Entities> value: wordList.entrySet()
                        ) {
                            System.out.println(value);
                        }
                        break;
                    case "-a":
                        System.out.print("Adjective definition:");
                        String adjDefinition = sc.nextLine();
                        System.out.print("Sentence: ");
                        sentence = sc.nextLine();
                        System.out.println("Sentence's meaning: ");
                        sentenceMeaning = sc.nextLine();
                        newExample.setDefinition(adjDefinition);
                        newExample.setSentences(sentence+"\n"+sentenceMeaning);
                        entry.getValue().getAdjective().add(newExample);
                        for (Map.Entry<String, Entities> value: wordList.entrySet()
                        ) {
                            System.out.println(value);
                        }
                        break;
                    case "-v":
                        System.out.print("Verb definition:");
                        String verbDefinition = sc.nextLine();
                        System.out.print("Sentence: ");
                        sentence = sc.nextLine();
                        System.out.println("Sentence's meaning: ");
                        sentenceMeaning = sc.nextLine();
                        newExample.setDefinition(verbDefinition);
                        newExample.setSentences(sentence+"\n"+sentenceMeaning);
                        entry.getValue().getVerb().add(newExample);
                        for (Map.Entry<String, Entities> value: wordList.entrySet()
                        ) {
                            System.out.println(value);
                        }
                        break;
                    case "-s":
                        System.out.print("Synonymous definition:");
                        String synDefinition = sc.nextLine();
                        System.out.print("Sentence: ");
                        sentence = sc.nextLine();
                        System.out.println("Sentence's meaning: ");
                        sentenceMeaning = sc.nextLine();
                        newExample.setDefinition(synDefinition);
                        newExample.setSentences(sentence+"\n"+sentenceMeaning);
                        entry.getValue().getSynonym().add(newExample);
                        for (Map.Entry<String, Entities> value: wordList.entrySet()
                        ) {
                            System.out.println(value);
                        }
                        break;
                }
            }
        }
        if (!isWordExist) {
            System.out.println(keyword + " is not exist in database, created new one");
            String sentence="";
            Entities type = new Entities();
            List<Example> pronounce = new LinkedList<>();
            List<Example> noun = new LinkedList<>();
            List<Example> verb = new LinkedList<>();
            List<Example> synonym = new LinkedList<>();
            List<Example> adjective = new LinkedList<>();
            Example newExample = new Example();
            switch (params) {
                case "-p":
                    System.out.print("Pronoun definition:");
                    String pronounDefinition = sc.nextLine();
                    System.out.print("Sentence: ");
                    sentence = sc.nextLine();
                    System.out.println("Sentence's meaning: ");
                    String sentenceMeaning = sc.nextLine();
                    newExample.setDefinition(pronounDefinition);
                    newExample.setSentences(sentence+"\n"+sentenceMeaning+"\n");
                    pronounce.add(newExample);
                    type.setPronoun(pronounce);
                    wordList.put(keyword,type);
                    break;
                case "-n":
                    System.out.print("Noun definition:");
                    String nounAdjective = sc.nextLine();
                    System.out.print("Sentence: ");
                    sentence = sc.nextLine();
                    System.out.println("Sentence's meaning: ");
                    sentenceMeaning = sc.nextLine();
                    newExample.setDefinition(nounAdjective);
                    newExample.setSentences(sentence+"\n"+sentenceMeaning);
                    noun.add(newExample);
                    type.setNoun(noun);
                    wordList.put(keyword,type);
                    break;
                case "-a":
                    System.out.print("Adjective definition:");
                    String adjDefinition = sc.nextLine();
                    System.out.print("Sentence: ");
                    sentence = sc.nextLine();
                    System.out.println("Sentence's meaning: ");
                    sentenceMeaning = sc.nextLine();
                    newExample.setDefinition(adjDefinition);
                    newExample.setSentences(sentence+"\n"+sentenceMeaning);
                    adjective.add(newExample);
                    type.setAdjective(adjective);
                    wordList.put(keyword,type);
                    break;
                case "-v":
                    System.out.print("Verb definition:");
                    String verbDefinition = sc.nextLine();
                    System.out.print("Sentence: ");
                    sentence = sc.nextLine();
                    System.out.println("Sentence's meaning: ");
                    sentenceMeaning = sc.nextLine();
                    newExample.setDefinition(verbDefinition);
                    newExample.setSentences(sentence+"\n"+sentenceMeaning);
                    verb.add(newExample);
                    type.setVerb(verb);
                    wordList.put(keyword,type);
                    break;
                case "-s":
                    System.out.print("Synonymous definition:");
                    String synDefinition = sc.nextLine();
                    System.out.print("Sentence: ");
                    sentence = sc.nextLine();
                    System.out.println("Sentence's meaning: ");
                    sentenceMeaning = sc.nextLine();
                    newExample.setDefinition(synDefinition);
                    newExample.setSentences(sentence+"\n"+sentenceMeaning);
                    synonym.add(newExample);
                    type.setSynonym(synonym);
                    wordList.put(keyword,type);
                    break;
            }
        }
    }
}
