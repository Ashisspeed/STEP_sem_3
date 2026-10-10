import java.util.Scanner;

abstract class Journey {
    protected double distance;
    public Journey(double distance) { this.distance = distance; }
    public abstract double calculateFare();
    public abstract String getTypeName();
}

class BusJourney extends Journey {
    public BusJourney(double distance) { super(distance); }
    @Override public double calculateFare() {
        double fare = 2.0 + 0.10 * distance;
        return Math.min(fare, 10.0);
    }
    @Override public String getTypeName() { return "BUS"; }
}

class TrainJourney extends Journey {
    public TrainJourney(double distance) { super(distance); }
    @Override public double calculateFare() { return 3.0 + 0.15 * distance; }
    @Override public String getTypeName() { return "TRAIN"; }
}

class MetroJourney extends Journey {
    @SuppressWarnings("FieldMayBeFinal")
    private double peakFactor;
    public MetroJourney(double distance, double peakFactor) {
        super(distance);
        this.peakFactor = peakFactor;
    }
    @Override public double calculateFare() { return (1.50 + 0.20 * distance) * peakFactor; }
    @Override public String getTypeName() { return "METRO"; }
}

public class L5 {
    @SuppressWarnings({"ConvertToTryWithResources", "ConvertToStringSwitch"})
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Journey[] journeys = new Journey[n];
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();
            if (type.equals("BUS")) {
                journeys[i] = new BusJourney(distance);
            } else if (type.equals("TRAIN")) {
                journeys[i] = new TrainJourney(distance);
            } else if (type.equals("METRO")) {
                double factor = scanner.nextDouble();
                journeys[i] = new MetroJourney(distance, factor);
            }
        }
        
        double total = 0;
        for (Journey j : journeys) {
            double fare = j.calculateFare();
            total += fare;
            System.out.printf("%s: %.2f\n", j.getTypeName(), fare);
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}