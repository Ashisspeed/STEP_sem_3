class TrafficLight {
    @SuppressWarnings("FieldMayBeFinal")
    private String color;
    private final String id;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    @SuppressWarnings("ConvertToStringSwitch")
    public void next() {
        if (!color.equals("RED")) {
            if (color.equals("GREEN")) {
                color = "YELLOW";
            } else if (color.equals("YELLOW")) {
                color = "RED";
            } else {
                color = "GREEN";
            }
        }
    }

    public String getColor() {
        return color;
    }

    public String getId() {
        return id;
    }
}

public class A4 {
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println(t.getColor());
        t.next();
        System.out.println(t.getColor());
        t.next();
        System.out.println(t.getColor());
        t.next();
        System.out.println(t.getColor());
    }
}