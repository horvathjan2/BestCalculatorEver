public class Negation extends Operation_1 {
    public Negation() {
        super();
    }
    public Negation(Object op) {
        super(op);
    }

    public Double calc() {
        return op_1 * -1;
    }
}