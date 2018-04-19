package enigmastudios.fridgebuddy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * Created by evankardos on 3/8/18.
 */

public class FoodFragment extends Fragment {
    RecyclerView rc;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("List");
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.setHasOptionsMenu(true);
        View v = inflater.inflate(R.layout.food_fragment,container,false);
        rc = (RecyclerView) v.findViewById(R.id.rv_food);
        // Inflate the layout for this fragment
        rc.setLayoutManager(new GridLayoutManager(getActivity(),4));
        return inflater.inflate(R.layout.food_fragment,
                                container, false);
    }
    private class FoodHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener
    {
        private TextView mTitle;
        private ImageView mImage;
        private ImageButton mImageButton;
        private FoodItem mFood;
        public FoodHolder(LayoutInflater inflater, ViewGroup parent)
        {
            super(inflater.inflate(R.layout.food_card_view,parent,false));
            mTitle = (TextView) itemView.findViewById(R.id.name_food);
            mImage = (ImageView) itemView.findViewById(R.id.image_food);
            mImageButton = (ImageButton) itemView.findViewById(R.id.image_button_save);
            itemView.setOnClickListener(this);
        }

        public void bind(FoodItem food){
            mFood = food;
            mTitle.setText(mFood.getName());
            //mImage.setImageDrawable(mFood.getImage());
        }

        @Override
        public void onClick(View view) {

        }
    }

    private class FoodAdapter extends RecyclerView.Adapter<FoodHolder>{
        List<FoodItem> mList;

        public FoodAdapter(List<FoodItem> list){
            mList = list;
        }
        @Override
        public FoodHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new FoodHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(FoodHolder holder, int position) {
            FoodItem f = mList.get(position);
            holder.bind(f);
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }
    }
}
