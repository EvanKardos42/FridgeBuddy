package enigmastudios.fridgebuddy;

import java.io.Serializable;

public class FoodItem implements Serializable {
    public static final String TABLE_NAME = "produce";
    public static final String COLUMN_id = "id";
    public static final String COLUMN_NAME = "name";

    private String id;
    private String name;
    private String image;

    public FoodItem(){}

    public FoodItem(String id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage(){
        return image;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
