public class DiscountCalculator {
    private static final double rate = 0.15;

    public static double calculate(double amount, boolean hasMembership){
        if(hasMembership == false) return 0;
        return Math.round(amount * rate * 100)/100.0;
    }
}
