import java.util.Scanner;

abstract class Bill {
    protected double amount;
    public Bill(double amount) { this.amount = amount; }
    public abstract double calculateFinalAmount();
    public abstract String getCustomerType();
}

class StudentBill extends Bill {
    public StudentBill(double amt) { super(amt); }
    @Override public double calculateFinalAmount() { return amount * 0.90; }
    @Override public String getCustomerType() { return "STUDENT"; }
}

class StaffBill extends Bill {
    public StaffBill(double amt) { super(amt); }
    @Override public double calculateFinalAmount() { return amount * 0.95; }
    @Override public String getCustomerType() { return "STAFF"; }
}

class GuestBill extends Bill {
    public GuestBill(double amt) { super(amt); }
    @Override public double calculateFinalAmount() { return amount + 10.0; }
    @Override public String getCustomerType() { return "GUEST"; }
}

public class A1 {
    @SuppressWarnings({"ConvertToTryWithResources", "ConvertToStringSwitch"})
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Bill[] bills = new Bill[n];
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amt = scanner.nextDouble();
            if (type.equals("STUDENT")) {
                bills[i] = new StudentBill(amt);
            } else if (type.equals("STAFF")) {
                bills[i] = new StaffBill(amt);
            } else if (type.equals("GUEST")) {
                bills[i] = new GuestBill(amt);
            }
        }
        
        double grandTotal = 0;
        for (Bill b : bills) {
            double finalAmt = b.calculateFinalAmount();
            grandTotal += finalAmt;
            System.out.printf("%s: %.2f\n", b.getCustomerType(), finalAmt);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}