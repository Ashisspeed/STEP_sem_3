public class L2 {
    public static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int firstMismatch = -1;
        int length = original.length();

        for (int i = 0; i < length; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i + 1; // 1-based index for the user
            }
        }

        double accuracy = ((double) matched / length) * 100;
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | ", matched, length, accuracy);

        if (firstMismatch != -1) {
            System.out.printf("First Mismatch at position %d ('%c' vs '%c')\n",
                    firstMismatch, original.charAt(firstMismatch - 1), typed.charAt(firstMismatch - 1));
        } else {
            System.out.println("No Mismatches");
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}