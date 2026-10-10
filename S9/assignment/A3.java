import java.util.Scanner;

interface BusUser {
    double getTransportFee();
}

abstract class StudentFee {
    protected String name;
    public StudentFee(String name) { this.name = name; }
    public abstract double calculateTuition();
    public String getName() { return name; }
}

class DayScholar extends StudentFee implements BusUser {
    public DayScholar(String name) { super(name); }
    @Override public double calculateTuition() { return 40000.0; }
    @Override public double getTransportFee() { return 12000.0; }
}

class Hosteller extends StudentFee {
    public Hosteller(String name) { super(name); }
    @Override public double calculateTuition() { return 40000.0 + 60000.0; }
}

class ScholarStudent extends StudentFee implements BusUser {
    public ScholarStudent(String name) { super(name); }
    @Override public double calculateTuition() { return 20000.0; }
    @Override public double getTransportFee() { return 12000.0; }
}

public class A3 {
    @SuppressWarnings({"ConvertToTryWithResources", "ConvertToStringSwitch"})
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        StudentFee[] students = new StudentFee[n];
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            if (type.equals("DAY_SCHOLAR")) {
                students[i] = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                students[i] = new Hosteller(name);
            } else if (type.equals("SCHOLAR")) {
                students[i] = new ScholarStudent(name);
            }
        }
        
        double totalCollected = 0;
        for (StudentFee s : students) {
            double fee = s.calculateTuition();
            if (s instanceof BusUser busUser) {
                fee += busUser.getTransportFee();
            }
            totalCollected += fee;
            System.out.printf("%s: %.2f\n", s.getName(), fee);
        }
        System.out.printf("Total Collected: %.2f\n", totalCollected);
        scanner.close();
    }
}