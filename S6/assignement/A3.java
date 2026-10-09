class EmployeeProfile {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    public EmployeeProfile(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public EmployeeProfile(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    public void printProfile() {
        System.out.println(empId + " -| " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }
}

public class A3 {
    public static void main(String[] args) {
        EmployeeProfile permEmp = new EmployeeProfile("E-101", "Divya", 65000);
        EmployeeProfile internEmp = new EmployeeProfile("E102", "Arjun");

        permEmp.printProfile();
        internEmp.printProfile();
    }
}