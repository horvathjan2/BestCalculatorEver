public class Negation extends Operation_1 {
    public void setOperands(Object op) {
        super.setOperands(op);
    }

    public Double calc() {
        return op_1 * -1;
    }
    public String getSymbol() {
        return "+/-";
    }
}