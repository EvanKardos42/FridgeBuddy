package enigmastudios.fridgebuddy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by jerry on 3/22/18.
 */

public class Recipe implements Serializable {

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }
    public void setCategory(ArrayList<String> category) { this.category = category; }

    public void setImage(String image) {
        this.image = image;
    }

    private String title, url;
    private ArrayList<String> ingredients;
    private String image;

    private ArrayList<String> category;
    //also need image the id of where ever we get or stock


    public Recipe(String id, String title, String url, ArrayList<String> ingredients,ArrayList<String> category, String image) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.ingredients = ingredients;
        this.category = category;
        this.image = image;
    }
    public Recipe() { //not sure about this empty
        this.id = id;
        this.title = title;
        this.url = url;
        this.ingredients = ingredients;
        this.image = image;
        this.category = category;
    }


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public String getImage(){ return image; }
    public ArrayList<String> getCategory() { return category; }
}