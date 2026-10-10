import java.util.Scanner;

interface SaverMode {
    boolean supportsSaver();
}

abstract class Appliance {
    protected double hours;
    protected boolean saverRequested;
    
    public Appliance(double hours, boolean saverRequested) {
        this.hours = hours;
        this.saverRequested = saverRequested;
    }
    
    public abstract double getPowerWatts();
    public abstract String getAppName();
    
    public double calculateUnits() {
        double units = (getPowerWatts() * hours) / 1000.0;
        if (saverRequested) {
            units *= 0.75;
        }
        return units;
    }
}

class Fridge extends Appliance {
    public Fridge(double h, boolean s) { super(h, s); }
    @Override public double getPowerWatts() { return 150.0; }
    @Override public String getAppName() { return "FRIDGE"; }
}

class ACAppliance extends Appliance implements SaverMode {
    public ACAppliance(double h, boolean s) { super(h, s); }
    @Override public double getPowerWatts() { return 1500.0; }
    @Override public String getAppName() { return "AC"; }
    @Override public boolean supportsSaver() { return true; }
}

class TVAppliance extends Appliance {
    public TVAppliance(double h, boolean s) { super(h, s); }
    @Override public double getPowerWatts() { return 100.0; }
    @Override public String getAppName() { return "TV"; }
}

class WasherAppliance extends Appliance implements SaverMode {
    public WasherAppliance(double h, boolean s) { super(h, s); }
    @Override public double getPowerWatts() { return 500.0; }
    @Override public String getAppName() { return "WASHER"; }
    @Override public boolean supportsSaver() { return true; }
}

public class A5 {
    @SuppressWarnings({"ConvertToTryWithResources", "ConvertToStringSwitch"})
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        String[] types = new String[n];
        double[] hours = new double[n];
        boolean[] savers = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            types[i] = scanner.next();
            hours[i] = scanner.nextDouble();
            if (scanner.hasNext()) {
                String nextToken = scanner.next();
                if (nextToken.equals("SAVER")) {
                    savers[i] = true;
                }
            }
        }
        
        double totalCost = 0;
        for (int i = 0; i < n; i++) {
            String type = types[i];
            double h = hours[i];
            boolean saver = savers[i];
            
            Appliance app = null;
            if (type.equals("FRIDGE")) app = new Fridge(h, saver);
            else if (type.equals("AC")) app = new ACAppliance(h, saver);
            else if (type.equals("TV")) app = new TVAppliance(h, saver);
            else if (type.equals("WASHER")) app = new WasherAppliance(h, saver);

            if (app == null) {
                continue;
            }

            if (saver && !(app instanceof SaverMode)) {
                System.out.println(app.getAppName() + ": saver mode not supported");
            } else {
                double units = app.calculateUnits();
                double cost = units * 8.0;
                totalCost += cost;
                System.out.printf("%s: Units=%.2f Cost=%.2f\n", app.getAppName(), units, cost);
            }
        }
        System.out.printf("Total Cost: %.2f\n", totalCost);
        scanner.close();
    }
}