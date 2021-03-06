import java.io.Serializable;

public class Example implements Serializable {
    private String definition;
    private String sentences;

    public Example() {
    }

    public Example(String definition, String sentences) {
        this.definition = definition;
        this.sentences = sentences;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getSentences() {
        return sentences;
    }

    public void setSentences(String sentences) {
        this.sentences = sentences;
    }

    @Override
    public String toString() {
        if (this.sentences != null) {
            return "- " + this.definition +
                    "\n" +
                    "+ " + this.sentences;
        } else return "- " + this.definition;
    }
}
