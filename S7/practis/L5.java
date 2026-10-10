class AttendanceSheet {
    @SuppressWarnings("FieldMayBeFinal")
    private String[] presentStudents;
    private int count;

    public AttendanceSheet(int maxSize) {
        presentStudents = new String[maxSize];
        count = 0;
    }

    public void markPresent(String name) {
        if (!isPresent(name) && count < presentStudents.length) {
            presentStudents[count++] = name;
        }
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }
}

public class L5 {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");
        System.out.println(sheet.getPresentCount());
        System.out.println(sheet.isPresent("Ben"));
    }
}