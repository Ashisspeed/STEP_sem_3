import java.util.Scanner;

abstract class Staff {
    protected String name;
    public Staff(String name) { this.name = name; }
    public abstract double calculatePay();
    public String getName() { return name; }
}

class FullTimeStaff extends Staff {
    private final double weeklySalary;
    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }
    @Override public double calculatePay() { return weeklySalary; }
}

class HourlyStaff extends Staff {
    private final double hours;
    private final double rate;
    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }
    @Override public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return (40 * rate) + ((hours - 40) * rate * 1.5);
        }
    }
}

class InternStaff extends Staff {
    private final double stipend;
    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }
    @Override public double calculatePay() { return stipend; }
}

public class L2 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Staff[] staffList = new Staff[n];
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            switch (type) {
                case "FULLTIME" -> {
                    double sal = scanner.nextDouble();
                    staffList[i] = new FullTimeStaff(name, sal);
                }
                case "HOURLY" -> {
                    double hrs = scanner.nextDouble();
                    double rt = scanner.nextDouble();
                    staffList[i] = new HourlyStaff(name, hrs, rt);
                }
                case "INTERN" -> {
                    double stip = scanner.nextDouble();
                    staffList[i] = new InternStaff(name, stip);
                }
                default -> {
                }
            }
        }
        
        double totalPayroll = 0;
        for (Staff s : staffList) {
            double pay = s.calculatePay();
            totalPayroll += pay;
            System.out.printf("%s: %.2f\n", s.getName(), pay);
        }
        System.out.printf("Total Payroll: %.2f\n", totalPayroll);
        scanner.close();
    }
}