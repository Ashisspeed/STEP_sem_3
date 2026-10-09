import java.time.LocalDate;
import java.util.Scanner;

abstract class Subscription {
    protected String name;
    protected LocalDate startDate;
    public Subscription(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }
    public abstract int getValidityDays();
    public String getName() { return name; }
    public LocalDate getStartDate() { return startDate; }
}

class BasicSubscription extends Subscription {
    public BasicSubscription(String n, LocalDate d) { super(n, d); }
    @Override public int getValidityDays() { return 30; }
}

class StandardSubscription extends Subscription {
    public StandardSubscription(String n, LocalDate d) { super(n, d); }
    @Override public int getValidityDays() { return 90; }
}

class PremiumSubscription extends Subscription {
    public PremiumSubscription(String n, LocalDate d) { super(n, d); }
    @Override public int getValidityDays() { return 365; }
}

public class A5 {
    @SuppressWarnings({"ConvertToTryWithResources", "ConvertToStringSwitch"})
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Subscription[] subs = new Subscription[n];
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            LocalDate start = LocalDate.parse(scanner.next());
            if (type.equals("BASIC")) {
                subs[i] = new BasicSubscription(name, start);
            } else if (type.equals("STANDARD")) {
                subs[i] = new StandardSubscription(name, start);
            } else if (type.equals("PREMIUM")) {
                subs[i] = new PremiumSubscription(name, start);
            }
        }
        
        for (Subscription sub : subs) {
            LocalDate renewal = sub.getStartDate().plusDays(sub.getValidityDays());
            System.out.println(sub.getName() + ": " + renewal);
        }
        scanner.close();
    }
}