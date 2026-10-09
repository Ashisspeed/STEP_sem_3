class L3TrafficSignal {
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) return;
        
        char longestColor = signalLog.charAt(0);
        int maxLength = 1, currentLength = 1;
        
        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                currentLength++;
            } else {
                currentLength = 1;
            }
            
            if (currentLength > maxLength) {
                maxLength = currentLength;
                longestColor = signalLog.charAt(i);
            }
        }
        
        System.out.println("Longest Streak: '" + longestColor + "' repeated " + maxLength + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }
}