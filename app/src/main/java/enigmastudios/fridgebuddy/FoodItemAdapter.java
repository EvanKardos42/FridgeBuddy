package enigmastudios.fridgebuddy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
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
        FoodItem foodItem = FoodItemList.get(position);
        holder.textViewTitle.setText(foodItem.getName());
        try {
            Bitmap bitmap = BitmapFactory.decodeStream((InputStream) new URL(foodItem.getImage()).getContent());
            holder.imageView.setImageBitmap(bitmap);

        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
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
