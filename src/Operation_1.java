public abstract class Operation_1 extends Operation_0 {
    protected Double op_1 = null;

    public void setOperands(Object op) {
        if (op instanceof Operation) {
            op_1 = ((Operation)(op)).calc();
        }
        else {
            op_1 = (Double)op;
        }
    }
}