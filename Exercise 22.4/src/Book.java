public class Book extends Document {
    private String author;
    private int page;

    public Book() {
    }

    public Book(String author, int page) {
        this.author = author;
        this.page = page;
    }

    public Book(int id, String publisher, int editionNumber, String author, int page) {
        super(id, publisher, editionNumber);
        this.author = author;
        this.page = page;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", page=" + page +
                '}';
    }

}
