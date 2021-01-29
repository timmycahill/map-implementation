

public class MapTesting {
    public static void main(String[] args) {
        try {
            MyMap<String, String> posse = new MyMap<>();
            posse.addEntry("Genaro", "Motivator");
            posse.addEntry("Cassie", "Muscle");
            posse.addEntry("Tim", "Top Earner");

            System.out.println("Genaro: " + posse.get("Genaro"));

            posse.updateEntry("Genaro", "Person In Management Position");

            System.out.println("Genaro: " + posse.get("Genaro"));

            posse.removeEntry("Genaro");

            System.out.println("Genaro: " + posse.get("Genaro"));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
