public class FinancialForecasting {
    // Recursive method to calculate future value
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base case: if periods are 0, the future value is the present value
        if (periods == 0) {
            return presentValue;
        }
        // Recursive case: calculate the future value for one less period
        double futureValue = calculateFutureValue(presentValue, growthRate, periods - 1);
        return futureValue * (1 + growthRate);
    }

    public static void main(String[] args) {
        double presentValue = 1000.0;  // Example present value
        double growthRate = 0.05;  // Example growth rate (5%)
        int periods = 10;  // Example number of periods (years)

        double futureValue = calculateFutureValue(presentValue, growthRate, periods);
        System.out.println("The future value is: " + futureValue);
    }
}
