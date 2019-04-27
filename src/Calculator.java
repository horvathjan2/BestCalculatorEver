public class Calculator {
    private Double num1 = null;
    private Double num2 = null;
    private Operation_1 op = null;


    public void pushNumber(double num) {
        if (num1 == null) {
            num1 = num;
        }
        else if (op instanceof Operation_2) {
            num2 = num;
            ((Operation_2)(op)).setOperands(num1, num2);
            num1 = op.calc();
            num2 = null;
        }
    }
    public void pushOperation(Operation_1 op) {
        this.op = op;
        if (!(op instanceof Operation_2)) {
            op.setOperands(num1);
            num1 = op.calc();
            num2 = null;
        }
    }
    public double getResult() {
        System.out.println(num1);
        return num1;
    }
    public void clear() {
        num1 = null;
        num2 = null;
        op = null;
    }
}