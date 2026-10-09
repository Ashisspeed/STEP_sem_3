import java.util.Scanner;

abstract class VehicleParking {
    protected int hours;
    public VehicleParking(int hours) { this.hours = hours; }
    public abstract double calculateCharge();
    public abstract String getVehicleType();
}

class BikeParking extends VehicleParking {
    public BikeParking(int h) { super(h); }
    @Override public double calculateCharge() { return hours * 10.0; }
    @Override public String getVehicleType() { return "BIKE"; }
}

class CarParking extends VehicleParking {
    public CarParking(int h) { super(h); }
    @Override public double calculateCharge() {
        if (hours <= 1) return 30.0;
        return 30.0 + (hours - 1) * 20.0;
    }
    @Override public String getVehicleType() { return "CAR"; }
}

class TruckParking extends VehicleParking {
    public TruckParking(int h) { super(h); }
    @Override public double calculateCharge() {
        double charge = hours * 50.0;
        return Math.max(charge, 100.0);
    }
    @Override public String getVehicleType() { return "TRUCK"; }
}

public class A2 {
    @SuppressWarnings({"ConvertToTryWithResources", "ConvertToStringSwitch"})
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        VehicleParking[] parkings = new VehicleParking[n];
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();
            if (type.equals("BIKE")) {
                parkings[i] = new BikeParking(hours);
            } else if (type.equals("CAR")) {
                parkings[i] = new CarParking(hours);
            } else if (type.equals("TRUCK")) {
                parkings[i] = new TruckParking(hours);
            }
        }
        
        double total = 0;
        for (VehicleParking vp : parkings) {
            double charge = vp.calculateCharge();
            total += charge;
            System.out.printf("%s: %.2f\n", vp.getVehicleType(), charge);
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}