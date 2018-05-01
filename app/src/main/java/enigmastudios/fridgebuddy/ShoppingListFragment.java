package enigmastudios.fridgebuddy;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by evankardos on 3/8/18.
 */

public class ShoppingListFragment extends Fragment {

    ListView ls;
    CustomAdapter ca;
    ArrayList<FoodItem> values = new ArrayList<FoodItem>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Produce");
    final static String TAG_FOOD = "FRIDGE.BUDDY.FOOD.POSITION";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.food_fragment, container, false);
        ls = rootView.findViewById(R.id.listThing);
        ca =  new CustomAdapter(getActivity(),R.layout.food_card_view,values);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    FoodItem food = child.getValue(FoodItem.class);
                    food.setId(child.getKey());
                    System.out.println(food.getName());
                    values.add(food);
                }
                ca.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        ls.setAdapter(ca);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(getActivity(),FoodDisplayInfo.class);
//                intent.putExtra(TAG_FOOD,values.get(position));
//                startActivity(intent);
            }
        });
        return rootView;
    }

    public class CustomAdapter extends ArrayAdapter<FoodItem>{
        private final List<FoodItem> foods;

        public CustomAdapter(Context context, int resource, ArrayList<FoodItem> foods) {
            super(context, resource, foods);
            this.foods = foods;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            FoodItem food = foods.get(position);
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            @SuppressLint("ViewHolder") View row = inflater.inflate(R.layout.food_card_view, null);
// Set the text
            TextView textView = (TextView) row.findViewById(R.id.rowText);
            textView.setText(food.getName());

// Set the image
            ImageView iv = row.findViewById(R.id.rowImage);
            new DownLoadImageTask(iv).execute(food.getImage());
            return row;
        }
    }
}