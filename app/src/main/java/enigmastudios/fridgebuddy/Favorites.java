package enigmastudios.fridgebuddy;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by jerry on 3/20/18.
 */

public class Favorites extends Activity{

    private List<FoodItem> FoodList;
    private List<Recipe> RecipeList;
    //public View getView((int i , int ))
    //add food to an array
    public boolean addFavFood()//when star item
    {
        return true;
    }
    //get list of favorite foods
    public boolean getFavFood()
    {
        return true;
    }
    //remove
    public boolean removeFavFood()//when unstar item
    {
        return true;
    }
    public boolean addFavRecipe()
    {
        return true;
    }
    public boolean getFavRecipe()
    {
        return true;
    }
    public boolean removeFavRecipe()
    {
        return true;
    }
    //do this for fav recipes
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recipe_layout);

        final ImageView button = findViewById(R.id.favorite);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
            }
        });
    }

}