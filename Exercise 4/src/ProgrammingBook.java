public class ProgrammingBook extends Book{
    private String language;
    private String framework;

    public ProgrammingBook() {
    }

    public ProgrammingBook(String language, String framwork) {
        this.language = language;
        this.framework = framwork;
    }

    public ProgrammingBook(int bookCode, String name, double price, String author, String language, String framework) {
        super(bookCode, name, price, author);
        this.language = language;
        this.framework = framework;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFramwork() {
        return framework;
    }

    public void setFramwork(String framwork) {
        this.framework = framwork;
    }
}
