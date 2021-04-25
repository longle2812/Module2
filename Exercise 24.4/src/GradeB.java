public class GradeB extends Student{
    private int math;
    private int chemistry;
    private int biology;

    public GradeB() {
    }

    public GradeB(int math, int chemistry, int biology) {
        this.math = math;
        this.chemistry = chemistry;
        this.biology = biology;
    }

    public GradeB(int id, String name, String address, int priority, int math, int chemistry, int biology) {
        super(id, name, address, priority);
        this.math = math;
        this.chemistry = chemistry;
        this.biology = biology;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getChemistry() {
        return chemistry;
    }

    public void setChemistry(int chemistry) {
        this.chemistry = chemistry;
    }

    public int getBiology() {
        return biology;
    }

    public void setBiology(int biology) {
        this.biology = biology;
    }

    @Override
    public String toString() {
        return "GradeB{" +
                "id=" + super.getId()+
                ", name=" +super.getName()+
                ", address=" +super.getAddress()+
                ", priority=" +super.getPriority()+
                "math=" + math +
                ", chemistry=" + chemistry +
                ", biology=" + biology +
                '}';
    }
}
