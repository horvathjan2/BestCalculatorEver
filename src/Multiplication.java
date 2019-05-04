/**
 * @author Mohos Bálint
 * 
 * Multiplication is a default operation with two operands that is used by the calculator.
 * Extends Operation_2.
 */
public class Multiplication extends Operation_2 {
    public Double calc() {
        return op_1 * op_2;
    }
    public String getSymbol() {
        return "*";
    }
}