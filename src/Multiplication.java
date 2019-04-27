public class Multiplication extends Operation_2 {
    public Multiplication() {
        super();
    }
    public Multiplication(Object op1, Object op2) {
        super(op1, op2);
    }

    public Double calc() {
        return op_1 * op_2;
    }
}