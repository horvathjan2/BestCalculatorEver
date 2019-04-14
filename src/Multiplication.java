public class Multiplication extends Operation_2 {
    public Multiplication(Object op1, Object op2) {
        super(op1, op2);
    }

    public double calc() {
        return op_1 * op_2;
    }
}