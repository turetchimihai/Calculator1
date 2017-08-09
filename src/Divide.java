public class Divide {
    public double divide(double a, double b) {
        double result = 0;
        try {
            result = a / b;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
