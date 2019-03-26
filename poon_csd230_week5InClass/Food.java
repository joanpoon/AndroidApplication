package lwtech.joan.lwtechjoanpoonstarbuzz;

public class Food {

    private String name;
    private String description;
    private int imageResourceId;

    // foods is an array of Foods
    public static final Food[] foods = {
            new Food("Banana", "A great fruit for your day.",
                    R.drawable.fruit),
            new Food("Cake", "Pick your favorite flavor!",
                    R.drawable.cakes),
            new Food("Cookies", "With chocolate chips!",
                    R.drawable.cookies),
            new Food("Banana 1", "A great fruit for your day.",
                    R.drawable.fruit),
            new Food("Cake 1 ", "Pick your favorite flavor!",
                    R.drawable.cakes),
            new Food("Cookies 1", "With chocolate chips!",
                    R.drawable.cookies)
    };

    // Each Food has a name, description, and an image resource
    private Food(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getDescription() { return description; }
    public String getName() {  return name; }
    public int getImageResourceId() { return imageResourceId; }
    public String toString() { return this.name; }
}