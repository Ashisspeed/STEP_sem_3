import java.util.Scanner;

interface Insurable {
    double calculateInsurance(double declaredValue);
}

abstract class Parcel {
    protected double weightKg, declaredValue;
    public Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }
    public abstract double calculateCharge();
    public abstract String getTypeName();
}

class StandardParcel extends Parcel {
    public StandardParcel(double w, double v) { super(w, v); }
    @Override public double calculateCharge() { return 40.0 + (10.0 * weightKg); }
    @Override public String getTypeName() { return "STANDARD"; }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double w, double v) { super(w, v); }
    @Override public double calculateCharge() { return 80.0 + (15.0 * weightKg); }
    @Override public String getTypeName() { return "EXPRESS"; }
    @Override public double calculateInsurance(double value) { return value * 0.02; }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double w, double v) { super(w, v); }
    @Override public double calculateCharge() { return 40.0 + (10.0 * weightKg) + 50.0; }
    @Override public String getTypeName() { return "FRAGILE"; }
    @Override public double calculateInsurance(double value) { return value * 0.02; }
}

public class A2 {
    @SuppressWarnings("ConvertToStringSwitch")
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) return;
            int n = scanner.nextInt();
            Parcel[] parcels = new Parcel[n];

            for (int i = 0; i < n; i++) {
                String type = scanner.next();
                double w = scanner.nextDouble();
                double v = scanner.nextDouble();
                if (type.equals("STANDARD")) {
                    parcels[i] = new StandardParcel(w, v);
                } else if (type.equals("EXPRESS")) {
                    parcels[i] = new ExpressParcel(w, v);
                } else if (type.equals("FRAGILE")) {
                    parcels[i] = new FragileParcel(w, v);
                }
            }

            double grandTotal = 0;
            for (Parcel p : parcels) {
                double charge = p.calculateCharge();
                double insurance = 0.0;
                if (p instanceof Insurable insurable) {
                    insurance = insurable.calculateInsurance(p.declaredValue);
                }
                double total = charge + insurance;
                grandTotal += total;
                System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n", p.getTypeName(), charge, insurance, total);
            }
            System.out.printf("Grand Total: %.2f\n", grandTotal);
        }
    }
}