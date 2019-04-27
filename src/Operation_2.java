public abstract class Operation_2 implements Operation {
    protected Double op_1;
    protected Double op_2;

    public Operation_2() {
        op_1 = null;
        op_2 = null;
    }

    public Operation_2(Object op1, Object op2) {
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

    public abstract Double calc();
}