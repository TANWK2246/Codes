/**
 * The type Discount calculator.
 */
public class DiscountCalculator {
    /**
     * The constant rate.
     */
    private static final double rate = 0.15;

    /**
     * Calculate double.
     *
     * @param amount        the amount
     * @param hasMembership the has membership
     * @return the double
     */
    public static double calculate(double amount, boolean hasMembership){
        if(hasMembership == false) return 0;
        return Math.round(amount * rate * 100)/100.0;
    }
}
