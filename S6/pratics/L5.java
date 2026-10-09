class CollegeStudent {
    @SuppressWarnings("unused")
    String name;
    @SuppressWarnings("unused")
    int attendance;
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    public CollegeStudent(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class L5 {
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        CollegeStudent s1 = new CollegeStudent("Alice", 90);
        @SuppressWarnings("unused")
        CollegeStudent s2 = new CollegeStudent("Bob", 85);

        CollegeStudent.printCollegeInfo();
    }
}