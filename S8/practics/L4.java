import java.util.Scanner;

abstract class Question {
    protected String text, correctAnswer, studentAnswer;
    protected double points;
    public Question(String text, String correctAnswer, String studentAnswer, double points) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }
    public abstract double grade();
    public abstract String getTypeName();
}

class MCQQuestion extends Question {
    public MCQQuestion(String t, String c, String s, double p) { super(t, c, s, p); }
    @Override public double grade() {
        return studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim()) ? points : 0.0;
    }
    @Override public String getTypeName() { return "MCQ"; }
}

class TFQuestion extends Question {
    public TFQuestion(String t, String c, String s, double p) { super(t, c, s, p); }
    @Override public double grade() {
        return studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim()) ? points : 0.0;
    }
    @Override public String getTypeName() { return "TF"; }
}

class EssayQuestion extends Question {
    public EssayQuestion(String t, String c, String s, double p) { super(t, c, s, p); }
    @Override public double grade() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        String studentLower = studentAnswer.toLowerCase();
        for (String kw : keywords) {
            String trimmedKw = kw.trim().toLowerCase();
            if (!trimmedKw.isEmpty() && studentLower.contains(trimmedKw)) {
                matchCount++;
            }
        }
        if (matchCount >= 2) return points * 0.75;
        if (matchCount == 1) return points * 0.50;
        return 0.0;
    }
    @Override public String getTypeName() { return "ESSAY"; }
}

public class L4 {
    @SuppressWarnings({"ConvertToStringSwitch", "ConvertToTryWithResources"})
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Question[] questions = new Question[n];
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String text = scanner.next();
            String correct = scanner.next();
            String student = scanner.next();
            double pts = scanner.nextDouble();
            
            if (type.equals("MCQ")) {
            } else if (type.equals("TF")) {
                questions[i] = new TFQuestion(text, correct, student, pts);
            } else if (type.equals("ESSAY")) {
                questions[i] = new EssayQuestion(text, correct, student, pts);
            } else {
                questions[i] = new MCQQuestion(text, correct, student, pts);
            }
        }
        
        double totalScore = 0;
        for (Question q : questions) {
            double score = q.grade();
            totalScore += score;
            System.out.printf("%s: %.2f\n", q.getTypeName(), score);
        }
        System.out.printf("Total Score: %.2f\n", totalScore);
        scanner.close();
    }
}