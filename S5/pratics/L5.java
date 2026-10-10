import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Candidate implements Comparable<Candidate> {
    String name;
    double cgpa;
    int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public double getCompositeScore() {
        return cgpa * 10 + codingScore * 0.5;
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }
}

public class L5 {
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 50;
    }

    @SuppressWarnings("unused")
    static String shortlistAndRank(Candidate[] candidates) {
        List<Candidate> shortlisted = new ArrayList<>();
        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                shortlisted.add(c);
            }
        }
        
        @SuppressWarnings("CollectionsToArray")
        Candidate[] listArray = shortlisted.toArray(new Candidate[0]);
        Arrays.sort(listArray);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listArray.length; i++) {
            Candidate c = listArray[i];
            sb.append((i + 1)).append(". ").append(c.name).append(" (").append(c.getCompositeScore()).append(")");
            if (i < listArray.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }
}