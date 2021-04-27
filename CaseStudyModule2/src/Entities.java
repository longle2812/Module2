import java.io.Serializable;

public class Entities implements Serializable {
    private String value;

    public Entities() {
    }

    public Entities(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
