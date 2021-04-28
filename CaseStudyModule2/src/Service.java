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
    String sentence;
    String sentenceMeaning;
    Example newExample;

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
                newExample = new Example();
                switch (params) {
                    case "-p":
                        addNewPronoun();
                        pronounList = entry.getValue().getPronoun();
                        pronounList.add(newExample);
                        entry.getValue().setPronoun(pronounList);
                        break;
                    case "-n":
                        addNewNoun();
                        nounList = entry.getValue().getNoun();
                        nounList.add(newExample);
                        entry.getValue().setNoun(nounList);
                        break;
                    case "-a":
                        addNewAdjective();
                        adjectiveList = entry.getValue().getVerb();
                        adjectiveList.add(newExample);
                        entry.getValue().setAdjective(adjectiveList);
                        break;
                    case "-v":
                        addNewVerb();
                        verbList = entry.getValue().getVerb();
                        verbList.add(newExample);
                        entry.getValue().setVerb(verbList);
                        break;
                    case "-s":
                        addNewSynonym();
                        synonymList = entry.getValue().getSynonym();
                        synonymList.add(newExample);
                        entry.getValue().setSynonym(synonymList);
                        break;
                }
                System.out.println("Saved!");
                break;
            }
        }
        if (!isWordExist) {
            System.out.println(keyword + " is not exist in database, created new one");
            Entities typeOfWord = new Entities();
            newExample = new Example();
            switch (params) {
                case "-p":
                    addNewPronoun();
                    pronounList = new LinkedList<>();
                    pronounList.add(newExample);
                    typeOfWord.setPronoun(pronounList);
                    wordList.put(keyword, typeOfWord);
                    break;
                case "-n":
                    addNewNoun();
                    nounList = new LinkedList<>();
                    nounList.add(newExample);
                    typeOfWord.setNoun(nounList);
                    wordList.put(keyword, typeOfWord);
                    break;
                case "-a":
                    addNewAdjective();
                    adjectiveList = new LinkedList<>();
                    adjectiveList.add(newExample);
                    typeOfWord.setAdjective(adjectiveList);
                    wordList.put(keyword, typeOfWord);
                    break;
                case "-v":
                    addNewVerb();
                    verbList = new LinkedList<>();
                    verbList.add(newExample);
                    typeOfWord.setVerb(verbList);
                    wordList.put(keyword, typeOfWord);
                    break;
                case "-s":
                    addNewSynonym();
                    synonymList = new LinkedList<>();
                    synonymList.add(newExample);
                    typeOfWord.setSynonym(synonymList);
                    wordList.put(keyword, typeOfWord);
                    break;
            }
            System.out.println("Saved!");
        }
    }

    private void addNewSynonym() {
        System.out.print("Synonymous definition:");
        String synDefinition = sc.nextLine();
        newExample.setDefinition(synDefinition);
        addSentences();
    }

    private void addNewVerb() {
        System.out.print("Verb definition:");
        String verbDefinition = sc.nextLine();
        newExample.setDefinition(verbDefinition);
        addSentences();
    }

    private void addSentences() {
        System.out.println("Add new sentences?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice){
            case 1:
                System.out.print("Sentence: ");
                sentence = sc.nextLine();
                System.out.println("Sentence's meaning: ");
                sentenceMeaning = sc.nextLine();
                newExample.setSentences(sentence+"\n"+sentenceMeaning);
                break;
            case 2:
                 newExample.setSentences(null);
                break;
        }
    }

    private void addNewAdjective() {
        System.out.print("Adjective definition:");
        String adjDefinition = sc.nextLine();
        newExample.setDefinition(adjDefinition);
        addSentences();
    }

    private void addNewNoun() {
        System.out.print("Noun definition:");
        String nounDefinition = sc.nextLine();
        newExample.setDefinition(nounDefinition);
        addSentences();
    }

    private void addNewPronoun() {
        System.out.print("Pronoun definition:");
        String pronounDefinition = sc.nextLine();
        newExample.setDefinition(pronounDefinition);
        addSentences();
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
