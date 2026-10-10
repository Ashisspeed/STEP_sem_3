class CompanyEmployee {
    @SuppressWarnings("unused")
    String empName;
    @SuppressWarnings("unused")
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class A5 {
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        CompanyEmployee e1 = new CompanyEmployee("Alice", 40000);
        @SuppressWarnings("unused")
        CompanyEmployee e2 = new CompanyEmployee("Bob", 50000);
        @SuppressWarnings("unused")
        CompanyEmployee e3 = new CompanyEmployee("Charlie", 60000);

        CompanyEmployee.printCompanyInfo();
    }
}