import java.util.Scanner;

abstract class TicketBooking {
    protected int count;
    public static final double CONVENIENCE_FEE = 20.0;
    
    public TicketBooking(int count) { this.count = count; }
    public abstract double getPricePerTicket();
    public abstract String getSeatType();
    
    public double calculateTotal() {
        return (getPricePerTicket() + CONVENIENCE_FEE) * count;
    }
}

class RegularTicket extends TicketBooking {
    public RegularTicket(int count) { super(count); }
    @Override public double getPricePerTicket() { return 150.0; }
    @Override public String getSeatType() { return "REGULAR"; }
}

class PremiumTicket extends TicketBooking {
    public PremiumTicket(int count) { super(count); }
    @Override public double getPricePerTicket() { return 250.0; }
    @Override public String getSeatType() { return "PREMIUM"; }
}

class ReclinerTicket extends TicketBooking {
    public ReclinerTicket(int count) { super(count); }
    @Override public double getPricePerTicket() { return 400.0; }
    @Override public String getSeatType() { return "RECLINER"; }
}

public class A1 {
    @SuppressWarnings({"ConvertToTryWithResources", "ConvertToStringSwitch"})
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        TicketBooking[] bookings = new TicketBooking[n];
        
        for (int i = 0; i < n; i++) {
            String seat = scanner.next();
            int count = scanner.nextInt();
            if (seat.equals("REGULAR")) {
                bookings[i] = new RegularTicket(count);
            } else if (seat.equals("PREMIUM")) {
                bookings[i] = new PremiumTicket(count);
            } else if (seat.equals("RECLINER")) {
                bookings[i] = new ReclinerTicket(count);
            }
        }
        
        double total = 0;
        for (TicketBooking b : bookings) {
            double amt = b.calculateTotal();
            total += amt;
            System.out.printf("%s: %.2f\n", b.getSeatType(), amt);
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}