class PiggyBankObj {
    private double savings;
    private final String id;

    public PiggyBankObj(String id) {
        this.id = id;
        this.savings = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= savings) {
            savings -= amount;
        }
    }

    public double getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }
}

public class L1 {
    public static void main(String[] args) {
        PiggyBankObj pb = new PiggyBankObj("PB-1");
        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);
        System.out.println("Savings: " + pb.getSavings());
    }
}