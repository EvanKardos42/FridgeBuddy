package enigmastudios.fridgebuddy;

import java.util.UUID;

/**
 * Created by jerry on 3/22/18.
 */

public class Recipe {

    private UUID id;

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImage(int image) {
        this.image = image;
    }

    private String name, descript;
    private String ingredients;
    private double price;
    private int image;
    //also need image the id of where ever we get or stock


    public Recipe(UUID id, String name, String descript, String ingredients, double price, int image) {
        this.id = id;
        this.name = name;
        this.descript = descript;
        this.ingredients = ingredients;
        this.price = price;
        this.image = image;
    }
    public Recipe() { //not sure about this empty
        this.id = id;
        this.name = name;
        this.descript = descript;
        this.ingredients = ingredients;
        this.price = price;
        this.image = image;
    }


    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescript() {
        return descript;
    }

    public String getIngredients() {
        return ingredients;
    }

    public double getPrice() {
        return price;
    }

    public int getImage(){
        return image;
    }
}
