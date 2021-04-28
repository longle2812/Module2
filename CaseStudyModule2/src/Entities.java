import java.io.Serializable;
import java.util.List;

public class Entities implements Serializable {
    private String name;
    private List<Example> pronoun;
    private List<Example> noun;
    private List<Example> adjective;
    private List<Example> verb;
    private List<Example> synonym;

    public List<Example> getSynonym() {
        return synonym;
    }

    public void setSynonym(List<Example> synonym) {
        this.synonym = synonym;
    }

    public Entities() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Example> getPronoun() {
        return pronoun;
    }

    public void setPronoun(List<Example> pronoun) {
        this.pronoun = pronoun;
    }

    public List<Example> getNoun() {
        return noun;
    }

    public void setNoun(List<Example> noun) {
        this.noun = noun;
    }

    public List<Example> getAdjective() {
        return adjective;
    }

    public void setAdjective(List<Example> adjective) {
        this.adjective = adjective;
    }

    public List<Example> getVerb() {
        return verb;
    }

    public void setVerb(List<Example> verb) {
        this.verb = verb;
    }

    @Override
    public String toString() {
        String str = "";
        if (!showPronoun().equals("")) {
            str += "@ Phát âm" + "\n" + showPronoun();
        }
        if (!showNoun().equals("")) {
            str += "@ Danh từ" + "\n" + showNoun();
        }
        if (!showAdjective().equals("")) {
            str += "@ Tính từ" + "\n" + showAdjective();
        }
        if (!showVerb().equals("")) {
            str += "@ Động từ" + "\n" + showVerb();
        }
        if (!showSynonym().equals("")) {
            str += "@ Đồng âm" + "\n" + showSynonym();
        }
        return str;
    }

    public String showPronoun() {
        String str = "";
        if (this.pronoun != null) {
            for (Example pronouns :
                    pronoun) {
                if (pronouns != null)
                    str += pronouns + "\n";
            }
        }
        return str;
    }

    public String showNoun() {
        String str = "";
        if (this.noun != null) {
            for (Example nouns :
                    noun) {
                if (nouns != null)
                    str += nouns + "\n";
            }
        }
        return str;
    }

    public String showVerb() {
        String str = "";
        if (this.verb != null) {
            for (Example verbs :
                    verb) {
                if (verbs != null)
                    str += verbs + "\n";
            }
        }
        return str;
    }

    public String showAdjective() {
        String str = "";
        if (this.adjective != null) {
            for (Example adjectives :
                    adjective) {
                if (adjectives != null)
                    str += adjectives + "\n";
            }
        }
        return str;
    }

    public String showSynonym() {
        String str = "";
        if (this.synonym != null) {
            for (Example synonyms :
                    synonym) {
                if (synonyms != null)
                    str += synonyms + "\n";
            }
        }
        return str;
    }
}
