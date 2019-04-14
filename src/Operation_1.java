public abstract class Operation_1 implements Operation {
    protected double op_1;

    public Operation_1(Object op) {
        if(op instanceof Operation) {
            op_1 = ((Operation)(op)).calc();
        }
        else {
            op_1 = (double)op;
        }
    }

    public abstract double calc();
}