/**
 * @author Mohos Bálint
 * 
 * The Calculator class is using the operations and calculates the commands given by the GUI.
 */
public class Calculator {
    /**
     * The primary value wich is the result of an operation or the first operand of an operation that is not yet calculated.
     * Default value is null.
     */
    private Double num1 = null;
    /**
     * The secudary value wich is usually used as the secund operand of an operation.
     * Default value is null.
     */
    private Double num2 = null;
    /**
     * The operations wich the calculator will be useing or was using.
     */
    private Operation_1 op = null;

    /**
     * Sets the apropriet operand for the calculator to use.
     * @param num A number that is given to the calculator.
     */
    public void pushNumber(double num) {
        if (num1 == null) {
            num1 = num;
        }
        else if (op instanceof Operation_2) {
            num2 = num;
            ((Operation_2)(op)).setOperands(num1, num2);
            num1 = op.calc();
            num2 = null;
        }
    }
    /**
     * Sets the operation for the calculator to use.
     * @param op An operation that is given to the calculator.
     */
    public void pushOperation(Operation_1 op) {
        this.op = op;
        if (!(op instanceof Operation_2)) {
            op.setOperands(num1);
            num1 = op.calc();
            num2 = null;
        }
    }
    /**
     * Gets the primary value that is stored in the calculator wich can be the result of an operation or the first operand of an operation that is not yet calculated.
     * @return The primary value that is stored in the calculator.
     */
    public double getResult() {
        System.out.println(num1);
        return num1;
    }
    /**
     * Clears the operands and the operation.
     */
    public void clear() {
        num1 = null;
        num2 = null;
        op = null;
    }
}