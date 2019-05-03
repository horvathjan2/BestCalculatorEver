/**
 * @author Mohos Bálint
 * 
 * Subtraction is a default operation with two opernads that is used by the calculator.
 * Extends Operation_2.
 */
public class Subtraction extends Operation_2 {
    public Double calc() {
        return op_1 - op_2;
    }
    public String getSymbol() {
        return "-";
    }
}