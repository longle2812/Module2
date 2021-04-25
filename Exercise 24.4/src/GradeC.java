public class GradeC extends Student{
    private int literature;
    private int history;
    private int geography;

    public GradeC() {
    }

    public GradeC(int literature, int history, int geography) {
        this.literature = literature;
        this.history = history;
        this.geography = geography;
    }

    public GradeC(int id, String name, String address, int priority, int literature, int history, int geography) {
        super(id, name, address, priority);
        this.literature = literature;
        this.history = history;
        this.geography = geography;
    }

    public int getLiterature() {
        return literature;
    }

    public void setLiterature(int literature) {
        this.literature = literature;
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public int getGeography() {
        return geography;
    }

    public void setGeography(int geography) {
        this.geography = geography;
    }

    @Override
    public String toString() {
        return "GradeC{" +
                "id=" + super.getId()+
                ", name=" +super.getName()+
                ", address=" +super.getAddress()+
                ", priority=" +super.getPriority()+
                "literature=" + literature +
                ", history=" + history +
                ", geography=" + geography +
                '}';
    }
}
