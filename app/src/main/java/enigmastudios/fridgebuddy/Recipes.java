package enigmastudios.fridgebuddy;

/**
 * Created by jerry on 3/22/18.
 */

public class Recipes {

    private int id;
    private String name, descript;
    private double movement;
    private double price;
    private int image;
    //also need image the id of whereever we get or stock


    public Recipes(int id, String name, String descript, double movement, double price, int image) {
        this.id = id;
        this.name = name;
        this.descript = descript;
        this.movement = movement;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescript() {
        return descript;
    }

    public double getMovement() {
        return movement;
    }

    public double getPrice() {
        return price;
    }

    public int getImage(){
        return image;
    }
}
