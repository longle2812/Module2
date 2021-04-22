public class Document {
    private int id;
    private String publisher;
    private int editionNumber;
    private Book book;
    private Magazine magazine;
    private Newspaper newspaper;

    public Document() {
    }

    public Document(int id, String publisher, int editionNumber, Book book) {
        this.id = id;
        this.publisher = publisher;
        this.editionNumber = editionNumber;
        this.book = book;
    }

    public Document(int id, String publisher, int editionNumber, Magazine magazine) {
        this.id = id;
        this.publisher = publisher;
        this.editionNumber = editionNumber;
        this.magazine = magazine;
    }

    public Document(int id, String publisher, int editionNumber, Newspaper newspaper) {
        this.id = id;
        this.publisher = publisher;
        this.editionNumber = editionNumber;
        this.newspaper = newspaper;
    }

    public Document(int id, String publisher, int editionNumber) {
        this.id = id;
        this.publisher = publisher;
        this.editionNumber = editionNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getEditionNumber() {
        return editionNumber;
    }

    public void setEditionNumber(int editionNumber) {
        this.editionNumber = editionNumber;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", publisher='" + publisher + '\'' +
                ", editionNumber=" + editionNumber +
                '}';
    }

    public void printBook(Book book) {
        System.out.println("Document{" +
                "id=" + id +
                ", publisher='" + publisher +
                ", editionNumber=" + editionNumber +
                '}' + " " +
                book);
    }

    public void printMagazine(Magazine magazine) {
        System.out.println("Document{" +
                "id=" + id +
                ", publisher='" + publisher +
                ", editionNumber=" + editionNumber +
                '}' + " " +
                magazine);
    }

    public void printNewspaper(Newspaper newspaper) {
        System.out.println("Document{" +
                "id=" + id +
                ", publisher='" + publisher +
                ", editionNumber=" + editionNumber +
                '}' + " " +
                newspaper);
    }

}
