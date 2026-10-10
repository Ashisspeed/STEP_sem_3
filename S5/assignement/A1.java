public class A1 {
    @SuppressWarnings("unused")
    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (captainIndex >= 0 && captainIndex < playerScores.length) {
            playerScores[captainIndex] *= 2.0;
        }
        if (viceCaptainIndex >= 0 && viceCaptainIndex < playerScores.length) {
            playerScores[viceCaptainIndex] *= 1.5;
        }
    }
}