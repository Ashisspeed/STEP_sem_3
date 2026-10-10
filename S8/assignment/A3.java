import java.util.Scanner;

abstract class Room {
    protected int units;
    public Room(int units) { this.units = units; }
    public abstract double calculateBill();
    public abstract String getRoomType();
}

class SingleRoom extends Room {
    public SingleRoom(int u) { super(u); }
    @Override public double calculateBill() { return units * 8.0; }
    @Override public String getRoomType() { return "SINGLE"; }
}

class SharedRoom extends Room {
    @SuppressWarnings("FieldMayBeFinal")
    private int occupants;
    public SharedRoom(int u, int occupants) {
        super(u);
        this.occupants = occupants;
    }
    @Override public double calculateBill() { return (units * 6.0) / occupants; }
    @Override public String getRoomType() { return "SHARED"; }
}

class ACRoom extends Room {
    public ACRoom(int u) { super(u); }
    @Override public double calculateBill() { return (units * 10.0) + 200.0; }
    @Override public String getRoomType() { return "AC"; }
}

public class A3 {
    @SuppressWarnings({"ConvertToStringSwitch", "ConvertToTryWithResources"})
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Room[] rooms = new Room[n];
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();
            if (type.equals("SINGLE")) {
                rooms[i] = new SingleRoom(units);
            } else if (type.equals("SHARED")) {
                int occ = scanner.nextInt();
                rooms[i] = new SharedRoom(units, occ);
            } else if (type.equals("AC")) {
                rooms[i] = new ACRoom(units);
            }
        }
        
        double grandTotal = 0;
        for (Room r : rooms) {
            double bill = r.calculateBill();
            grandTotal += bill;
            System.out.printf("%s: %.2f\n", r.getRoomType(), bill);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}