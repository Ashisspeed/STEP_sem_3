import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Player implements Comparable<Player> {
    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public double getFantasyPoints() {
        return battingAverage;
    }

    @Override
    public int compareTo(Player other) {
        return Double.compare(other.getFantasyPoints(), this.getFantasyPoints());
    }
}

public class A5 {
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    @SuppressWarnings("unused")
    static String draftAndRank(Player[] players) {
        List<Player> draftable = new ArrayList<>();
        for (Player p : players) {
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                draftable.add(p);
            }
        }

        @SuppressWarnings("CollectionsToArray")
        Player[] listArray = draftable.toArray(new Player[0]);
        Arrays.sort(listArray);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listArray.length; i++) {
            sb.append((i + 1)).append(". ").append(listArray[i].name);
            if (i < listArray.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }
}