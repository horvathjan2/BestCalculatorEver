public class Addition extends Operation_2 {
    public Addition() {
        super();
    }
    public Addition(Object op1, Object op2) {
        super(op1, op2);
    }

    public Double calc() {
        return op_1 + op_2;
    }
}