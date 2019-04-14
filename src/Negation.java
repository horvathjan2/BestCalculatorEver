public class Negation extends Operation_1 {
    public Negation(Object op) {
        super(op);
    }

    public double calc() {
        return op_1 * -1;
    }
}