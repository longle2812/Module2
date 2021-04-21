public class CBGV {
    private double gross_salary;
    private double bonus;
    private double penalty;
    private double net_salary;
    private CanBo canbo;

    public CBGV() {
    }

    public CBGV(double gross_salary, double bonus, double penalty, CanBo canbo) {
        this.gross_salary = gross_salary;
        this.bonus = bonus;
        this.penalty = penalty;
        this.canbo = canbo;
    }


    public double getGross_salary() {
        return gross_salary;
    }

    public void setGross_salary(double gross_salary) {
        this.gross_salary = gross_salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    public double getNet_salary() {
        return net_salary;
    }

    public void setNet_salary(double net_salary) {
        this.net_salary = net_salary;
    }

    @Override
    public String toString() {
        return "CBGV{" +
                ", canbo=" + canbo +
                "gross_salary=" + gross_salary +
                ", bonus=" + bonus +
                ", penalty=" + penalty +
                ", net_salary=" + net_salary +
                '}';
    }
}
