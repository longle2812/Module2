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
        return this.name + "\n" + this.pronoun;
    }
}
