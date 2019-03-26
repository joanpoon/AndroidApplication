package lwtech.joan.lwtechjoanpoonstarbuzz;

public class Drink {

    private String name;
    private String description;
    private int imageResourceId;

    // drinks is an array of Drinks
    public static final Drink[] drinks = {
            new Drink("Latte", "A couple of espresso shots with steamed milk",
                    R.drawable.latte),
            new Drink("Cappuccino", "Espresso, hot milk, and steamed milk foam",
                    R.drawable.cappuccino),
            new Drink("Filter", "Highest quality beans roasted and brewed fresh",
                    R.drawable.filter),
            new Drink("Pumpkin Spice Latte", "Fall spice flavors, steamed milk, espresso, topped with whipped cream and pumpkin pie spice.",
                    R.drawable.pumpkin),
            new Drink("Matcha Latte", "Perfect way to bring matcha green tea and milk into your morning routine",
                    R.drawable.matcha),
            new Drink("Italian Cream Soda", "Your new summer favorite with cream and soda!",
                    R.drawable.soda)
    };

    // Each Drink has a name, description, and an image resource
    private Drink(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getDescription() { return description; }
    public String getName() {  return name; }
    public int getImageResourceId() { return imageResourceId; }
    public String toString() { return this.name; }
}