import java.util.Scanner;

interface NightService {
    boolean supportsNightService();
}

abstract class Cab {
    protected double km;
    protected String time;
    public static final double MIN_FARE = 100.0;
    
    public Cab(double km, String time) {
        this.km = km;
        this.time = time;
    }
    
    public abstract double getRatePerKm();
    public abstract String getCabName();
    
    public double calculateFare() {
        double base = km * getRatePerKm();
        double fare = Math.max(base, MIN_FARE);
        if (time.equals("NIGHT")) {
            fare *= 1.20;
        }
        return fare;
    }
}

class MiniCab extends Cab implements NightService {
    public MiniCab(double km, String time) { super(km, time); }
    @Override public double getRatePerKm() { return 10.0; }
    @Override public String getCabName() { return "MINI"; }
    @Override public boolean supportsNightService() { return false; }
}

class SedanCab extends Cab implements NightService {
    public SedanCab(double km, String time) { super(km, time); }
    @Override public double getRatePerKm() { return 14.0; }
    @Override public String getCabName() { return "SEDAN"; }
    @Override public boolean supportsNightService() { return true; }
}

class SuvCab extends Cab implements NightService {
    public SuvCab(double km, String time) { super(km, time); }
    @Override public double getRatePerKm() { return 18.0; }
    @Override public String getCabName() { return "SUV"; }
    @Override public boolean supportsNightService() { return true; }
}

public class A4 {
    @SuppressWarnings("ConvertToStringSwitch")
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) return;
            int n = scanner.nextInt();
            String[] inputsType = new String[n];
            double[] inputsKm = new double[n];
            String[] inputsTime = new String[n];

            for (int i = 0; i < n; i++) {
                inputsType[i] = scanner.next();
                inputsKm[i] = scanner.nextDouble();
                inputsTime[i] = scanner.next();
            }

            double total = 0;
            for (int i = 0; i < n; i++) {
                String type = inputsType[i];
                double km = inputsKm[i];
                String time = inputsTime[i];

                Cab cab = null;
                if (type.equals("MINI")) cab = new MiniCab(km, time);
                else if (type.equals("SEDAN")) cab = new SedanCab(km, time);
                else if (type.equals("SUV")) cab = new SuvCab(km, time);

                if (cab == null) {
                    continue;
                }

                if (time.equals("NIGHT") && cab instanceof NightService && !((NightService) cab).supportsNightService()) {
                    System.out.println(cab.getCabName() + ": night service not available");
                } else {
                    double fare = cab.calculateFare();
                    total += fare;
                    System.out.printf("%s: %.2f\n", cab.getCabName(), fare);
                }
            }
            System.out.printf("Total: %.2f\n", total);
        }
    }
}