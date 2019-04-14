public abstract class Operation_2 implements Operation {
    protected double op_1;
    protected double op_2;

    public Operation_2(Object op1, Object op2) {
        if(op1 instanceof Operation) {
            op_1 = ((Operation)(op1)).calc();
        }
        else {
            op_1 = (double)op1;
        }

        if(op2 instanceof Operation) {
            op_2 = ((Operation)(op2)).calc();
        }
        else {
            op_2 = (double)op2;
        }
    }

    public abstract double calc();
}