/**
 * @author Mohos Bálint
 * 
 * Negation is a default operation with one operand that is used by the calculator.
 * Extends Operation_1.
 */
public class Negation extends Operation_1 {
    public Double calc() {
        return op_1 * -1;
    }
    public String getSymbol() {
        return "+/-";
    }
}