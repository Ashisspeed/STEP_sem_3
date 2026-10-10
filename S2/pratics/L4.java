public class L4 {
    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }
        String last4 = phone.substring(6);
        StringBuilder sb = new StringBuilder("XXXXXX");
        sb.append("-").append(last4);
        return sb.toString();
    }
}