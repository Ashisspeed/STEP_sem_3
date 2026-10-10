import java.util.Scanner;

abstract class EmployeeBonus {
    protected String name;
    protected double salary;
    public EmployeeBonus(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public abstract double calculateBonus();
    public String getName() { return name; }
}

class FullTimeEmployee extends EmployeeBonus {
    public FullTimeEmployee(String n, double s) { super(n, s); }
    @Override public double calculateBonus() { return salary * 0.10; }
}

class PartTimeEmployee extends EmployeeBonus {
    public PartTimeEmployee(String n, double s) { super(n, s); }
    @Override public double calculateBonus() { return salary * 0.05; }
}

class InternEmployee extends EmployeeBonus {
    public InternEmployee(String n, double s) { super(n, s); }
    @Override public double calculateBonus() { return 2000.0; }
}

public class A4 {
    @SuppressWarnings({"ConvertToTryWithResources", "ConvertToStringSwitch"})
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        EmployeeBonus[] employees = new EmployeeBonus[n];
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();
            if (type.equals("FULLTIME")) {
                employees[i] = new FullTimeEmployee(name, salary);
            } else if (type.equals("PARTTIME")) {
                employees[i] = new PartTimeEmployee(name, salary);
            } else if (type.equals("INTERN")) {
                employees[i] = new InternEmployee(name, salary);
            }
        }
        
        double totalBonus = 0;
        for (EmployeeBonus eb : employees) {
            double bonus = eb.calculateBonus();
            totalBonus += bonus;
            System.out.printf("%s: %.2f\n", eb.getName(), bonus);
        }
        System.out.printf("Total Bonus: %.2f\n", totalBonus);
        scanner.close();
    }
}