class Locker {
    private final int lockerNumber;
    private String combination;

    public Locker(int lockerNumber, String initialCombination) {
        this.lockerNumber = lockerNumber;
        this.combination = initialCombination;
    }

    public void changeCode(String currentCode, String newCode) {
        if (this.combination.equals(currentCode)) {
            this.combination = newCode;
            System.out.println("Success");
        } else {
            System.out.println("Rejected, code is still the same");
        }
    }

    public int getLockerNumber() {
        return lockerNumber;
    }
}

public class L4 {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
    }
}