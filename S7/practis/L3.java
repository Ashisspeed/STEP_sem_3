class NameTag {
    private final String firstName;
    private final String lastNameInitial;

    public NameTag(String fullName) {
        String[] parts = fullName.split(" ");
        this.firstName = parts[0];
        this.lastNameInitial = parts.length > 1 ? parts[1].substring(0, 1) : "";
    }

    public String getNickname() {
        return firstName + " " + lastNameInitial + ".";
    }
}

public class L3 {
    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname());
    }
}