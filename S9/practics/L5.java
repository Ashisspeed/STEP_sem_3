import java.util.Scanner;

abstract class TravelBooking {
    protected double distance;
    public static final double BOOKING_FEE = 50.0;
    
    public TravelBooking(double distance) { this.distance = distance; }
    public abstract double calculateBaseFare();
    public abstract String getModeName();
    
    public double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    public BusBooking(double distance) { super(distance); }
    @Override public double calculateBaseFare() { return distance * 2.0; }
    @Override public String getModeName() { return "BUS"; }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distance) { super(distance); }
    @Override public double calculateBaseFare() { return distance * 1.5; }
    @Override public String getModeName() { return "TRAIN"; }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distance) { super(distance); }
    @Override public double calculateBaseFare() { return 2500.0 + (distance * 4.0); }
    @Override public String getModeName() { return "FLIGHT"; }
}

public class L5 {
    @SuppressWarnings({"ConvertToTryWithResources", "ConvertToStringSwitch"})
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        TravelBooking[] bookings = new TravelBooking[n];
        
        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double dist = scanner.nextDouble();
            if (mode.equals("BUS")) {
                bookings[i] = new BusBooking(dist);
            } else if (mode.equals("TRAIN")) {
                bookings[i] = new TrainBooking(dist);
            } else if (mode.equals("FLIGHT")) {
                bookings[i] = new FlightBooking(dist);
            }
        }
        
        for (TravelBooking b : bookings) {
            System.out.printf("%s: %.2f\n", b.getModeName(), b.calculateTotal());
        }
        scanner.close();
    }
}