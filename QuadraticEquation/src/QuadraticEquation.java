public class QuadraticEquation {
    double a, b, c;

    public QuadraticEquation() {
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        return Math.pow(this.b,2) - (4 * this.a * this.c);
    }

    public double  getRoot1() {
        if (this.getDiscriminant() > 0) {
        return (-this.b + Math.sqrt(this.getDiscriminant())) / (2*this.a);
        }
        else if (this.getDiscriminant() == 0) {
            return -this.b / (2*this.a);
        }
        else return 0;
    }

    public double  getRoot2() {
        if (this.getDiscriminant() > 0) {
            return (-this.b - Math.sqrt(Math.pow(this.b,2) - 4*this.a*this.c))/ (2*this.a);
        }
        else return 0;
    }

    public String result(){
        if (this.getDiscriminant() < 0) {
            return "Phuong trinh vo nghiem";
        }
        else if (this.getDiscriminant() == 0) {
            return "Phuong trinh co nghiem kep " + this.getRoot1();
        }
        else return "Phuong trinh co nghiem x1 "+ this.getRoot1()+ ", x2 "+ this.getRoot2();
    }
}
