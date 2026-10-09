import java.util.Scanner;

abstract class LibraryItemFine {
    protected String title;
    protected int daysLate;
    public LibraryItemFine(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }
    public abstract double calculateFine();
    public String getTitle() { return title; }
}

class BookFine extends LibraryItemFine {
    public BookFine(String title, int daysLate) { super(title, daysLate); }
    @Override public double calculateFine() { return daysLate * 2.0; }
}

class DvdFine extends LibraryItemFine {
    public DvdFine(String title, int daysLate) { super(title, daysLate); }
    @Override public double calculateFine() {
        return Math.min(daysLate * 5.0, 50.0);
    }
}

class MagazineFine extends LibraryItemFine {
    public MagazineFine(String title, int daysLate) { super(title, daysLate); }
    @Override public double calculateFine() { return daysLate * 1.0; }
}

public class L3 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        LibraryItemFine[] items = new LibraryItemFine[n];
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String title = scanner.next();
            int days = scanner.nextInt();
            switch (type) {
                case "BOOK":
                    items[i] = new BookFine(title, days);
                    break;
                case "DVD":
                    items[i] = new DvdFine(title, days);
                    break;
                case "MAGAZINE":
                    items[i] = new MagazineFine(title, days);
                    break;
                default:
                    break;
            }
        }
        
        double totalFines = 0;
        for (LibraryItemFine item : items) {
            double fine = item.calculateFine();
            totalFines += fine;
            System.out.printf("%s: %.2f\n", item.getTitle(), fine);
        }
        System.out.printf("Total Fines: %.2f\n", totalFines);
        scanner.close();
    }
}