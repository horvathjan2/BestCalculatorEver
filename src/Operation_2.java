/**
 * @author Mohos Bálint
 * 
 * Operation_2 is an operation with 2 operands.
 * Operations with two operand that are added later must extend this class.
 */
public abstract class Operation_2 extends Operation_1 {
    /**
     * Stores the second operand wich will be used for calculating the result.
     * Default value is null.
     */
    protected Double op_2 = null;

    /**
     * Sets the operands of the operation.
     * @param op1 The first opernad.
     * @param op2 The second operand.
     */
    public void setOperands(Double op1, Double op2) {
            op_1 = op1;
            op_2 = op2;
    }
}