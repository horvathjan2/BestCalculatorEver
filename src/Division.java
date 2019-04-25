public class Division extends Operation_2 {
    public Division() {
        super();
    }
    public Division(Object op1, Object op2) {
        super(op1, op2);
    }

    public Double calc() {
        return op1 / op2;
    }
}