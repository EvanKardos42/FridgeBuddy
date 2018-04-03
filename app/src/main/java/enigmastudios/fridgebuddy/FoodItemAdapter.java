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

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.FoodItemViewHolder> {
    private Context Ctx;
    private List<FoodItem> FoodItemList;

    public FoodItemAdapter(Context ctx, List<FoodItem> FoodItemList) {
        this.Ctx = ctx;
        this.FoodItemList = FoodItemList;
    }

    @Override
    public FoodItemAdapter.FoodItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.recipe_layout, null); // need to make a fooditem_layout!!!!!!!! ****************
        return new FoodItemAdapter.FoodItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FoodItemAdapter.FoodItemViewHolder holder, int position) {
        FoodItem FoodItem = FoodItemList.get(position);
        holder.textViewTitle.setText(FoodItem.getName());
        holder.textViewDesc.setText(FoodItem.getDescript());
        holder.textViewPrice.setText(String.valueOf(FoodItem.getPrice()));
        holder.textViewMovem.setText(String.valueOf(FoodItem.getMovement()));

        holder.imageView.setImageDrawable(Ctx.getResources().getDrawable(FoodItem.getImage(), null));


    }

    @Override
    public int getItemCount() {

        return FoodItemList.size();
    }

    class FoodItemViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textViewTitle, textViewDesc, textViewMovem, textViewPrice;

        public FoodItemViewHolder(View itemView) {
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
