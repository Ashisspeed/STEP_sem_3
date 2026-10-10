import java.util.Scanner;

abstract class Delivery {
    protected double weight, distance;
    public Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }
    public abstract double calculateFee();
    public abstract String getTypeName();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double w, double d) { super(w, d); }
    @Override public double calculateFee() { return 5.0 + 0.50 * weight + 0.10 * distance; }
    @Override public String getTypeName() { return "STANDARD"; }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double w, double d) { super(w, d); }
    @Override public double calculateFee() { return 15.0 + 1.00 * weight + 0.20 * distance; }
    @Override public String getTypeName() { return "EXPRESS"; }
}

class InternationalDelivery extends Delivery {
    @SuppressWarnings("FieldMayBeFinal")
    private double customsFee;
    public InternationalDelivery(double w, double d, double customsFee) {
        super(w, d);
        this.customsFee = customsFee;
    }
    @Override public double calculateFee() { return 25.0 + 2.00 * weight + 0.50 * distance + customsFee; }
    @Override public String getTypeName() { return "INTERNATIONAL"; }
}

public class L3 {
    @SuppressWarnings({"ConvertToStringSwitch", "ConvertToTryWithResources"})
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Delivery[] deliveries = new Delivery[n];
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();
            if (type.equals("STANDARD")) {
                deliveries[i] = new StandardDelivery(weight, distance);
            } else if (type.equals("EXPRESS")) {
                deliveries[i] = new ExpressDelivery(weight, distance);
            } else if (type.equals("INTERNATIONAL")) {
                double customs = scanner.nextDouble();
                deliveries[i] = new InternationalDelivery(weight, distance, customs);
            }
        }
        
        double total = 0;
        for (Delivery d : deliveries) {
            double fee = d.calculateFee();
            total += fee;
            System.out.printf("%s: %.2f\n", d.getTypeName(), fee);
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}