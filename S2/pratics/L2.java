public class L2 {
    public static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            String name = fields[0].trim();
            String rollNo = fields[1].trim();
            String dept = fields[2].trim();
            System.out.println("Name: " + name + " | Roll No: " + rollNo + " | Dept: " + dept);
        }
    }
}