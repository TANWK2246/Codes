public class ServiceChargeCalculator {
    private static final double rate = 0.10;

    public static double calculate(double amount){
        return Math.round(amount * rate * 100)/100.0;
    }
}
