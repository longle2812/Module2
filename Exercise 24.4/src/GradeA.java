public class GradeA extends Student{
    private int math;
    private int physic;
    private int chemistry;

    public GradeA() {
    }

    public GradeA(int math, int physic, int chemistry) {
        this.math = math;
        this.physic = physic;
        this.chemistry = chemistry;
    }

    public GradeA(int id, String name, String address, int priority, int math, int physic, int chemistry) {
        super(id, name, address, priority);
        this.math = math;
        this.physic = physic;
        this.chemistry = chemistry;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getPhysic() {
        return physic;
    }

    public void setPhysic(int physic) {
        this.physic = physic;
    }

    public int getChemistry() {
        return chemistry;
    }

    public void setChemistry(int chemistry) {
        this.chemistry = chemistry;
    }

    @Override
    public String toString() {
        return "GradeA{" +
                "id= " + super.getId()+
                ", name= " +super.getName()+
                ", address= " +super.getAddress()+
                ", priority= " +super.getPriority()+
                ", math= " + math +
                ", physic= " + physic +
                ", chemistry= " + chemistry +
                '}';
    }
}
