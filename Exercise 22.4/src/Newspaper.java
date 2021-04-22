public class Newspaper extends Document {
    private String datePublish;

    public Newspaper() {
    }

    public Newspaper(String datePublish) {
        this.datePublish = datePublish;
    }

    public Newspaper(int id, String publisher, int editionNumber, String datePublish) {
        super(id, publisher, editionNumber);
        this.datePublish = datePublish;
    }

    public String getDatePublish() {
        return datePublish;
    }

    public void setDatePublish(String datePublish) {
        this.datePublish = datePublish;
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "datePublish='" + datePublish + '\'' +
                '}';
    }
}
