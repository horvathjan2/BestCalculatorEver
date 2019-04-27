public abstract class Operation_2 extends Operation_1 {
    protected Double op_2 = null;

    public void setOperands(Object op1, Object op2) {
        if (op1 instanceof Operation) {
            op_1 = ((Operation)(op1)).calc();
        }
        else {
            op_1 = (Double)op1;
        }

        if (op2 instanceof Operation) {
            op_2 = ((Operation)(op2)).calc();
        }
        else {
            op_2 = (Double)op2;
        }
    }
}