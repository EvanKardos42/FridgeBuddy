package enigmastudios.fridgebuddy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jerry on 3/22/18.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>{

    private Context Ctx;
    private List<Recipes> RecipeList;

    public RecipeAdapter(Context ctx, List<Recipes> recipeList) {
        this.Ctx = ctx;
        this.RecipeList = recipeList;
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.recipe_layout, null);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        Recipes recipe = RecipeList.get(position);
        holder.textViewTitle.setText(recipe.getName());
        holder.textViewDesc.setText(recipe.getDescript());
        holder.textViewPrice.setText(String.valueOf(recipe.getPrice()));
        holder.textViewMovem.setText(String.valueOf(recipe.getMovement()));

        holder.imageView.setImageDrawable(Ctx.getResources().getDrawable(recipe.getImage(), null));


    }

    @Override
    public int getItemCount() {

        return RecipeList.size();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textViewTitle, textViewDesc, textViewMovem, textViewPrice;

        public RecipeViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        /*
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDesc = itemView.findViewById(R.id.textViewDesc);
            textViewMovem = itemView.findViewById(R.id.textViewMovem);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            */
        }
    }
}

