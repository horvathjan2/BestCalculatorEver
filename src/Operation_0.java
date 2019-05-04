/**
 * @author Mohos Bálint
 * 
 * Operation_0 represents an operation with no operands wich is a constant.
 * Constants that are later added must extend this class and override the functions.
 * Every operation extends this class.
 * This class could be an interface since every method is abstract but for consistency reasons it stayed an abstract class.
 */
public abstract class Operation_0 {
    /**
     * @return The calculated value of the operation.
     */
    public abstract Double calc();
    /**
     * @return Character(s) that represents the operation.
     */
    public abstract String getSymbol();
}