public class Subtraction extends Operation_2 {
    public void setOperands(Double op1, Double op2) {
        super.setOperands(op1, op2);
    }

    public Double calc() {
        return op_1 - op_2;
    }
    public String getSymbol() {
        return "-";
    }
}