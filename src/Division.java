public class Division extends Operation_2 {
    public void setOperands(Object op1, Object op2) {
        super.setOperands(op1, op2);
    }

    public Double calc() {
        return op_1 / op_2;
    }
    public String getSymbol() {
        return "/";
    }
}