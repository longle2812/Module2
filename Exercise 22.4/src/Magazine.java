public class Magazine extends Document {
    private int numberEdition;
    private String monthEdition;

    public Magazine() {
    }

    public Magazine(int numberEdition, String monthEdition) {
        this.numberEdition = numberEdition;
        this.monthEdition = monthEdition;
    }

    public Magazine(int id, String publisher, int editionNumber, int numberEdition, String monthEdition) {
        super(id, publisher, editionNumber);
        this.numberEdition = numberEdition;
        this.monthEdition = monthEdition;
    }

    public int getNumberEdition() {
        return numberEdition;
    }

    public void setNumberEdition(int numberEdition) {
        this.numberEdition = numberEdition;
    }

    public String getMonthEdition() {
        return monthEdition;
    }

    public void setMonthEdition(String monthEdition) {
        this.monthEdition = monthEdition;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "numberEdition=" + numberEdition +
                ", monthEdition='" + monthEdition + '\'' +
                '}';
    }
}
