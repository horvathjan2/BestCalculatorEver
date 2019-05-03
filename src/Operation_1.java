/**
 * @author Mohos Bálint
 * 
 * Operation_1 is an operation with 1 operand.
 * Operations with one operand that are added later must extend this class.
 */
public abstract class Operation_1 extends Operation_0 {
    /**
     * Stores the operand wich will be used for calculating the result.
     * Default value is null.
     */
    protected Double op_1 = null;

    /**
     * Sets the operand of the operation.
     * @param op The opernad.
     */
    public void setOperands(Double op) {
        op_1 = op;
    }
}