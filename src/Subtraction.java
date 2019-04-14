public class Subtraction extends Operation_2 {
    public Subtraction(Object op1, Object op2) {
        super(op1, op2);
    }

    public double calc() {
        return op1 - op2;
    }
}