/**
 * @author Mohos Bálint
 * 
 * Addition is a default operation with two operands that is used by the calculator.
 * Extends Operation_2.
 */
public class Addition extends Operation_2 {
    public Double calc() {
        return op_1 + op_2;
    }
    public String getSymbol() {
        return "+";
    }
}