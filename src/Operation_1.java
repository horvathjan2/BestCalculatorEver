public abstract class Operation_1 implements Operation {
    protected Double op_1 = null;

    public void setOperands(Object op) {
        if (op instanceof Operation) {
            op_1 = ((Operation)(op)).calc();
        }
        else {
            op_1 = (Double)op;
        }
    }

    public abstract Double calc();
}