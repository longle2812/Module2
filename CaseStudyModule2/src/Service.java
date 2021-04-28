import java.io.*;
import java.util.*;

public class Service {
    Map<String, Entities> wordList = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    List<Example> pronounList = new LinkedList<>();
    List<Example> nounList = new LinkedList<>();
    List<Example> verbList = new LinkedList<>();
    List<Example> synonymList = new LinkedList<>();
    List<Example> adjectiveList = new LinkedList<>();

    public Service() {
    }

    public void writeToFile() {
        try {
            FileOutputStream fos = new FileOutputStream("dictionary.csv");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(wordList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void lookup(String keyword) {
        boolean isExist = false;
        for (Map.Entry<String, Entities> entry : wordList.entrySet()
        ) {
            if (entry.getKey().equals(keyword)) {
                System.out.println(entry.getValue());
                isExist = true;
            }
        }
        if (!isExist) {
            System.out.println(keyword + " is not exist");
        }
    }

    public void define(String params, String keyword) {
        boolean isWordExist = false;
        for (Map.Entry<String, Entities> entry : wordList.entrySet()
        ) {
            if (keyword.equals(entry.getKey())) {
                isWordExist = true;
                System.out.println("This word is exist");
                Example newExample = new Example();
                switch (params) {
                    case "-p":
                        addNewPronoun(newExample);
                        pronounList.add(newExample);
                        entry.getValue().setPronoun(pronounList);
                        break;
                    case "-n":
                        addNewNoun(newExample);
                        nounList.add(newExample);
                        entry.getValue().setNoun(nounList);
                        break;
                    case "-a":
                        addNewAdjective(newExample);
                        adjectiveList.add(newExample);
                        entry.getValue().setAdjective(adjectiveList);
                        break;
                    case "-v":
                        addNewVerb(newExample);
                        verbList.add(newExample);
                        entry.getValue().setVerb(verbList);
                        break;
                    case "-s":
                        addNewSynonym(newExample);
                        synonymList.add(newExample);
                        entry.getValue().setSynonym(synonymList);
                        break;
                }
                break;
            }
        }
        if (!isWordExist) {
            System.out.println(keyword + " is not exist in database, created new one");
            Entities typeOfWord = new Entities();
            Example newExample = new Example();
            switch (params) {
                case "-p":
                    addNewPronoun(newExample);
                    pronounList.add(newExample);
                    typeOfWord.setPronoun(pronounList);
                    wordList.put(keyword, typeOfWord);
                    break;
                case "-n":
                    addNewNoun(newExample);
                    nounList.add(newExample);
                    typeOfWord.setNoun(nounList);
                    wordList.put(keyword, typeOfWord);
                    break;
                case "-a":
                    addNewAdjective(newExample);
                    adjectiveList.add(newExample);
                    typeOfWord.setAdjective(adjectiveList);
                    wordList.put(keyword, typeOfWord);
                    break;
                case "-v":
                    addNewVerb(newExample);
                    verbList.add(newExample);
                    typeOfWord.setVerb(verbList);
                    wordList.put(keyword, typeOfWord);
                    break;
                case "-s":
                    addNewSynonym(newExample);
                    synonymList.add(newExample);
                    typeOfWord.setSynonym(synonymList);
                    wordList.put(keyword, typeOfWord);
                    break;
            }
        }
    }

    private void addNewSynonym(Example newExample) {
        String sentence;
        String sentenceMeaning;
        System.out.print("Synonymous definition:");
        String synDefinition = sc.nextLine();
        System.out.print("Sentence: ");
        sentence = sc.nextLine();
        System.out.println("Sentence's meaning: ");
        sentenceMeaning = sc.nextLine();
        newExample.setDefinition(synDefinition);
        newExample.setSentences(sentence + "\n" + sentenceMeaning);
    }

    private void addNewVerb(Example newExample) {
        String sentence;
        String sentenceMeaning;
        System.out.print("Verb definition:");
        String verbDefinition = sc.nextLine();
        System.out.print("Sentence: ");
        sentence = sc.nextLine();
        System.out.println("Sentence's meaning: ");
        sentenceMeaning = sc.nextLine();
        newExample.setDefinition(verbDefinition);
        newExample.setSentences(sentence + "\n" + sentenceMeaning);
    }

    private void addNewAdjective(Example newExample) {
        String sentence;
        String sentenceMeaning;
        System.out.print("Adjective definition:");
        String adjDefinition = sc.nextLine();
        System.out.print("Sentence: ");
        sentence = sc.nextLine();
        System.out.println("Sentence's meaning: ");
        sentenceMeaning = sc.nextLine();
        newExample.setDefinition(adjDefinition);
        newExample.setSentences(sentence + "\n" + sentenceMeaning);
    }

    private void addNewNoun(Example newExample) {
        String sentence;
        String sentenceMeaning;
        System.out.print("Noun definition:");
        String nounAdjective = sc.nextLine();
        System.out.print("Sentence: ");
        sentence = sc.nextLine();
        System.out.println("Sentence's meaning: ");
        sentenceMeaning = sc.nextLine();
        newExample.setDefinition(nounAdjective);
        newExample.setSentences(sentence + "\n" + sentenceMeaning);
    }

    private void addNewPronoun(Example newExample) {
        String sentence;
        System.out.print("Pronoun definition:");
        String pronounDefinition = sc.nextLine();
        System.out.print("Sentence: ");
        sentence = sc.nextLine();
        System.out.println("Sentence's meaning: ");
        String sentenceMeaning = sc.nextLine();
        newExample.setDefinition(pronounDefinition);
        newExample.setSentences(sentence + "\n" + sentenceMeaning + "\n");
    }

    public void display() {
        for (Map.Entry<String, Entities> entry : wordList.entrySet()
        ) {
            if (entry.getKey() != null) {
                System.out.println("**" + entry.getKey() + "**" + "\n" + entry.getValue());
            }
        }
    }

    public void drop(String keyword) {
        if (wordList.containsKey(keyword)) {
            wordList.remove(keyword);
        }
    }
}
