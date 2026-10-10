
public class L1 {
    @SuppressWarnings("unused")
    static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }
}