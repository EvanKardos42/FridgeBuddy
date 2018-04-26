package enigmastudios.fridgebuddy;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by jerry on 4/24/18.
 */

public class RecipeLab {
    private static RecipeLab sRecipeLab;
    private List<Recipe> mRecipes;

    public static RecipeLab get(Context context)
    {
        if(sRecipeLab == null)
        {
            sRecipeLab = new RecipeLab(context);
        }
        return sRecipeLab;
    }

    private RecipeLab(Context context)
    {
        mRecipes = new ArrayList<>();
        for(int i =0; i< 100; i++) //100 should be the amount of recipes
        {
            Recipe recipe = new Recipe();
            recipe.setName("name");//pull the name from firebase recipe name
            recipe.setDescript("description");
            mRecipes.add(recipe);

        }
    }
    public List<Recipe> getRecipes()
    {
        return mRecipes;
    }
    public Recipe getRecipe(UUID id)
    {
        for(Recipe recipe : mRecipes)
        {
            if(recipe.getId().equals(id))
            {
                return recipe;
            }
        }
        return null;
    }

}
