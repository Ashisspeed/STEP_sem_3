import java.util.Scanner;

abstract class Payment {
    protected double amount;
    public Payment(double amount) {
        this.amount = amount;
    }
    public abstract double calculateAdjustedAmount();
    public abstract String getTypeName();
}

class CardPayment extends Payment {
    public CardPayment(double amount) { super(amount); }
    @Override
    public double calculateAdjustedAmount() { return amount * 1.02; }
    @Override
    public String getTypeName() { return "CARD"; }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) { super(amount); }
    @Override
    public double calculateAdjustedAmount() { return amount * 1.01; }
    @Override
    public String getTypeName() { return "WALLET"; }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) { super(amount); }
    @Override
    public double calculateAdjustedAmount() { return amount; }
    @Override
    public String getTypeName() { return "BANKTRANSFER"; }
}

public class L1 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Payment[] payments = new Payment[n];
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amt = scanner.nextDouble();
            if (!type.equals("CARD")) if (type.equals("WALLET")) {
                payments[i] = new WalletPayment(amt);
            } else if (type.equals("BANKTRANSFER")) {
                payments[i] = new BankTransferPayment(amt);
            } else {
                payments[i] = new CardPayment(amt);
            }
        }
        
        double total = 0;
        for (Payment p : payments) {
            double adj = p.calculateAdjustedAmount();
            total += adj;
            System.out.printf("%s: %.2f\n", p.getTypeName(), adj);
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}