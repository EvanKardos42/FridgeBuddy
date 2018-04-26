package enigmastudios.fridgebuddy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by jerry on 4/19/18.
 */

public class RecipeFragment extends Fragment {
    private RecyclerView mRecipeRecyclerView;
    private RecipeAdapter mAdapter;

    //@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_recipe_list, container, false);

        mRecipeRecyclerView = (RecyclerView) view.findViewById(R.id.recipe_recycler_view);//look into this p.172
        //return super.onCreateView(inflater, container, savedInstanceState);
        mRecipeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        UpdateUI();

        return view;
    }

    private void UpdateUI()
    {
        //CrimeLab crimeLab - CrimeLab.get(getActivity()):  ***need to add the equivlant from firebase
        //List<Recipe> recipes = recipeLab.getRecipes();

        //mAdapter = new RecipeAdapter(recipes);
        mRecipeRecyclerView.setAdapter(mAdapter);

    }

    public class RecipeHolder extends RecyclerView.ViewHolder
    {
        public RecipeHolder(LayoutInflater inflater, ViewGroup parent)
        {
            super(inflater.inflate(R.layout.recipe_list, parent,false)); //double check this list is right
        }
    }
    private class RecipeAdapter extends RecyclerView.Adapter<RecipeHolder>
    {
        private List <Recipe> mRecipe;

        public  RecipeAdapter(List<Recipe> recipes)
        {
            mRecipe = recipes;
        }

        @Override
        public RecipeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from((getActivity()));
            return new RecipeHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(RecipeHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return mRecipe.size();
        }
    }
}
